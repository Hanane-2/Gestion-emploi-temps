/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionemploiv2;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



/**
 *
 * @author hp
 */
public class Tools {
 
 public static String getPassword(String userName) {
    String pwd = "";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String protocole = "jdbc:mysql";
        String ip = "localhost";
        String user = "root";
        String password = "zxcvbnm1234";
        String port = "3306";
        String dbName = "EmploiTemps";
        String conString = protocole + "://" + ip + ":" + port + "/" + dbName;
        Connection con = DriverManager.getConnection(conString, user, password);
        PreparedStatement stmt = con.prepareStatement("SELECT password FROM Prof WHERE username = ?");
        stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            pwd = rs.getString("password");
        } else {
            throw new Exception("No password found for the given username: " + userName);
        }
        rs.close();
        stmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return pwd;
}  
   



    
    public static String hash(String message) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(message.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle exception
            return null;
        }
    }
 
}




 

