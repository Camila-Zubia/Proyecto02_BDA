/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package INSERCION_MASIVA;

import daos.implementaciones.InsercionMasivaDAO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author adell
 */
public class insercionMasiva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexionJPA");
        InsercionMasivaDAO dao = new InsercionMasivaDAO(factory);
        dao.insertarTodo();
        factory.close();

    }

}
