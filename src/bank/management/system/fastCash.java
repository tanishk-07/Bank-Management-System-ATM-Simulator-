package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {

    String cardno;
    JButton b1, b2, b3, b4, b5, b6, backBtn;

    fastCash(String cardno) {
        super("FAST CASH");
        this.cardno = cardno;

        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0, 0, 1550, 830);
        add(bg);

        // Title
        JLabel title = new JLabel("SELECT WITHDRAWAL AMOUNT");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("System", Font.BOLD, 20));
        title.setBounds(470, 180, 600, 35);
        bg.add(title);

        // Buttons for different amounts
        b1 = new JButton("Rs 100");
        b1.setBounds(410, 274, 150, 35);
        styleButton(b1, bg);

        b2 = new JButton("Rs 500");
        b2.setBounds(700, 274, 150, 35);
        styleButton(b2, bg);

        b3 = new JButton("Rs 1000");
        b3.setBounds(410, 318, 150, 35);
        styleButton(b3, bg);

        b4 = new JButton("Rs 2000");
        b4.setBounds(700, 318, 150, 35);
        styleButton(b4, bg);

        b5 = new JButton("Rs 5000");
        b5.setBounds(410, 362, 150, 35);
        styleButton(b5, bg);

        b6 = new JButton("Rs 10000");
        b6.setBounds(700, 362, 150, 35);
        styleButton(b6, bg);

        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 406, 150, 35);
        styleButton(backBtn, bg);

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
        try {
            if (e.getSource() == backBtn) {
                setVisible(false);
                new main_Class(cardno);
                return;
            }

            // Determine selected amount
            String amountText = ((JButton) e.getSource()).getText().substring(3).trim();
            int amount = Integer.parseInt(amountText);

            Conn c = new Conn();

            // Get current balance
            ResultSet rs = c.stmt.executeQuery("SELECT * FROM BankManagementSystem WHERE cardno = '" + cardno + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
                return;
            }

            Date date = new Date();
            String query = "INSERT INTO BankManagementSystem (cardno, date, type, amount) VALUES ('" + cardno + "', '" + date + "', 'Withdrawal', '" + amount + "')";
            c.stmt.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

            setVisible(false);
            new main_Class(cardno);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Transaction Failed! Please Try Again.");
        }
    }

    public static void main(String[] args) {
        new fastCash("");
    }
}
