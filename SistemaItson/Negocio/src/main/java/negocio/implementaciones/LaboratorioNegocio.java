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


public class LaboratorioNegocio implements ILaboratorioNegocio{

    private final String UNIDAD_DEFAULT = "Selecciona...";
    private final ILaboratorioDAO laboratorioDAO;

    public LaboratorioNegocio(ILaboratorioDAO laboratorioDAO) {
        this.laboratorioDAO = laboratorioDAO;
    }
    
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

    @Override
    public LaboratorioDominio buscarPorId(int id) throws NegocioException {
        try{
            return laboratorioDAO.buscarPorId(id);
        }catch(PersistenciaException ex){
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws NegocioException {
        try{
            LaboratorioDominio laboratorioDominio = laboratorioDAO.buscarPorId(laboratorio.getIdLaboratorios());
            if (laboratorioDominio == null)
                throw new NegocioException("Error al buscar el Laboratorio a modificar.");
            validarHorario(laboratorio.getHoraInicio(), laboratorio.getHoraFin());
            return laboratorioDAO.modificar(laboratorio);
        }catch(PersistenciaException ex){
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        try{
            return laboratorioDAO.buscarTabla(filtro);
        }catch(PersistenciaException ex){
            throw new NegocioException(ex.getMessage());
        }
    }
    
    private void existeLaboratorio(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException{
        try{
            laboratorioDAO.existePorNombre(nuevoLaboratorio.getNombre());
        }catch(PersistenciaException ex){
            throw new NegocioException("Ya existe un laboratorio con ese nombre.");
        }
    }
    
    private void validarHorario(Date horaInicio, Date horaFin) throws NegocioException{
        if (horaInicio == null || horaFin == null)
            throw new NegocioException("Las horas de inicio y cierre son obligatorias.");
        if (!horaInicio.before(horaFin))
            throw new NegocioException("La hora de inicio debe ser anterior a la hora de cierre.");
    }
    
    private void validarUnidadAcademica(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException{
        if(nuevoLaboratorio.getUnidad().equals(UNIDAD_DEFAULT))
            throw new NegocioException("Unidad Académica no valida.");
    }
    
    private void validarContraseña(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException{
        if(nuevoLaboratorio.getContrasena().length < 6)
            throw new NegocioException("La contraseña debe tener al menos 6 caracteres.");
        boolean contieneNumero = new String(nuevoLaboratorio.getContrasena()).matches(".*\\d.*");
        if (!contieneNumero) {
            throw new NegocioException("La contraseña debe contener al menos un número.");
        }
    }
    
    private String encriptarContrasena(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException{
        try{
            String textoPlano = new String(nuevoLaboratorio.getContrasena());
            String hash = BCrypt.hashpw(textoPlano, BCrypt.gensalt());
            nuevoLaboratorio.limpiarContrasena();
            return hash;
        } catch (Exception ex){
            throw new NegocioException("Error al guardar.");
        }
    }
    
    private void validarNuevoLaboratorio(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException{
        existeLaboratorio(nuevoLaboratorio);
        validarHorario(nuevoLaboratorio.getHoraInicio(), nuevoLaboratorio.getHoraCierre());
        validarUnidadAcademica(nuevoLaboratorio);
        validarContraseña(nuevoLaboratorio);
    }

    @Override
    public List<LaboratorioDominio> obtenerLaboratorios() throws NegocioException {
        try {
            return laboratorioDAO.obtenerLaboratorios();
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

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
