package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton signinButton,signupButton,clearButton;

    login(){
        super("Bank Management System"); // just a constructor always the first line

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png")); //loads imageIcon
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); //gets image so we can perform certain operations
        ImageIcon i3=new ImageIcon(i2); //imageIcon when you want to show image in swing
        JLabel img=new JLabel(i3);
        img.setBounds(350,10,100,100);
        add(img);



        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png")); //loads imageIcon
        Image ii2=ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); //gets image so we can perform certain operations
        ImageIcon ii3=new ImageIcon(ii2); //imageIcon when you want to show image in swing
        JLabel iimg=new JLabel(ii3);
        iimg.setBounds(650,350,100,100); // x and y are reference from the window
        add(iimg);


        label1=new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2=new JLabel("Card No:");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        label3=new JLabel("Pin No:");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        textField2=new JTextField(15);
        textField2.setBounds(300,190,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);

        passwordField3= new JPasswordField(15);
        passwordField3.setBounds(300,250,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        signinButton=new JButton("SIGN IN");
        signinButton.setFont(new Font("Arial",Font.BOLD,14));
        signinButton.setForeground(Color.white);
        signinButton.setBackground(Color.black);
        signinButton.setBounds(300,300,100,30);
        signinButton.addActionListener(this);
        add(signinButton);

        clearButton=new JButton("CLEAR");
        clearButton.setFont(new Font("Arial",Font.BOLD,14));
        clearButton.setForeground(Color.white);
        clearButton.setBackground(Color.black);
        clearButton.setBounds(430,300,100,30);
        clearButton.addActionListener(this);
        add(clearButton);

        signupButton=new JButton("SIGN UP");
        signupButton.setFont(new Font("Arial",Font.BOLD,14));
        signupButton.setForeground(Color.white);
        signupButton.setBackground(Color.black);
        signupButton.setBounds(300,360,230,30);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon bg1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png")); //loads imageIcon
        Image bg2=bg1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT); //gets image so we can perform certain operations
        ImageIcon bg3=new ImageIcon(bg2); //imageIcon when you want to show image in swing
        JLabel bgg=new JLabel(bg3);
        bgg.setBounds(0,0,850,480); // x and y are reference from the window
        add(bgg);



        setLayout(null); // because we are setting our own layout of component else layout manager decides
        setLocation(450,200); // because frame was opening on top left corner
        setSize(850, 480);
        setVisible(true); //frame visiblity is by default hidden so
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == signinButton){
                String cardno = textField2.getText().trim();
                String pin = passwordField3.getText().trim();


                if (cardno.equals("") || pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter both Card Number and PIN.");
                    return;
                }


                Conn c = new Conn();
                String q = "SELECT * FROM login WHERE cardno='" + cardno + "' AND pin='" + pin + "'";
                ResultSet rs = c.stmt.executeQuery(q);

                if (rs.next()) {

                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    setVisible(false);
                    new main_Class(cardno);
                } else {

                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN.");
                }

            } else if (e.getSource() == signupButton) {
                setVisible(false);
                new signup().setVisible(true);

            }else if(e.getSource() == signupButton){
                new signup();
                setVisible(false);
            }else{
                 textField2.setText("");
                 passwordField3.setText("");
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
