package jdbcdemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login extends JFrame{


    public JPanel loginPanel;
    public JButton SignUp;

    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton logInButton;
    private JPasswordField passwordField1;
    public signup mysignUp;


    public login() {
        comboBox1.addItem("--Select--");
        comboBox1.addItem("user");
        comboBox1.addItem("admin");


        SignUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                mysignUp = new signup();
                jdbcfirst.frame.setContentPane(mysignUp.signuppage);
                jdbcfirst.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                jdbcfirst.frame.setVisible(true);
//
            }
        });

        

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


}
