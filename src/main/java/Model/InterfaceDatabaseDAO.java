/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.sql.Connection;

/**
 *
 * @author marcos-medeiros
 */
public interface InterfaceDatabaseDAO {
    Connection getConnection();
    void terminate();
}
