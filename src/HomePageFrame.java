import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageFrame extends JFrame {

    HomePageFrame() {
        super("STUDI KASUS HOTEL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(364, 415);

        JLabel label = new JLabel("MANAGEMENT HOTEL");
        label.setBounds(74, 23, 245, 24);
        label.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("C:\\Users\\fatahillah\\Downloads\\WhatsApp Image 2023-01-13 at 16.16.56 (1).jpeg"));
        logo.setBounds(99, 62, 162, 105);

        JLabel labelLogin = new JLabel("Login :");
        labelLogin.setBounds(68, 188, 63, 24);
        labelLogin.setFont(new Font("Serif", Font.BOLD, 20));

        JButton staff = new JButton("STAFF");
        staff.setBounds(143, 212, 69, 26);
        staff.setFont(new Font("Serif", Font.PLAIN, 9));

        JButton admin = new JButton("ADMIN");
        admin.setBounds(143, 251, 69, 23);
        admin.setFont(new Font("Serif", Font.PLAIN, 9));

        add(admin);
        add(staff);
        add(labelLogin);
        add(label);
        add(logo);

        setVisible(true);

        staff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginFrame login = new LoginFrame();
                login.setVisible(true);

            }
        });
    }

}