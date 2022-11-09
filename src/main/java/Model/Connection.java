/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author marcos-medeiros
 */
public class Connection {
    private Object database;
    
    public Connection(String SGBD, String login, String password) {
        switch (SGBD) {
            case "MariaDB":
                this.database = new MariaDBConnection(login, password);
                break;
            case "SQLite":
                this.database = new SQLiteConnection();
                break;
            default:
                throw new AssertionError();
        }
    }
}
