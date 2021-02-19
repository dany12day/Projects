package View.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AdministratorDeleteEmployeeView extends JFrame{

    private JLabel jUserName;
    private JTextField tfUserName;
    private JLabel jPassword;
    private JTextField tfPassword;
    private JButton btnDelete;
    private JButton btnBack;


    public AdministratorDeleteEmployeeView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jUserName);
        add(tfUserName);
        add(jPassword);
        add(tfPassword);
        add(btnDelete);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jUserName = new JLabel("Username");
        tfUserName = new JTextField("Username_Employee");
        jPassword = new JLabel("Password");
        tfPassword = new JTextField("Password_Employee");
        btnDelete = new JButton("Delete Employee");
        btnBack = new JButton("Back");

    }

    public String getUserName() {
        return tfUserName.getText();
    }

    public String getPassword() {
        return tfPassword.getText();
    }

    public void setBtnDelete(ActionListener registerButtonListener) {
        btnDelete.addActionListener(registerButtonListener);
    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }
}
