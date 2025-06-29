/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos.implementaciones;

import dominios.CarreraDominio;
import dominios.EstudianteDominio;
import dominios.UnidadAcademicaDominio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author adell
 */
public class InsercionMasivaDAO {
    private final EntityManagerFactory emf;

    public InsercionMasivaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void insertarTodo() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();


            UnidadAcademicaDominio unidad = new UnidadAcademicaDominio();
            unidad.setNombres("nainari");
            em.persist(unidad);

 
            List<CarreraDominio> carreras = new ArrayList<>();
            String[] nombresCarreras = {"Software", "Diseño", "Mecatronico", "Industrial", "Arquitecto"};
            int[] tiempos = {8, 6, 8, 4, 5};

            for (int i = 0; i < nombresCarreras.length; i++) {
                CarreraDominio c = new CarreraDominio();
                c.setNombre(nombresCarreras[i]);
                c.setTiempoLimiteDiario(tiempos[i]);
                c.setUnidadAcademica(unidad);
                em.persist(c);
                carreras.add(c);
            }

  
            String[][] datosEstudiantes = {
                {"252770", "Adel", "Lizo", "Mendez", "popusa1", "1"},
                {"252640", "Camila", "Higuera", "Zubia", "popusa2", "1"},
                {"252810", "Saul", "Baldenegro", "Apodaca", "popusa3", "1"},
                {"252341", "Norma", "Martin", "Beltran", "popusa4", "1"},
                {"294014", "Jose", "Lizo", "Martinez", "popusa5", "1"},
                {"300001", "Luis", "Ramirez", "Gonzalez", "clave1", "2"},
                {"300002", "Ana", "Sanchez", "Fernandez", "clave2", "2"},
                {"300003", "Mario", "Vargas", "Lopez", "clave3", "2"},
                {"300004", "Elena", "Hernandez", "Soto", "clave4", "2"},
                {"300005", "Javier", "Gutierrez", "Mora", "clave5", "2"},
                {"310001", "Claudia", "Delgado", "Rojas", "clave6", "3"},
                {"310002", "Felipe", "Torres", "Medina", "clave7", "3"},
                {"310003", "Lorena", "Nunez", "Castro", "clave8", "3"},
                {"310004", "Ricardo", "Campos", "Ortega", "clave9", "3"},
                {"310005", "Paola", "Mendoza", "Alvarez", "clave10", "3"},
                {"320001", "Diego", "Paredes", "Vega", "clave11", "4"},
                {"320002", "Sofia", "Salinas", "Morales", "clave12", "4"},
                {"320003", "Andres", "Ramos", "Campos", "clave13", "4"},
                {"320004", "Gabriela", "Flores", "Reyes", "clave14", "4"},
                {"320005", "Hector", "Pinto", "Silva", "clave15", "4"},
                {"330001", "Valeria", "Moreno", "Salazar", "clave16", "5"},
                {"330002", "Alberto", "Lozano", "Herrera", "clave17", "5"},
                {"330003", "Natalia", "Ponce", "Navarro", "clave18", "5"},
                {"330004", "Carlos", "Mora", "Figueroa", "clave19", "5"},
                {"330005", "Lucia", "Cruz", "Marin", "clave20", "5"}
            };

            for (int i = 0; i < datosEstudiantes.length; i++) {
                EstudianteDominio e = new EstudianteDominio();
                e.setIdEscolar(datosEstudiantes[i][0]);
                e.setNombres(datosEstudiantes[i][1]);
                e.setApellidoPaterno(datosEstudiantes[i][2]);
                e.setApellidoMaterno(datosEstudiantes[i][3]);
                e.setContraseña(datosEstudiantes[i][4]);
                e.setEstatus(true);
                int carreraIndex = Integer.parseInt(datosEstudiantes[i][5]) - 1;
                e.setCarrera(carreras.get(carreraIndex));
                em.persist(e);

                if (i > 0 && i % 10 == 0) {
                    em.flush();
                    em.clear();
                }
            }

            tx.commit();
            System.out.println("Inserción masiva completada correctamente.");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
