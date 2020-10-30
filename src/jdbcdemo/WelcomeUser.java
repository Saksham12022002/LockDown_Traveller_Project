package jdbcdemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WelcomeUser {

    WelcomeUser(String s1,String s2){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trains", "root", "");
            String queryysername = "Select * from "+s2+" WHERE Username = ?";
            PreparedStatement psUsername = connection.prepareStatement(queryysername);
            psUsername.setString(1,s1);
            psUsername.executeQuery();
            ResultSet rsUsername = psUsername.executeQuery();
//            String fullname = rs1.getString("FullName");
//            ;
            WelcomeLabel1.setText("Welcome");


            while (rsUsername.next()){
                WelcomeLabel1.setText("Hello "+rsUsername.getString("FullName")+" Welcome to Lockdown Traveller");
                System.out.println("Usename :"+rsUsername.getString("Username")+"\n");
                System.out.println("Name :"+rsUsername.getString("FullName")+"\n");
                System.out.println("Email :"+rsUsername.getString("Email")+"\n");
                System.out.println("Phone :"+rsUsername.getString("Phone")+"\n");
            }


        }
        catch (Exception e1){
            System.out.println(e1.getMessage()+"\nException Found");
        }

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jdbcfirst.frame.setContentPane(new AdminAddTrains().AddTrain);
                jdbcfirst.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                jdbcfirst.frame.setVisible(true);
            }
        });
    }

    public JPanel panel1;
    private JLabel WelcomeLabel1;
    private JButton button1;

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
