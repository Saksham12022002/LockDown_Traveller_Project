package jdbcdemo;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class jdbcfirst {

    public static JFrame frame= new JFrame();


public static void main(String[] args) {


    login log = new login();
    frame.setContentPane(log.loginPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

}
}
