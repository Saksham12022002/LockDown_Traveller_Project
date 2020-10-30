package jdbcdemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AdminAddTrains {
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JRadioButton mondayRadioButton;
    private JRadioButton thursdayRadioButton;
    private JRadioButton tuesdayRadioButton;
    private JRadioButton wednesdayRadioButton;
    public JPanel AddTrain;
    private JRadioButton fridayRadioButton;
    private JRadioButton saturdayRadioButton;
    private JRadioButton sundayRadioButton;
    private JRadioButton everyDayRadioButton;
    private JButton button1;

    public AdminAddTrains(){
        GlobalVariables g1 = new GlobalVariables();
        Arrays.sort(g1.getCities());
        DefaultComboBoxModel dm = new DefaultComboBoxModel(g1.getCities());
        DefaultComboBoxModel dm1 = new DefaultComboBoxModel(g1.getCities());
       comboBox1.setModel(dm);
       comboBox2.setModel(dm1);
        everyDayRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (everyDayRadioButton.isSelected()){
                    mondayRadioButton.setSelected(true);
                    tuesdayRadioButton.setSelected(true);
                    wednesdayRadioButton.setSelected(true);
                    thursdayRadioButton.setSelected(true);
                    fridayRadioButton.setSelected(true);
                    saturdayRadioButton.setSelected(true);
                    sundayRadioButton.setSelected(true);
                }
                else {
                    mondayRadioButton.setSelected(false);
                    tuesdayRadioButton.setSelected(false);
                    wednesdayRadioButton.setSelected(false);
                    thursdayRadioButton.setSelected(false);
                    fridayRadioButton.setSelected(false);
                    saturdayRadioButton.setSelected(false);
                    sundayRadioButton.setSelected(false);
                }
            }
        });
    }
}
