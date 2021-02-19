package View.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AdministratorGenerateReportEmployeeView extends JFrame{
    private JLabel jSelectEmployee;
    private JTextField tfSelectEmployee;
    private JLabel jDateFrom;
    private JTextField tfDateFrom;
    private JLabel jDateTo;
    private JTextField tfDateTo;
    private JButton btnSearch;
    private JButton btnBack;

    public AdministratorGenerateReportEmployeeView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jSelectEmployee);
        add(tfSelectEmployee);
        add(jDateFrom);
        add(tfDateFrom);
        add(jDateTo);
        add(tfDateTo);
        add(btnSearch);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jSelectEmployee = new JLabel("Select employee name");
        tfSelectEmployee = new JTextField("Select_employee");
        jDateFrom = new JLabel("Activity from the date");
        tfDateFrom = new JTextField("Date");
        jDateTo = new JLabel("Activity to the date");
        tfDateTo = new JTextField("Date");
        btnSearch = new JButton("Search");
        btnBack = new JButton("Back");

    }


    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }

    public void setBtnSearch(ActionListener registerButtonListener) {
        btnSearch.addActionListener(registerButtonListener);
    }

    public String getTfSelectEmployee() {
        return tfSelectEmployee.getText();
    }

    public String getTfDateFrom() {
        return tfDateFrom.getText();
    }

    public String getTfDateTo() {
        return tfDateTo.getText();
    }
}
