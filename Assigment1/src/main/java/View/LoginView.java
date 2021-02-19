package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import static javax.swing.BoxLayout.Y_AXIS;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class LoginView extends JFrame {
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JButton btnLogin;

    public LoginView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(tfUsername);
        add(tfPassword);
        add(btnLogin);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        tfUsername = new JTextField();
        tfPassword = new JTextField();
        btnLogin = new JButton("Login");
    }

    public String getUsername() {
        return tfUsername.getText();
    }

    public String getPassword() {
        return tfPassword.getText();
    }

    public void setLoginButtonListener(ActionListener loginButtonListener) {
        btnLogin.addActionListener(loginButtonListener);
    }

}
