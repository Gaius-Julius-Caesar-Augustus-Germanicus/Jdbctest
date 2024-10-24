/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tuyweb.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alchemik
 */
public class Jdbctest {

    public static void main(String[] args) {
        String usuario = "root";
        String pasword = "";
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, pasword);
            statement = conexion.createStatement ();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            
            }
            
            //Inserción de datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'Armando');");
             System.out.println("");
            
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            
            }
            
            //Actualizacón de datos
            statement.execute("UPDATE `usuarios` SET `nombre` = 'Daniela' WHERE `usuarios`.`id` = 2;");
             System.out.println("");
            
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            
            }
            //Eliminación de datos
            statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 4");
             System.out.println("");
            
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Jdbctest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
