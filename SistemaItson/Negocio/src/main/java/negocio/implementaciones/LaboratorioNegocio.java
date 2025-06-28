package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import DTO.FiltroDTO;
import DTO.LaboratorioDTO;
import DTO.NuevoLaboratorioDTO;
import DTO.TablaLaboratorioDTO;
import daos.ILaboratorioDAO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.ILaboratorioNegocio;
import org.mindrot.jbcrypt.BCrypt;

public class LaboratorioNegocio implements ILaboratorioNegocio {

    private final String UNIDAD_DEFAULT = "Selecciona...";
    private final ILaboratorioDAO laboratorioDAO;

    public LaboratorioNegocio(ILaboratorioDAO laboratorioDAO) {
        this.laboratorioDAO = laboratorioDAO;
    }

    /**
     * Guarda un nuevo laboratorio después de validar sus datos y encriptar la
     * contraseña.
     *
     * @param nuevoLaboratorio DTO con los datos del nuevo laboratorio.
     * @return El laboratorio guardado como dominio.
     * @throws NegocioException Si ocurre un error de validación o persistencia.
     */
    @Override
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException {
        try {
            validarNuevoLaboratorio(nuevoLaboratorio);
            nuevoLaboratorio.setContrasenaHash(encriptarContrasena(nuevoLaboratorio));
            return laboratorioDAO.guardar(nuevoLaboratorio);
        } catch (PersistenciaException ex) {
            Logger.getLogger(LaboratorioNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ocurrió un error al guardar el laboratorio.");
        }
    }

    /**
     * Busca un laboratorio por su ID.
     *
     * @param id Identificador del laboratorio.
     * @return DTO con los datos del laboratorio encontrado.
     * @throws NegocioException Si ocurre un error de persistencia.
     */
    @Override
    public LaboratorioDTO buscarPorId(int id) throws NegocioException {
        try {
            return laboratorioDAO.buscarPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Modifica un laboratorio existente tras validar que existe y sus horarios.
     *
     * @param laboratorio DTO con los datos actualizados.
     * @return Dominio del laboratorio modificado.
     * @throws NegocioException Si no existe el laboratorio o hay error.
     */
    @Override
    public LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws NegocioException {
        try {
            LaboratorioDTO lab = laboratorioDAO.buscarPorId(laboratorio.getIdLaboratorios());
            if (lab == null) {
                throw new NegocioException("Error al buscar el Laboratorio a modificar.");
            }
            validarHorario(laboratorio.getHoraInicio(), laboratorio.getHoraFin());
            return laboratorioDAO.modificar(laboratorio);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Busca laboratorios según el filtro.
     *
     * @param filtro DTO con criterios de filtrado.
     * @return Lista de laboratorios en formato tabla.
     * @throws NegocioException Si ocurre un error de persistencia.
     */
    @Override
    public List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        try {
            return laboratorioDAO.buscarTabla(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Valida que no exista ya un laboratorio con el mismo nombre.
     *
     * @param nuevoLaboratorio DTO con el laboratorio a validar.
     * @throws NegocioException Si ya existe un laboratorio con ese nombre.
     */
    private void existeLaboratorio(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException {
        try {
            laboratorioDAO.existePorNombre(nuevoLaboratorio.getNombre());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ya existe un laboratorio con ese nombre.");
        }
    }

    /**
     * Valida que las horas de inicio y cierre sean correctas.
     *
     * @param horaInicio Hora de inicio.
     * @param horaFin Hora de cierre.
     * @throws NegocioException Si las horas son nulas o mal ordenadas.
     */
    private void validarHorario(Date horaInicio, Date horaFin) throws NegocioException {
        if (horaInicio == null || horaFin == null) {
            throw new NegocioException("Las horas de inicio y cierre son obligatorias.");
        }
        if (!horaInicio.before(horaFin)) {
            throw new NegocioException("La hora de inicio debe ser anterior a la hora de cierre.");
        }
    }

    /**
     * Valida que la unidad académica no sea la por defecto inválida.
     *
     * @param nuevoLaboratorio DTO con el laboratorio a validar.
     * @throws NegocioException Si la unidad académica es inválida.
     */
    private void validarUnidadAcademica(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException {
        if (nuevoLaboratorio.getUnidad().equals(UNIDAD_DEFAULT)) {
            throw new NegocioException("Unidad Académica no válida.");
        }
    }

    /**
     * Valida la contraseña del laboratorio, que sea mayor a 6 caracteres y
     * contenga al menos un número.
     *
     * @param nuevoLaboratorio DTO con el laboratorio a validar.
     * @throws NegocioException Si la contraseña no cumple con los requisitos.
     */
    private void validarContraseña(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException {
        if (nuevoLaboratorio.getContrasena().length < 6) {
            throw new NegocioException("La contraseña debe tener al menos 6 caracteres.");
        }
        boolean contieneNumero = new String(nuevoLaboratorio.getContrasena()).matches(".*\\d.*");
        if (!contieneNumero) {
            throw new NegocioException("La contraseña debe contener al menos un número.");
        }
    }

    /**
     * Encripta la contraseña del laboratorio usando BCrypt y limpia la
     * contraseña original de memoria.
     *
     * @param nuevoLaboratorio DTO con la contraseña a encriptar.
     * @return Hash de la contraseña.
     * @throws NegocioException Si ocurre un error en el cifrado.
     */
    private String encriptarContrasena(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException {
        try {
            String textoPlano = new String(nuevoLaboratorio.getContrasena());
            String hash = BCrypt.hashpw(textoPlano, BCrypt.gensalt());
            nuevoLaboratorio.limpiarContrasena();
            return hash;
        } catch (Exception ex) {
            throw new NegocioException("Error al guardar.");
        }
    }

    /**
     * Valida el nuevo laboratorio en todos sus campos relevantes.
     *
     * @param nuevoLaboratorio DTO a validar.
     * @throws NegocioException Si alguna validación falla.
     */
    private void validarNuevoLaboratorio(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException {
        existeLaboratorio(nuevoLaboratorio);
        validarHorario(nuevoLaboratorio.getHoraInicio(), nuevoLaboratorio.getHoraCierre());
        validarUnidadAcademica(nuevoLaboratorio);
        validarContraseña(nuevoLaboratorio);
    }

    /**
     * Obtiene todos los laboratorios.
     *
     * @return Lista de laboratorios en dominio.
     * @throws NegocioException Si ocurre un error de persistencia.
     */
    @Override
    public List<LaboratorioDominio> obtenerLaboratorios() throws NegocioException {
        try {
            return laboratorioDAO.obtenerLaboratorios();
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Obtiene un laboratorio por su nombre.
     *
     * @param nombre Nombre del laboratorio.
     * @return Dominio del laboratorio encontrado.
     * @throws NegocioException Si ocurre un error al buscar o no existe.
     */
    @Override
    public LaboratorioDominio obtenerPorNombre(String nombre) throws NegocioException {
        try {
            return laboratorioDAO.obtenerPorNombre(nombre);
        } catch (PersistenciaException ex) {
            Logger.getLogger(LaboratorioNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ocurrió un error al buscar el laboratorio por nombre");
        }
    }

}
