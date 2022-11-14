/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Controller;

/**
 *
 * @author marcos-medeiros
 */
public class ConnectionFactory {
    public InterfaceDatabaseDAO getSGBD (String SGBD) {
        try {
            if (SGBD == null) SGBD = "SQLite";
            if (SGBD.equals("SQLite")) return new SQLiteConnection();
            if (SGBD.equals("MariaDB")) return new MariaDBConnection(Controller.getLoginDB(), Controller.getPasswordDB());
        } catch (Exception exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
        return null;
    }
}
