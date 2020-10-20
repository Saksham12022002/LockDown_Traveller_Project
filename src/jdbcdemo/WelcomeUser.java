package jdbcdemo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WelcomeUser {

    WelcomeUser(String s1){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trains", "root", "");
            String queryysername = "Select * from users WHERE Username = ?";
            PreparedStatement psUsername = connection.prepareStatement(queryysername);
            psUsername.setString(1,s1);
            ResultSet rsUsername = psUsername.executeQuery();
            String fullname = rsUsername.getString("FullName");
            WelcomeLabel1.setText("Hello "+fullname+" Welcome to Lockdown Traveller");
            while (rsUsername.next()){
                System.out.println("Usename :"+rsUsername.getString("Username")+"\n");
                System.out.println("Name :"+rsUsername.getString("FullName")+"\n");
                System.out.println("Email :"+rsUsername.getString("Email")+"\n");
                System.out.println("Phone :"+rsUsername.getString("Phone")+"\n");
            }

        }
        catch (Exception e1){
            System.out.println(e1.getMessage()+"\nException Found");
        }
    }

    public JPanel panel1;
    private JLabel WelcomeLabel1;
//    WelcomeUser(String s1, String s2){
//
//
//        WelcomeLabel1.setText("Hello "+s2+" Welcome to Lockdown Traveller");
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trains", "root", "");
//            String queryysername = "Select * from users WHERE Username = ?";
//            PreparedStatement psUsername = connection.prepareStatement(queryysername);
//            psUsername.setString(1,s1);
//            ResultSet rsUsername = psUsername.executeQuery();
//            while (rsUsername.next()){
//                        System.out.println("Usename :"+rsUsername.getString("Username")+"\n");
//                        System.out.println("Name :"+rsUsername.getString("FullName")+"\n");
//                        System.out.println("Email :"+rsUsername.getString("Email")+"\n");
//                        System.out.println("Phone :"+rsUsername.getString("Phone")+"\n");
//                    }
//
//        }
//        catch (Exception e1){
//            System.out.println(e1.getMessage()+"\nException Found");
//        }
//    }
    WelcomeUser(){


        WelcomeLabel1.setText("Welcome To Our Application ");

    }
}
