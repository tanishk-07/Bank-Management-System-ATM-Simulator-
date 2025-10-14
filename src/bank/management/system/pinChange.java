package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class pinChange extends JFrame implements ActionListener {

    String cardno;
    JPasswordField currentPinField, newPinField, confirmPinField;
    JButton changeBtn, backBtn;

    pinChange(String cardno) {
        super("PIN CHANGE");
        this.cardno = cardno;

        // === Background ===
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0, 0, 1550, 830);
        add(bg);

        // === Title ===
        JLabel title = new JLabel("CHANGE YOUR PIN");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("System", Font.BOLD, 20));
        title.setBounds(510, 180, 400, 35);
        bg.add(title);

        // === Current PIN ===
        JLabel currLabel = new JLabel("Current PIN:");
        currLabel.setForeground(Color.WHITE);
        currLabel.setFont(new Font("System", Font.BOLD, 16));
        currLabel.setBounds(460, 230, 200, 25);
        bg.add(currLabel);

        currentPinField = new JPasswordField();
        currentPinField.setBounds(640, 230, 200, 25);
        currentPinField.setBackground(new Color(65, 125, 128));
        currentPinField.setForeground(Color.WHITE);
        currentPinField.setFont(new Font("Raleway", Font.BOLD, 18));
        bg.add(currentPinField);

        // === New PIN ===
        JLabel newLabel = new JLabel("New PIN:");
        newLabel.setForeground(Color.WHITE);
        newLabel.setFont(new Font("System", Font.BOLD, 16));
        newLabel.setBounds(460, 270, 200, 25);
        bg.add(newLabel);

        newPinField = new JPasswordField();
        newPinField.setBounds(640, 270, 200, 25);
        newPinField.setBackground(new Color(65, 125, 128));
        newPinField.setForeground(Color.WHITE);
        newPinField.setFont(new Font("Raleway", Font.BOLD, 18));
        bg.add(newPinField);

        // === Confirm PIN ===
        JLabel confirmLabel = new JLabel("Confirm PIN:");
        confirmLabel.setForeground(Color.WHITE);
        confirmLabel.setFont(new Font("System", Font.BOLD, 16));
        confirmLabel.setBounds(460, 310, 200, 25);
        bg.add(confirmLabel);

        confirmPinField = new JPasswordField();
        confirmPinField.setBounds(640, 310, 200, 25);
        confirmPinField.setBackground(new Color(65, 125, 128));
        confirmPinField.setForeground(Color.WHITE);
        confirmPinField.setFont(new Font("Raleway", Font.BOLD, 18));
        bg.add(confirmPinField);

        // === Buttons ===
        changeBtn = new JButton("CHANGE");
        changeBtn.setBounds(700, 362, 150, 35);
        styleButton(changeBtn, bg);

        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 406, 150, 35);
        styleButton(backBtn, bg);

        // === Frame Settings ===
        setLayout(null);
        setSize(1550, 1000);
        setLocation(0, 0);
        setVisible(true);
    }

    private void styleButton(JButton btn, JLabel parent) {
        btn.setBackground(new Color(65, 125, 128));
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        parent.add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            setVisible(false);
            new main_Class(cardno);
            return;
        }

        if (e.getSource() == changeBtn) {
            try {
                String currentPin = new String(currentPinField.getPassword());
                String newPin = new String(newPinField.getPassword());
                String confirmPin = new String(confirmPinField.getPassword());

                if (currentPin.equals("") || newPin.equals("") || confirmPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "All fields are required!");
                    return;
                }

                if (!newPin.equals(confirmPin)) {
                    JOptionPane.showMessageDialog(null, "New PIN and Confirm PIN do not match!");
                    return;
                }

                Conn c = new Conn();


                ResultSet rs = c.stmt.executeQuery("SELECT * FROM login WHERE cardno = '" + cardno + "' AND pin = '" + currentPin + "'");
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Incorrect Current PIN!");
                    return;
                }


                String query1 = "UPDATE login SET pin = '" + newPin + "' WHERE cardno = '" + cardno + "'";
                String query2 = "UPDATE signup3 SET pin = '" + newPin + "' WHERE cardno = '" + cardno + "'";
                c.stmt.executeUpdate(query1);
                c.stmt.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully!");

                setVisible(false);
                new main_Class(cardno);

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error Occurred While Changing PIN!");
            }
        }
    }

    public static void main(String[] args) {
        new pinChange("");
    }
}
