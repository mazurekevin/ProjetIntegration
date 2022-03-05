package com.apiSpring.apiSpring.controller;

import java.sql.*;

public class ConnectDB {
    public String connectDB(String request, String method) {
        String result = "";

        try {
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/todolist?autoReconnect=true&useSSL=false","root","root");
            Connection con = DriverManager.getConnection("jdbc:mysql://b02fc6a68294e9:375284d6@eu-cdbr-west-02.cleardb.net/heroku_3673ffd1e5cd834?reconnect=true","b02fc6a68294e9","375284d6");
            System.out.println("Connexion réussie");
            Statement stmt = con.createStatement();
            ResultSet rs = null;

            if(method == "SELECT") {
                rs = stmt.executeQuery(request);
                result += "Voici les résultats de votre requête : \n";
                while(rs.next())
                    result += "ID : "+(rs.getString(1)
                            +"\nPrénom : "+rs.getString(2)
                            +"\nNom : "+rs.getString(3)
                            +"\nMail : "+rs.getString(4)
                            +"\nAge : "+rs.getString(5)
                            +"\nMot de passe : "+rs.getString(6)) + "\n";
            }

            if(method == "PASSWORD" || method == "ID") {
                rs = stmt.executeQuery(request);
                while(rs.next())
                    result += rs.getString(1);
            }

            if(method=="INSERT" || method=="DELETE" || method=="UPDATE") {
                stmt.executeUpdate(request);
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
}
