package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;

public class signup extends JFrame implements ActionListener {

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    JTextField textName, textNamef, textEmail, textAddress, textCity, textPin, textState;
    JDateChooser dateChooser;
    JRadioButton r1, r2;
    JButton next;
    JRadioButton m1, m2, m3;

    signup() {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(25, 10, 100, 100);
        add(img);

        JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setBounds(220, 20, 600, 31);
        label1.setFont(new Font("Raleway", Font.BOLD, 30));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(365, 70, 600, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(320, 90, 600, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label3);

        JLabel labelName = new JLabel("Name ");
        labelName.setBounds(100, 190, 200, 30);
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 190, 400, 30);
        add(textName);

        JLabel labelNamef = new JLabel("Father's Name ");
        labelNamef.setBounds(100, 240, 200, 30);
        labelNamef.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelNamef);

        textNamef = new JTextField();
        textNamef.setFont(new Font("Raleway", Font.BOLD, 14));
        textNamef.setBounds(300, 240, 400, 30);
        add(textNamef);

        JLabel dob = new JLabel("Date of Birth ");
        dob.setBounds(100, 290, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 290, 400, 30);
        add(dateChooser);

        JLabel labelGender = new JLabel("Gender ");
        labelGender.setBounds(100, 340, 200, 30);
        labelGender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 340, 90, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(450, 340, 90, 30);
        add(r2);

        ButtonGroup btnGrp = new ButtonGroup();
        btnGrp.add(r1);
        btnGrp.add(r2);

        JLabel labelEmail = new JLabel("Email ");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 390, 200, 30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(300, 390, 400, 30);
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textEmail);

        JLabel labelAddress = new JLabel("Address ");
        labelAddress.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAddress.setBounds(100, 440, 200, 30);
        add(labelAddress);

        textAddress = new JTextField();
        textAddress.setBounds(300, 440, 400, 30);
        textAddress.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textAddress);

        JLabel labelMarital = new JLabel("Marital Status ");
        labelMarital.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMarital.setBounds(100, 490, 200, 30);
        add(labelMarital);

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        m1.setBackground(new Color(222, 255, 228));
        m1.setBounds(300, 490, 100, 30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        m2.setBackground(new Color(222, 255, 228));
        m2.setBounds(420, 490, 120, 30);
        add(m2);

        m3 = new JRadioButton("Others");
        m3.setFont(new Font("Raleway", Font.BOLD, 14));
        m3.setBackground(new Color(222, 255, 228));
        m3.setBounds(560, 490, 100, 30);
        add(m3);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(m1);
        maritalGroup.add(m2);
        maritalGroup.add(m3);

        JLabel labelCity = new JLabel("City ");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100, 540, 200, 30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setBounds(300, 540, 400, 30);
        textCity.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textCity);

        JLabel labelPin = new JLabel("Pin Code ");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100, 590, 200, 30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setBounds(300, 590, 400, 30);
        textPin.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textPin);

        JLabel labelState = new JLabel("State ");
        labelState.setFont(new Font("Raleway", Font.BOLD, 20));
        labelState.setBounds(100, 640, 200, 30);
        add(labelState);

        textState = new JTextField();
        textState.setBounds(300, 640, 400, 30);
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textState);

        next = new JButton("Next");
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(600, 700, 80, 30);
        next.setBackground(Color.black);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fname = textNamef.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = (r1.isSelected()) ? "Male" : (r2.isSelected()) ? "Female" : "";
        String email = textEmail.getText();
        String marital = (m1.isSelected()) ? "Married" : (m2.isSelected()) ? "Unmarried" : (m3.isSelected()) ? "Others" : "";
        String address = textAddress.getText();
        String city = textCity.getText();
        String pin = textPin.getText();
        String state = textState.getText();

        try {
            if (name.equals("") || fname.equals("") || dob.equals("") || gender.equals("") ||
                    email.equals("") || marital.equals("") || address.equals("") ||
                    city.equals("") || pin.equals("") || state.equals("")) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
            } else {
                Conn con = new Conn();
                String q = "INSERT INTO signup VALUES('" + formno + "','" + name + "','" + fname + "','" + dob + "','" +
                        gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                con.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Form Submitted Successfully!");
                new signup2(first);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signup();
    }
}
