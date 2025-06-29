package daos.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import DTO.FiltroReporteBloqueoDTO;
import DTO.FiltroReporteCarrerasDTO;
import DTO.FiltrosReporteCentroComputoDTO;
import DTO.ReporteBloqueoDTO;
import DTO.ReporteCarrerasDTO;
import DTO.ReporteCentroComputoDTO;
import daos.IConexionBD;
import daos.IReporteDAO;
import excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ReporteDAO implements IReporteDAO {

    private final IConexionBD conexionBD;

    public ReporteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<ReporteCentroComputoDTO> generarReporteCentroComputo(FiltrosReporteCentroComputoDTO filtro) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            StringBuilder codigoJPQL = new StringBuilder();
            codigoJPQL.append("SELECT new DTO.ReporteCentroComputoDTO(")
                    .append("lab.nombre, comp.numero, ")
                    .append("COUNT(DISTINCT est.idEstudiante), ")
                    .append("SUM(res.tiempoReserva), ")
                    .append("CAST(FUNCTION('TIMESTAMPDIFF', 'MINUTE', lab.horaInicio, lab.horaFin), )AS long")
                    .append("CAST(FUNCTION('DATE', res.fechaInicio) ) AS long") 
                    .append(") ") 
                    .append("FROM EstudianteReservaComputadoraDominio res ")
                    .append("JOIN res.computadoraReservas comp ")
                    .append("JOIN comp.laboratorio lab ")
                    .append("JOIN res.estudianteReserva est ")
                    .append("JOIN est.carrera car ")
                    .append("WHERE res.fechaInicio BETWEEN :inicio AND :fin ");

            if (filtro.getLaboratorio() != null && !filtro.getLaboratorio().isEmpty()) {
                codigoJPQL.append("AND lab.nombre = :nombreLab ");
            }

            if (filtro.getCarreras() != null && !filtro.getCarreras().isEmpty()) {
                codigoJPQL.append("AND car.nombre IN :nombresCarreras ");
            }

            codigoJPQL.append("GROUP BY lab.nombre, comp.numero, FUNCTION('DATE', res.fechaInicio) ");

            TypedQuery<ReporteCentroComputoDTO> query = manager.createQuery(codigoJPQL.toString(), ReporteCentroComputoDTO.class);

            query.setParameter("inicio", filtro.getFechaInicio());
            query.setParameter("fin", filtro.getFechaFin());

            if (filtro.getLaboratorio() != null && !filtro.getLaboratorio().isEmpty()) {
                query.setParameter("nombreLab", filtro.getLaboratorio());
            }

            if (filtro.getCarreras() != null && !filtro.getCarreras().isEmpty()) {
                query.setParameter("nombresCarreras", filtro.getCarreras());
            }

            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new PersistenciaException("Error al consultar el reporte.");
        } finally {
            manager.close();
        }
    }

    @Override
    public List<ReporteCarrerasDTO> generarReporteCarreras(FiltroReporteCarrerasDTO filtro) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            StringBuilder codigoJPQL = new StringBuilder();
            codigoJPQL.append("SELECT new dto.ReporteCarrerasDTO(")
                    .append("c.nombre, ")
                    .append("SUM(res.tiempoReserva), ")
                    .append("COUNT(DISTINCT est.id), ")
                    .append("DATE(res.fechaInicio)) ")
                    .append("FROM EstudianteReservaComputadoraDominio res ")
                    .append("JOIN res.estudianteReserva est ")
                    .append("JOIN est.carrera car ")
                    .append("WHERE res.fechaInicio BETWEEN :inicio AND :fin ");

            if (filtro.getCarreras() != null && !filtro.getCarreras().isEmpty()) {
                codigoJPQL.append("AND car.nombre IN :nombresCarreras ");
            }
            TypedQuery<ReporteCarrerasDTO> query = manager.createQuery(codigoJPQL.toString(), ReporteCarrerasDTO.class);
            query.setParameter("inicio", filtro.getFechaInicio());
            query.setParameter("fin", filtro.getFechaFin());
            if (filtro.getCarreras() != null && !filtro.getCarreras().isEmpty()) {
                query.setParameter("nombresCarreras", filtro.getCarreras());
            }
            return query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al consultar el reporte.");
        } finally {
            manager.close();
        }
    }

    @Override
    public List<ReporteBloqueoDTO> generarReporteBloqueo(FiltroReporteBloqueoDTO filtro) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            StringBuilder codigoJPQL = new StringBuilder();
            codigoJPQL.append("SELECT new dto.ReporteBloqueoDTO(")
                    .append("CONCAT(CONCAT(CONCAT(est.nombres, ' '), est.apellidoPaterno), CONCAT(' ', est.apellidoMaterno)), ")
                    .append("b.FechaBloqueo, ")
                    .append("b.FechaLiberacion, ")
                    .append("b.motivo) ")
                    .append("FROM BloqueoDominio b ")
                    .append("JOIN b.estudiante est ")
                    .append("WHERE b.FechaBloqueo BETWEEN :inicio AND :fin ");

            TypedQuery<ReporteBloqueoDTO> query = manager.createQuery(codigoJPQL.toString(), ReporteBloqueoDTO.class);
            query.setParameter("inicio", filtro.getFechaInicio());
            query.setParameter("fin", filtro.getFechaFin());
            return query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al consultar el reporte.");
        } finally {
            manager.close();
        }
    }

}
