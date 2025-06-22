/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dominio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Camila Zubía
 */
public class Dominio {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexionJPA");

    }
}
