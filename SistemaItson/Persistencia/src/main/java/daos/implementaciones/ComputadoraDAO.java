/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos.implementaciones;

import DTO.FiltroDTO;
import DTO.NuevaComputadoraDTO;
import DTO.TablaComputadoraDTO;
import excepciones.PersistenciaException;
import dominios.EstatusComputadora;
import dominios.ComputadoraDominio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.mycompany.persistencia.IComputadoraDAO;
import daos.IConexionBD;
import daos.ILaboratorioDAO;
import dominios.TipoComputadora;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Camila Zubía
 */
public class ComputadoraDAO implements IComputadoraDAO{

    private final ILaboratorioDAO labDAO;
    private final IConexionBD conexionBD;

    public ComputadoraDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.labDAO = new LaboratorioDAO(this.conexionBD);
    }
    
    @Override
    public ComputadoraDominio buscarPorId(int id) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try{
            ComputadoraDominio computadora = manager.find(ComputadoraDominio.class, id);
            if (computadora == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + id);
            }
            return computadora;
        }catch (PersistenciaException ex) {
            throw new PersistenciaException("Error al buscar la computadora por ID" + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public ComputadoraDominio agregar(NuevaComputadoraDTO computadoraDTO) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            manager.getTransaction().begin();
            ComputadoraDominio computadora = new ComputadoraDominio();
            computadora.setNumero(computadoraDTO.getNumero());
            computadora.setDireccionIp(computadoraDTO.getDireccionIp());
            computadora.setEstatus(computadoraDTO.getEstatus());
            computadora.setTipo(computadoraDTO.getTipo());
            computadora.setLaboratorio(labDAO.obtenerPorNombre(computadoraDTO.getLaboratorio()));
            manager.persist(computadora);
            manager.getTransaction().commit();
            return computadora;
        } catch (Exception ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public void apartarComputadora(int id) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            manager.getTransaction().begin();
            ComputadoraDominio computadora = manager.find(ComputadoraDominio.class, id);
            if (computadora == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + id);
            }
            computadora.setEstatus(EstatusComputadora.APARTADA);
            manager.getTransaction().commit();
        } catch (PersistenciaException ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al apartar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public ComputadoraDominio modificar(ComputadoraDominio computadora) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            manager.getTransaction().begin();
            ComputadoraDominio computadoraEncontrada = manager.find(ComputadoraDominio.class, computadora.getIdComputadoras());
            if (computadoraEncontrada == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + computadora.getIdComputadoras());
            }
            computadoraEncontrada.setNumero(computadora.getNumero());
            computadoraEncontrada.setDireccionIp(computadora.getDireccionIp());
            computadoraEncontrada.setTipo(computadora.getTipo());
            computadoraEncontrada.setEstatus(computadora.getEstatus());
            manager.getTransaction().commit();
            return computadoraEncontrada;
        } catch (PersistenciaException ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al modificar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public void eliminar(int id) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            manager.getTransaction().begin();
            ComputadoraDominio computadora = manager.find(ComputadoraDominio.class, id);
            if (computadora == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + id);
            }
            computadora.setEstatus(EstatusComputadora.DESCONECTADA);
            manager.getTransaction().commit();
        } catch (PersistenciaException ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public List<ComputadoraDominio> listarComputadoras() throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            String consulta = "SELECT c FROM computadoraDominio c WHERE c.tipo = :tipo";
            TypedQuery<ComputadoraDominio> query = manager.createQuery(consulta, ComputadoraDominio.class);
            query.setParameter("tipo", TipoComputadora.ESTUDIANTE);
            return query.getResultList();
        }catch (Exception ex) {
            throw new PersistenciaException("Error al eliminar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public void liberarComputadora(int id) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            manager.getTransaction().begin();
            ComputadoraDominio computadora = manager.find(ComputadoraDominio.class, id);
            if (computadora == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + id);
            }
            computadora.setEstatus(EstatusComputadora.DISPONIBLE);
            manager.getTransaction().commit();
        } catch (PersistenciaException ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al liberar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public List<TablaComputadoraDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try{
            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(ComputadoraDominio.class);
            List<Predicate> predicate = new ArrayList<>();
            Root<ComputadoraDominio> root = cq.from(ComputadoraDominio.class);
            if (filtro.getFiltro() != null && !filtro.getFiltro().trim().isEmpty()) {
           
                String textoFiltro = "%" + filtro.getFiltro() + "%";

                Predicate numero = cb.like(cb.function("CAST", String.class, root.get("numero")), textoFiltro);
                Predicate ip = cb.like(cb.function("CAST", String.class, root.get("direccionIp")), textoFiltro);

                predicate.add(cb.or(numero, ip));
            }
            
            cq.select(root).where(cb.and(predicate.toArray(Predicate[]::new)));
            TypedQuery<ComputadoraDominio> query = manager.createQuery(cq);
            query.setFirstResult(filtro.getOffset());
            query.setMaxResults(filtro.getLimit());
            List<ComputadoraDominio> resultados = query.getResultList();
            List<TablaComputadoraDTO> computadoras = resultados.stream()
                    .map(c ->convertirTabla(c)).collect(Collectors.toList());
            return computadoras;
        }catch(Exception ex){
            throw new PersistenciaException("Error al buscar la tabla de computadoras" + ex);
        }finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
    
    private TablaComputadoraDTO convertirTabla(ComputadoraDominio compu){
        int id = compu.getIdComputadoras();
        String numero = compu.getNumero();
        String ip = compu.getDireccionIp();
        EstatusComputadora estatus = compu.getEstatus();
        TipoComputadora tipo = compu.getTipo();
        TablaComputadoraDTO tabla = new TablaComputadoraDTO(id, numero, ip, estatus, tipo);
        return tabla;
    }
}
