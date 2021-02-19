package View.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

/**
 * Created by Alex on 18/03/2017.
 */
public class AdministratorView extends JFrame {

    private JButton btnCreateEmployee;
    private JButton btnReadEmployee;
    private JButton btnUpdateEmployee;
    private JButton btnDeleteEmployee;
    private JButton btnGenerateReportEmployee;
    private JButton btnBackAdmin;

    public AdministratorView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(btnCreateEmployee);
        add(btnReadEmployee);
        add(btnUpdateEmployee);
        add(btnDeleteEmployee);
        add(btnGenerateReportEmployee);
        add(btnBackAdmin);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        btnCreateEmployee = new JButton("CreateEmployee");
        btnReadEmployee = new JButton("ReadEmployee");
        btnUpdateEmployee = new JButton("UpdateEmployee");
        btnDeleteEmployee = new JButton("DeleteEmployee");
        btnGenerateReportEmployee = new JButton("GenerateReportEmployee");
        btnBackAdmin = new JButton("Back");
    }


    public void setCreateEmployee(ActionListener loginButtonListener) {
        btnCreateEmployee.addActionListener(loginButtonListener);
    }

    public void setReadEmployee(ActionListener registerButtonListener) {
        btnReadEmployee.addActionListener(registerButtonListener);
    }

    public void setUpdateEmployee(ActionListener loginButtonListener) {
        btnUpdateEmployee.addActionListener(loginButtonListener);
    }

    public void setDeleteEmployee(ActionListener registerButtonListener) {
        btnDeleteEmployee.addActionListener(registerButtonListener);
    }

    public void setGenerateReportEmployee(ActionListener loginButtonListener) {
        btnGenerateReportEmployee.addActionListener(loginButtonListener);
    }

    public void setbtnBackAdmin(ActionListener loginButtonListener) {
        btnBackAdmin.addActionListener(loginButtonListener);
    }
}
