package View.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class AdministratorUpdateEmployeeView extends JFrame{
    private JLabel jSelectEmployee;
    private JLabel jUserName;
    private JTextField tfUserName;
    private JLabel jPassword;
    private JTextField tfPassword;
    private JLabel jChangeDataEmployee;
    private JLabel jNewName;
    private JTextField tfNewName;
    private JButton btnNewName;
    private JLabel jNewUserName;
    private JTextField tfNewUserName;
    private JButton btnNewUserName;
    private JLabel jNewPassword;
    private JTextField tfNewPassword;
    private JButton btnNewPassword;
    private JButton btnBack;

    public AdministratorUpdateEmployeeView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jSelectEmployee);
        add(jUserName);
        add(tfUserName);
        add(jPassword);
        add(tfPassword);
        add(jChangeDataEmployee);
        add(jNewName);
        add(tfNewName);
        add(btnNewName);
        add(jNewUserName);
        add(tfNewUserName);
        add(btnNewUserName);
        add(jNewPassword);
        add(tfNewPassword);
        add(btnNewPassword);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jSelectEmployee = new JLabel("Select Employee");
        jUserName = new JLabel("Username");
        tfUserName = new JTextField("Username_Employee");
        jPassword = new JLabel("Password");
        tfPassword = new JTextField("Password_Employee");
        jChangeDataEmployee = new JLabel("Change Employee Data");
        jNewName = new JLabel("New name");
        tfNewName = new JTextField("New_Name_Employee");
        btnNewName = new JButton("Change Name");
        jNewUserName = new JLabel("New username");
        tfNewUserName = new JTextField("New_Username_Employee");
        btnNewUserName = new JButton("Change Username");
        jNewPassword = new JLabel("New password");
        tfNewPassword = new JTextField("New_Password_Employee");
        btnNewPassword = new JButton("Change Password");
        btnBack = new JButton("Back");

    }

    public void setBtnNewName(ActionListener registerButtonListener) {
        btnNewName.addActionListener(registerButtonListener);
    }

    public void setBtnNewUserName(ActionListener registerButtonListener) {
        btnNewUserName.addActionListener(registerButtonListener);
    }

    public void setBtnNewPassword(ActionListener registerButtonListener) {
        btnNewPassword.addActionListener(registerButtonListener);
    }

    public void setBtnBack(ActionListener registerButtonListener) {

        btnBack.addActionListener(registerButtonListener);
    }

    public String getUserName() {
        return tfUserName.getText();
    }

    public String getPassword() {
        return tfPassword.getText();
    }

    public String getNewName() {
        return tfNewName.getText();
    }

    public String getNewUserName() {
        return tfNewUserName.getText();
    }

    public String getNewPassword() {
        return tfNewPassword.getText();
    }
}
