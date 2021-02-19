package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class EmployeeReadClientAccountView extends JFrame{
    private JLabel jAccountIdentificationNumber;
    private JTextField tfAccountIdentificationNumber;
    private JLabel jType;
    private JTextField tfType;
    private JButton btnRead;
    private JButton btnBack;

    public EmployeeReadClientAccountView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jAccountIdentificationNumber);
        add(tfAccountIdentificationNumber);
        add(jType);
        add(tfType);
        add(btnRead);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jAccountIdentificationNumber = new JLabel("Account Identification Number");
        tfAccountIdentificationNumber = new JTextField("Account_Identification_Number");
        jType = new JLabel("Type");
        tfType = new JTextField("Type");
        btnRead = new JButton("Read");
        btnBack = new JButton("Back");

    }

    public String getTfAccountIdentificationNumber() {
        return tfAccountIdentificationNumber.getText();
    }

    public void setBtnRead(ActionListener registerButtonListener) {
        btnRead.addActionListener(registerButtonListener);
    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }

    public String getTfType() {
        return tfType.getText();
    }
}
