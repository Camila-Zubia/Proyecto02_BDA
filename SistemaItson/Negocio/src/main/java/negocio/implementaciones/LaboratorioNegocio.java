package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.NuevoLaboratorioDTO;
import daos.ILaboratorioDAO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.ILaboratorioNegocio;
import org.mindrot.jbcrypt.BCrypt;


public class LaboratorioNegocio implements ILaboratorioNegocio{

    private final String UNIDAD_DEFAULT = "Selecciona...";
    private ILaboratorioDAO laboratorioDAO;

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

    private void existeLaboratorio(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException{
        try{
            laboratorioDAO.existePorNombre(nuevoLaboratorio.getNombre());
        }catch(PersistenciaException ex){
            throw new NegocioException("Ya existe un laboratorio con ese nombre.");
        }
    }
    
    private void validarHorario(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException{
        if (nuevoLaboratorio.getHoraInicio() == null || nuevoLaboratorio.getHoraCierre() == null)
        throw new NegocioException("Las horas de inicio y cierre son obligatorias.");
        if (!nuevoLaboratorio.getHoraInicio().isBefore(nuevoLaboratorio.getHoraCierre()))
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
        validarHorario(nuevoLaboratorio);
        validarUnidadAcademica(nuevoLaboratorio);
        validarContraseña(nuevoLaboratorio);
    }

}
