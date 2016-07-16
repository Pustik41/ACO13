package ClassWork.week8.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zhabenya on 16.07.16.
 */
public class LoginFrame extends JFrame {

    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin";

    public LoginFrame() throws HeadlessException {

        setTitle("Login Frame");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JLabel login = new JLabel("Login");
        JLabel password = new JLabel("Password");

        JTextField loginField = new JTextField();
        JTextField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Ok");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(LOGIN.equals(loginField.getText()) && PASSWORD.equals(passwordField.getText())){
                    JOptionPane.showMessageDialog(LoginFrame.this, "Hello!", "Login in", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Error Login/password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginField.setText("");
                passwordField.setText("");
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gdc = new GridBagConstraints();

        gdc.insets = new Insets(5, 5, 5, 5);
        gdc.fill = GridBagConstraints.BOTH;
        gdc.gridx = 0;
        gdc.gridy = 0;
        add(login, gdc);

        gdc.gridy = 1;
        add(password, gdc);

        gdc.gridy = 0;
        gdc.gridx = 1;
        add(loginField, gdc);


        gdc.gridx = 1;
        gdc.gridy = 1;
        add(passwordField, gdc);

        gdc.gridx = 0;
        gdc.gridy = 2;
        add(loginButton, gdc);

        gdc.gridx = 1;
        gdc.gridy = 2;
        add(cancelButton, gdc);

        setVisible(true);
        //pack();

    }

}
