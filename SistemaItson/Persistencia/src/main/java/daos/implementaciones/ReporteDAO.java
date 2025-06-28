package daos.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.FiltrosReporteCentroComputoDTO;
import DTO.ReporteCentroComputoDTO;
import daos.IConexionBD;
import daos.IReporteDAO;
import excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ReporteDAO implements IReporteDAO{

    private final IConexionBD conexionBD;

    public ReporteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<ReporteCentroComputoDTO> generarReporteCentroComputo(FiltrosReporteCentroComputoDTO filtro) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            StringBuilder codigoJPQL = new StringBuilder();
            codigoJPQL.append("SELECT new dto.ReporteCentroComputoDTO(")
                    .append("lab.nombre, comp.numeroComputadora, ")
                    .append("COUNT(DISTINCT est.id), SUM(res.tiempoReserva), ")
                    .append("(TIMESTAMPDIFF(MINUTE, lab.horaApertura, lab.horaCierre) - SUM(res.tiempoReserva)), ")
                    .append("DATE(res.fechaInicio)) ")
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

            codigoJPQL.append("GROUP BY lab.nombre, comp.numeroComputadora, DATE(res.fechaInicio) ");

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
            throw new PersistenciaException("Error al consultar el reporte.");
        } finally {
            manager.close();
        }
    }
}
