/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Factory class that facilitates database switching.
 *
 * @author Carolina Noda Morishita
 * @author Gustavo Ramos Romagnolo
 * @author Marcos César Medeiros
 * @author Mariana Pereira Araújo
 * @author Thamires de Melo Prado
 * @version 1.0
 */

public class ConnectionFactory {
    public InterfaceDatabaseDAO getSGBD (String SGBD) {
        try {
            if (SGBD == null) SGBD = "SQLite";
            if (SGBD.equals("SQLite")) return new SQLiteConnection();
            if (SGBD.equals("MariaDB")) return new MariaDBConnection();
        } catch (Exception exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
        return null;
    }
}
