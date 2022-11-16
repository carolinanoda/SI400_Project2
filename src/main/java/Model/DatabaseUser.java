/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Class responsible for creating Getters and Setters of the user's data.
 *
 * @author Marcos César Medeiros
 * @version 1.0
 */

public class DatabaseUser {
    public String host;
    public String port;
    public String base;
    public String user;
    public String password; 

    public DatabaseUser(String host, String port, String base, String user, String password) {
        this.host = host;
        this.port = port;
        this.base = base;
        this.user = user;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
