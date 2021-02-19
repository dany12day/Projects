package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class EmployeeDeleteClientAccountView extends JFrame{
    private JLabel jAccountIdentificationNumber;
    private JTextField tfAccountIdentificationNumber;
    private JLabel jType;
    private JTextField tfType;
    private JButton btnDelete;
    private JButton btnBack;

    public EmployeeDeleteClientAccountView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jAccountIdentificationNumber);
        add(tfAccountIdentificationNumber);
        add(jType);
        add(tfType);
        add(btnDelete);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jAccountIdentificationNumber = new JLabel("Account Identification Number");
        tfAccountIdentificationNumber = new JTextField("Account_Identification_Number");
        jType = new JLabel("Type");
        tfType = new JTextField("Type");
        btnDelete = new JButton("delete");
        btnBack = new JButton("Back");

    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }


    public String getTfAccountIdentificationNumber() {
        return tfAccountIdentificationNumber.getText();
    }

    public void setBtnDelete(ActionListener registerButtonListener) {
        btnDelete.addActionListener(registerButtonListener);
    }


    public String getTfType() {
        return tfType.getText();
    }
}
