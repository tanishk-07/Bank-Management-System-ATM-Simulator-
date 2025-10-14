package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {

    String cardno;
    JButton backBtn;

    balanceEnquiry(String cardno) {
        super("BALANCE ENQUIRY");
        this.cardno = cardno;

        // ATM Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0, 0, 1550, 830);
        add(bg);

        JLabel title = new JLabel("YOUR CURRENT ACCOUNT BALANCE IS:");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("System", Font.BOLD, 18));
        title.setBounds(460, 180, 600, 35);
        bg.add(title);


        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("SELECT * FROM BankManagementSystem WHERE cardno = '" + cardno + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel balanceLabel = new JLabel("Rs. " + balance);
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("Raleway", Font.BOLD, 24));
        balanceLabel.setBounds(460, 230, 400, 40);
        bg.add(balanceLabel);

        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 406, 150, 35);
        backBtn.setBackground(new Color(65, 125, 128));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        bg.add(backBtn);

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
        new balanceEnquiry("");
    }
}
