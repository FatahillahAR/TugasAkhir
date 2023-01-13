import controller.Auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    Auth login = new Auth();
    LoginFrame(){
        super("LoginForm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(364,415);
        setVisible(true);

        JLabel loginLabel = new JLabel("Login Staff");
        loginLabel.setBounds(64,104,235,34);
        loginLabel.setFont(new Font("Serif",Font.BOLD,45));

        JLabel userLabel = new JLabel("NIP :");
        userLabel.setBounds(30,203,124,10);
        userLabel.setFont(new Font("Serif",Font.BOLD,13));

        JLabel passLabel = new JLabel("Password :");
        passLabel.setBounds(24,262,124,10);
        passLabel.setFont(new Font("Serif",Font.BOLD,13));

        JButton okButton = new JButton("OK");
        okButton.setBounds(136,342,92,17);
        okButton.setFont(new Font("Serif",Font.BOLD,12));

        JTextField userText = new JTextField(20);
        userText.setBounds(57,218,249,22);
        userText.setFont(new Font("Serif",Font.BOLD,11));

        JPasswordField passText = new JPasswordField(20);
        passText.setBounds(57,280,249,26);
        passText.setFont(new Font("Serif",Font.BOLD,11));

        add(loginLabel);
        add(userLabel);
        add(passLabel);
        add(userText);
        add(passText);
        add(okButton);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userValue = userText.getText();
                String passValue = passText.getText();
                boolean status = login.login(userValue,passValue);
                if(status){
                    JOptionPane.showMessageDialog(null,"Login Sukses","Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Login Gagal","Message",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}