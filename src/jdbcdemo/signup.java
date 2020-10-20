package jdbcdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class signup {
    private JTextField usernameField;
    private JTextField EmailField;
    public JTextField NameField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField PhoneField;
    public JPanel signuppage;
    private JButton registerButton;
    private JButton backButton;
    private JLabel signUpLabel;
    String regex = "[0-9]+";

//    private static void createWindow() {
//        JFrame frame = new JFrame("Swing Tester");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        createUI(frame);
//        frame.setSize(560, 200);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//
//    private static void createUI(final JFrame frame){
//        JPanel panel = new JPanel();
//        LayoutManager layout = new FlowLayout();
//        panel.setLayout(layout);
//        JButton button = new JButton("Click Me!");
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(frame, "Password Do Not Match !!!",
//                        "Swing Tester", JOptionPane.ERROR_MESSAGE);
//            }
//        });
//
//        panel.add(button);
//        frame.getContentPane().add(panel, BorderLayout.CENTER);
//    }
    public signup(String username, String name,String email,String phone, String password){
        username = usernameField.getText();
        name = NameField.getText();
        email = EmailField.getText();
        phone = PhoneField.getText();
        password = passwordField1.getText();
        new WelcomeUser();
    }

    public signup() {

        signUpLabel.setText("WelCome User");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trains", "root","");

                    String queryysername = "Select * from users WHERE Username = ?";
                    PreparedStatement psUsername = myconnection.prepareStatement(queryysername);
                    psUsername.setString(1,usernameField.getText().toString());
                    ResultSet rsUsername = psUsername.executeQuery();
                    if (rsUsername.next())
                    {
                        JDialog frame = new JDialog();
                        JOptionPane.showMessageDialog(frame, "Username Taken !!!",
                                "Username Taken", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        {

                        String queryEmail = "Select * from users WHERE Email = ?";
                        PreparedStatement psEmail = myconnection.prepareStatement(queryEmail);
                        psEmail.setString(1,EmailField.getText().toString());
                        ResultSet rsEmail = psEmail.executeQuery();
                        if (rsEmail.next())
                        {
                            JDialog frame = new JDialog();
                            JOptionPane.showMessageDialog(frame, "Email Already Registered !!!",
                                    "Email Already Registered", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            String queryPhone = "Select * from users WHERE Phone = ?";
                            PreparedStatement psPhone = myconnection.prepareStatement(queryPhone);
                            psPhone.setString(1,PhoneField.getText().toString());
                            ResultSet rsPhone = psPhone.executeQuery();
                            if (rsPhone.next())
                            {
                                JDialog frame = new JDialog();
                                JOptionPane.showMessageDialog(frame, "Phone Number Already Registered !!!",
                                        "Error!!!!", JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                if (usernameField.getText().equals("") || NameField.getText().equals("") || EmailField.getText().equals("") || passwordField1.getText().equals("") || passwordField2.getText().equals("") || PhoneField.getText().equals("") ){
                                    JDialog frame = new JDialog();
                                    JOptionPane.showMessageDialog(frame, "Fields Can't be left Empty",
                                            "Error!!!!", JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                    if (EmailField.getText().contains("@")){
                                        if (PhoneField.getText().matches(regex) && PhoneField.getText().length()==10){
                                            if (passwordField1.getText().length()>=8 ){
                                                PreparedStatement preparedStatement = myconnection.prepareStatement("Insert into users values (?,?,?,?,?)");
                                                preparedStatement.setString(1, usernameField.getText());
                                                preparedStatement.setString(2, NameField.getText());
                                                preparedStatement.setString(3, EmailField.getText());
                                                preparedStatement.setString(4, PhoneField.getText());
                                                if (passwordField1.getText().toString().equals(passwordField2.getText().toString())) {
                                                    preparedStatement.setString(5, passwordField1.getText());
                                                    preparedStatement.executeUpdate();
                                                    jdbcfirst.frame.setContentPane(new WelcomeUser(usernameField.getText()).panel1);
                                                    jdbcfirst.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                jdbcfirst.frame.pack();

                                                    jdbcfirst.frame.setVisible(true);


                                                }
                                                else{
                                                    JDialog frame = new JDialog();
                                                    JOptionPane.showMessageDialog(frame, "Password Do Not Match !!!",
                                                            "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }

                                            else {
                                                JDialog frame = new JDialog();
                                                JOptionPane.showMessageDialog(frame, "Password should be Atleast of Length 8",
                                                        "Error !!!", JOptionPane.ERROR_MESSAGE);
                                            }

                                        }
                                        else
                                            {
                                                JDialog frame = new JDialog();
                                                JOptionPane.showMessageDialog(frame, "Enter Valid Phone Number!",
                                                        "Error !!!", JOptionPane.ERROR_MESSAGE);
                                        }

                                    }
                                    else {
                                        JDialog frame = new JDialog();
                                        JOptionPane.showMessageDialog(frame, "Enter Valid Email address!",
                                                "Error !!!", JOptionPane.ERROR_MESSAGE);
                                    }

                                }

                            }

                        }

                    }




//                    ResultSet resultSet = statement.executeQuery("select * from trainnames");
//                    while (resultSet.next()){
//                        System.out.println("Train name:"+resultSet.getString("name")+"\n"+resultSet.getString("number"));
//                    }
                }
                catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdbcfirst.frame.setContentPane(new login().loginPanel);
                jdbcfirst.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                jdbcfirst.frame.pack();
                jdbcfirst.frame.setVisible(true);
            }
        });
    }
}
