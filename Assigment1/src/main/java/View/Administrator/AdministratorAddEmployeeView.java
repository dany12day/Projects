package View.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AdministratorAddEmployeeView extends JFrame{

    private JLabel jNume;
    private JTextField tfNume;
    private JLabel jUserName;
    private JTextField tfUserName;
    private JLabel jPassword;
    private JTextField tfPassword;
    private JButton btnAddEmployee;
    private JButton btnBack;

    public AdministratorAddEmployeeView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jNume);
        add(tfNume);
        add(jUserName);
        add(tfUserName);
        add(jPassword);
        add(tfPassword);
        add(btnAddEmployee);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {

        jNume = new JLabel("Name");
        tfNume = new JTextField("Name_Employee");
        jUserName = new JLabel("UserName");
        tfUserName = new JTextField("UserName_Employee");
        jPassword = new JLabel("Password");
        tfPassword = new JTextField("Password_Employee");
        btnAddEmployee = new JButton("AddEmployee");
        btnBack = new JButton("Back");
    }


    public void setBtnAddEmployee(ActionListener loginButtonListener) {
        btnAddEmployee.addActionListener(loginButtonListener);
    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }

    public String getTfNume() {
        return tfNume.getText();
    }

    public String getTfUserName() {
        return tfUserName.getText();
    }

    public String getTfPassword() {
        return tfPassword.getText();
    }
}
