package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {

    String cardno;
    TextField textField;
    JButton b1,b2;
    withdraw(String cardno){
        super("WITHDRAW");
        this.cardno=cardno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1=new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(460,180,700,35);
        l3.add(label1);

        textField=new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);

        b1=new JButton("WITHDRAW");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1000);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {  // Withdraw button clicked
                String amount = textField.getText().trim();


                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
                    return;
                }

                Conn c = new Conn();
                Date date = new Date();


                String query = "SELECT * FROM BankManagementSystem WHERE cardno= '" + cardno + "'";
                ResultSet rs = c.stmt.executeQuery(query);

                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }


                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
                    return;
                }


                String insertQuery = "INSERT INTO BankManagementSystem (cardno, date, type, amount) VALUES ('" + cardno + "', '" + date + "', 'Withdrawal', '" + amount + "')";
                c.stmt.executeUpdate(insertQuery);

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                setVisible(false);
                new main_Class(cardno);

            } else if (e.getSource() == b2) {  // Back button clicked
                setVisible(false);
                new main_Class(cardno);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while processing your request.");
        }
    }

    public static void main(String[] args) {
        new withdraw("");
    }
}
