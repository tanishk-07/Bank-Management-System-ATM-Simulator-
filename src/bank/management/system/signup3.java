package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    ButtonGroup accountTypeGroup;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno; // to store form number

    signup3(String formno) {
        super("APPLICATION FORM - PAGE 3");
        this.formno = formno;

        // ==== Bank Icon ====
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(25, 10, 100, 100);
        add(img);

        // ==== Headings ====
        JLabel label1 = new JLabel("Page 3");
        label1.setFont(new Font("Raleway", Font.BOLD, 22));
        label1.setBounds(370, 40, 400, 40);
        add(label1);

        JLabel label2 = new JLabel("Account Details");
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        label2.setBounds(320, 70, 400, 40);
        add(label2);

        // ==== Account Type ====
        JLabel label3 = new JLabel("Account Type:");
        label3.setFont(new Font("Raleway", Font.BOLD, 18));
        label3.setBounds(100, 140, 200, 30);
        add(label3);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(215, 252, 252));
        r1.setBounds(100, 180, 200, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(215, 252, 252));
        r2.setBounds(350, 180, 250, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(215, 252, 252));
        r3.setBounds(100, 220, 200, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(new Color(215, 252, 252));
        r4.setBounds(350, 220, 250, 30);
        add(r4);

        accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(r1);
        accountTypeGroup.add(r2);
        accountTypeGroup.add(r3);
        accountTypeGroup.add(r4);

        // ==== Card Number ====
        JLabel cardLabel = new JLabel("Card Number:");
        cardLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        cardLabel.setBounds(100, 300, 200, 30);
        add(cardLabel);

        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-1234");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        cardNumber.setBounds(300, 300, 400, 30);
        add(cardNumber);

        JLabel cardHint = new JLabel("(Your 16-digit card number will be generated automatically)");
        cardHint.setFont(new Font("Raleway", Font.PLAIN, 12));
        cardHint.setBounds(300, 330, 500, 20);
        add(cardHint);

        // ==== PIN ====
        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        pinLabel.setBounds(100, 380, 200, 30);
        add(pinLabel);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pinNumber.setBounds(300, 380, 200, 30);
        add(pinNumber);

        JLabel pinHint = new JLabel("(Your 4-digit password will be generated automatically)");
        pinHint.setFont(new Font("Raleway", Font.PLAIN, 12));
        pinHint.setBounds(300, 410, 500, 20);
        add(pinHint);

        // ==== Services Required ====
        JLabel servicesLabel = new JLabel("Services Required:");
        servicesLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        servicesLabel.setBounds(100, 470, 200, 30);
        add(servicesLabel);

        c1 = new JCheckBox("ATM Card");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("Email Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");
        c7 = new JCheckBox("I hereby declare that the above entered details are correct.");

        JCheckBox[] boxes = {c1, c2, c3, c4, c5, c6, c7};
        int y = 510;
        for (int i = 0; i < boxes.length; i++) {
            JCheckBox cb = boxes[i];
            cb.setBackground(new Color(215, 252, 252));
            cb.setFont(new Font("Raleway", Font.BOLD, (i == 6) ? 12 : 14));
            cb.setBounds((i % 2 == 0) ? 100 : 350, y, (i == 6) ? 600 : 200, 30);
            add(cb);
            if (i % 2 == 1) y += 40;
        }

        // ==== Buttons ====
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(220, 690, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 690, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        // ==== Frame Setup ====
        setLayout(null);
        setSize(850, 800);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(215, 252, 252));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) accountType = "Saving Account";
            else if (r2.isSelected()) accountType = "Fixed Deposit Account";
            else if (r3.isSelected()) accountType = "Current Account";
            else if (r4.isSelected()) accountType = "Recurring Deposit Account";


            Random ran = new Random();
            long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
            String cardno = "" + Math.abs(first7);

            long first3 = (ran.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(first3);


            String facility = "";
            if (c1.isSelected()) facility += " ATM Card";
            if (c2.isSelected()) facility += " Internet Banking";
            if (c3.isSelected()) facility += " Mobile Banking";
            if (c4.isSelected()) facility += " Email Alerts";
            if (c5.isSelected()) facility += " Cheque Book";
            if (c6.isSelected()) facility += " E-Statement";

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Account Type is required");
                return;
            }

            if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please confirm the declaration");
                return;
            }

            try {
                Conn c1 = new Conn();
                String q1 = "INSERT INTO signup3 VALUES('" + formno + "', '" + accountType + "', '" + cardno + "', '" + pin + "', '" + facility + "')";
                String q2 = "INSERT INTO login VALUES('" + formno + "', '" + cardno + "', '" + pin + "')";
                c1.stmt.executeUpdate(q1);
                c1.stmt.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\nPIN: " + pin);

                setVisible(false);
                new deposit(pin);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new signup3("").setVisible(true);
    }
}
