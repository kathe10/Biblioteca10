/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.*;

/**
 *
 * @author Kathe
 */
public class Conexion {
    public Connection conex;
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca" , "root" , "");
            System.out.println("La conexion se realizo con exito");
        } catch (Exception e) {
            System.out.println("No fue posible la conexion." + e.getMessage());
        }
        return conex;
        
    }
    
    
}