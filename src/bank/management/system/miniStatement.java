package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class miniStatement extends JFrame implements ActionListener {

    String cardno;
    JButton backBtn;

    miniStatement(String cardno) {
        super("MINI STATEMENT");
        this.cardno = cardno;

        // === Background ===
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0, 0, 1550, 830);
        add(bg);

        // === Title ===


        // === Transactions Area ===
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(new Color(65, 125, 128));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(400, 140, 456, 250);
        bg.add(scrollPane);

        // === Back Button ===
        backBtn = new JButton("BACK");
        backBtn.setBounds(700,406,150,35);
        backBtn.setBackground(new Color(65, 125, 128));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);

        bg.add(backBtn);


        try {
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("SELECT * FROM BankManagementSystem WHERE cardno = '" + cardno + "' ORDER BY date DESC");

            StringBuilder transactions = new StringBuilder();
            int count = 0;
            int balance = 0;

            while (rs.next() && count < 10) { // Show only latest 10 transactions
                String type = rs.getString("type");
                String amount = rs.getString("amount");
                String date = rs.getString("date");

                transactions.append(String.format("%-15s %-15s %-10s\n", date.substring(0, 19), type, "Rs. " + amount));
                count++;
            }

            if (transactions.length() == 0) {
                textArea.setText("No transactions found for this account.");
            } else {
                textArea.setText("Date & Time        |  Type         |  Amount\n");
                textArea.append("---------------------------------------------\n");
                textArea.append(transactions.toString());
            }

            ResultSet rs2 = c.stmt.executeQuery("SELECT * FROM BankManagementSystem WHERE cardno = '" + cardno + "'");
            while (rs2.next()) {
                if (rs2.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs2.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs2.getString("amount"));
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading mini statement!");
        }


        setLayout(null);
        setSize(1550, 1000);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(cardno);
    }

    public static void main(String[] args) {
        new miniStatement("");
    }
}
