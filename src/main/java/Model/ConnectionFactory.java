/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author marcos-medeiros
 */
public class ConnectionFactory {
    public InterfaceDatabaseDAO getSGBD (String SGBD) {
        try {
            if (SGBD == null) SGBD = "SQLite";
            if (SGBD.equals("SQLite")) return new SQLiteConnection();
            if (SGBD.equals("MariaDB")) return new MariaDBConnection("si400_2022", "si400_2022");
        } catch (Exception exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
        return null;
    }
}
