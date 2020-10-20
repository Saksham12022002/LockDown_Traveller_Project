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
import java.util.Objects;

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

                SignUp.setVisible(false);

                mysignUp = new signup();
                jdbcfirst.frame.setContentPane(mysignUp.signuppage);
                jdbcfirst.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                jdbcfirst.frame.setVisible(true);
//
            }
        });


        logInButton.addActionListener(new ActionListener() {
            String username = textField1.getText();
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("") || passwordField1.getText().equals("")){
                    JDialog frame = new JDialog();
                    JOptionPane.showMessageDialog(frame, "Fields Can't be Empty",
                            "Error !!!", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (Objects.requireNonNull(comboBox1.getSelectedItem()).toString().equals("user")){
                        System.out.println("user selected");
//                        System.out.println("admin selected");
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trains", "root", "");
                            String queryysername = "Select * from users WHERE Username = ?";
                            PreparedStatement psUsername = connection.prepareStatement(queryysername);
                            psUsername.setString(1,textField1.getText());
                            ResultSet rsUsername = psUsername.executeQuery();
                            if (rsUsername.next())
                            {

                                if (passwordField1.getText().equals(rsUsername.getString("Password"))){
                                    jdbcfirst.frame.setContentPane(new WelcomeUser(textField1.getText()).panel1);
                                    jdbcfirst.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//

                                    jdbcfirst.frame.setVisible(true);
                                    System.out.println("Successfully Logged In");

                                }
                                else {
                                    JDialog frame = new JDialog();
                                    JOptionPane.showMessageDialog(frame, "Password Not Matched",
                                            "SignUp Please ", JOptionPane.ERROR_MESSAGE);
                                }
//                                System.out.println(rsUsername.getString("Email"));
//                                System.out.println(rsUsername.getString("Phone"));
                            }
                            else {
                                JDialog frame = new JDialog();
                                JOptionPane.showMessageDialog(frame, "User Not Found SignUp Please",
                                        "SignUp Please ", JOptionPane.ERROR_MESSAGE);
                            }



                        }
                        catch (Exception e1){
                            System.out.println(e1.getMessage()+"\nException Found");
                        }
                    }
                    else if (comboBox1.getSelectedItem().toString().equals("admin")){
                        System.out.println("admin selected");
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trains", "root", "");
                            String queryysername = "Select * from admin WHERE Username = ?";
                            PreparedStatement psUsername = connection.prepareStatement(queryysername);
                            psUsername.setString(1,username);
                            ResultSet rsUsername = psUsername.executeQuery();
                            if (rsUsername.next())
                            {
                                System.out.println(rsUsername.getString("Email"));
                                System.out.println(rsUsername.getString("Phone"));
                            }
                            else {
                                JDialog frame = new JDialog();
                                JOptionPane.showMessageDialog(frame, "SignUp Please!!",
                                        "User Not Found SignUp Please", JOptionPane.ERROR_MESSAGE);
                            }



                        }
                        catch (Exception e1){
                            System.out.println(e1.getMessage()+"\nException Found");
                        }
                    }
                    else {
                        JDialog frame = new JDialog();
                        JOptionPane.showMessageDialog(frame, "Select One from User or Admin",
                                "Error !!!", JOptionPane.ERROR_MESSAGE);
                    }
                }



            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


}
