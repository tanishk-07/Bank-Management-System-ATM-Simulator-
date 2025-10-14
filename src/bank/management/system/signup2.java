package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class signup2 extends JFrame implements ActionListener {

    String formno;
    JComboBox comboReligion, comboCategory, comboIncome, comboEducation, comboOccupation;
    JTextField textPan, textAadhar;
    JRadioButton seniorYes, seniorNo;
    JButton next;

    signup2(String formno) {
        super("APPLICATION FORM - PAGE 2");
        this.formno = formno;

        // ==== Bank Icon ====
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(25, 10, 100, 100);
        add(img);

        // ==== Heading ====
        JLabel label1 = new JLabel("APPLICATION FORM NO. " + formno);
        label1.setBounds(220, 20, 600, 31);
        label1.setFont(new Font("Raleway", Font.BOLD, 30));
        add(label1);

        JLabel label2 = new JLabel("Page 2");
        label2.setBounds(365, 70, 600, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label2);

        JLabel label3 = new JLabel("Additional Details");
        label3.setBounds(320, 90, 600, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label3);

        // ==== Religion ====
        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        religionLabel.setBounds(100, 190, 200, 30);
        add(religionLabel);

        String[] rel = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        comboReligion = new JComboBox(rel);
        comboReligion.setBackground(new Color(252, 208, 76));
        comboReligion.setFont(new Font("Raleway", Font.BOLD, 14));
        comboReligion.setBounds(350, 190, 320, 30);
        add(comboReligion);

        // ==== Category ====
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        categoryLabel.setBounds(100, 240, 200, 30);
        add(categoryLabel);

        String[] cat = {"General", "OBC", "SC", "ST", "Other"};
        comboCategory = new JComboBox(cat);
        comboCategory.setBackground(new Color(252, 208, 76));
        comboCategory.setFont(new Font("Raleway", Font.BOLD, 14));
        comboCategory.setBounds(350, 240, 320, 30);
        add(comboCategory);

        // ==== Income ====
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        incomeLabel.setBounds(100, 290, 200, 30);
        add(incomeLabel);

        String[] inc = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Up to 10,00,000", "Above 10,00,000"};
        comboIncome = new JComboBox(inc);
        comboIncome.setBackground(new Color(252, 208, 76));
        comboIncome.setFont(new Font("Raleway", Font.BOLD, 14));
        comboIncome.setBounds(350, 290, 320, 30);
        add(comboIncome);

        // ==== Education ====
        JLabel educationLabel = new JLabel("Educational Qualification:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        educationLabel.setBounds(100, 340, 250, 30);
        add(educationLabel);

        String[] edu = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        comboEducation = new JComboBox(edu);
        comboEducation.setBackground(new Color(252, 208, 76));
        comboEducation.setFont(new Font("Raleway", Font.BOLD, 14));
        comboEducation.setBounds(350, 340, 320, 30);
        add(comboEducation);

        // ==== Occupation ====
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        occupationLabel.setBounds(100, 390, 200, 30);
        add(occupationLabel);

        String[] occ = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        comboOccupation = new JComboBox(occ);
        comboOccupation.setBackground(new Color(252, 208, 76));
        comboOccupation.setFont(new Font("Raleway", Font.BOLD, 14));
        comboOccupation.setBounds(350, 390, 320, 30);
        add(comboOccupation);

        // ==== PAN Number ====
        JLabel panLabel = new JLabel("PAN Number:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        panLabel.setBounds(100, 440, 200, 30);
        add(panLabel);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD, 14));
        textPan.setBounds(350, 440, 320, 30);
        add(textPan);

        // ==== Aadhaar Number ====
        JLabel aadharLabel = new JLabel("Aadhaar Number:");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        aadharLabel.setBounds(100, 490, 200, 30);
        add(aadharLabel);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        textAadhar.setBounds(350, 490, 320, 30);
        add(textAadhar);

        // ==== Senior Citizen ====
        JLabel seniorLabel = new JLabel("Senior Citizen:");
        seniorLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorLabel.setBounds(100, 540, 200, 30);
        add(seniorLabel);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBackground(new Color(252, 208, 76));
        seniorYes.setFont(new Font("Raleway", Font.BOLD, 14));
        seniorYes.setBounds(350, 540, 100, 30);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBackground(new Color(252, 208, 76));
        seniorNo.setFont(new Font("Raleway", Font.BOLD, 14));
        seniorNo.setBounds(460, 540, 100, 30);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        // ==== Next Button ====
        next = new JButton("Next");
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(600, 700, 80, 30);
        next.setBackground(Color.black);
        next.addActionListener(this);
        add(next);

        // ==== Frame Settings ====
        setLayout(null);
        setSize(850, 800);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(252, 208, 76));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) comboReligion.getSelectedItem();
        String category = (String) comboCategory.getSelectedItem();
        String income = (String) comboIncome.getSelectedItem();
        String education = (String) comboEducation.getSelectedItem();
        String occupation = (String) comboOccupation.getSelectedItem();
        String pan = textPan.getText();
        String aadhar = textAadhar.getText();
        String senior = null;
        if (seniorYes.isSelected()) senior = "Yes";
        else if (seniorNo.isSelected()) senior = "No";

        try {
            if (pan.equals("") || aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all required fields");
            } else {
                Conn c1 = new Conn();
                String query = "INSERT INTO signup2 VALUES('" + formno + "', '" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" + pan + "', '" + aadhar + "', '" + senior + "')";
                c1.stmt.executeUpdate(query);

                // Go to next page
                setVisible(false);
                new signup3(formno).setVisible(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signup2("");
    }
}
