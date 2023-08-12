import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student {
    private JButton calculateButton;
    private JTextField txtOOPJ;
    private JTextField txtDS;
    private JTextField txtMaths;
    private JTextField txtCG;
    private JTextField txtDLCA;
    private JTextField txtTotal;
    private JTextField txtAverage;
    private JTextField txtGrade;
    private JPanel Main;
    private JTextField txtStName;
    private JTextField txtRoll;
    private JTextField txtDivision;
    private JTextField txtBranch;
    private JTextField txtEmail;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox day;
    private JComboBox month;
    private JComboBox year;
    private JTextArea textArea;
    private JButton submitButton;
    private JCheckBox checkBox;
    private JLabel txtDone;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Student");
        frame.setContentPane(new Student().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Student() {

        maleRadioButton.setSelected(true);
        ButtonGroup gen = new ButtonGroup();
        gen.add(maleRadioButton);
        gen.add(femaleRadioButton);

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        String years[] = {"2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005",
                "2004", "2003", "2002", "2001", "2000", "1999", "1998"};
        day.setModel(new DefaultComboBoxModel(days));
        month.setModel(new DefaultComboBoxModel(months));
        year.setModel(new DefaultComboBoxModel(years));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                int m1, m2, m3, m4, m5, total;
                float percentage = 0;

                m1 = Integer.parseInt(txtOOPJ.getText());
                m2 = Integer.parseInt(txtDS.getText());
                m3 = Integer.parseInt(txtMaths.getText());
                m4 = Integer.parseInt(txtDLCA.getText());
                m5 = Integer.parseInt(txtCG.getText());

                if (m1 > 100 || m2 > 100 || m3 > 100 || m4 > 100 || m5 > 100 || m1 < 0 || m2 < 0 || m3 < 0 || m4 < 0 || m5 < 0) {
                    txtTotal.setText(String.valueOf("Invalid Marks"));
                    txtAverage.setText(String.valueOf("Invalid Marks"));
                    txtGrade.setText("---");
                }
                else {
                    total = m1 + m2 + m3 + m4 + m5;

                    txtTotal.setText(String.valueOf(total));

                    percentage = (total / 500f)*100;

                    txtAverage.setText(String.valueOf(percentage));
                }
                if (percentage > 35) {
                    txtGrade.setText("Pass");
                } else {
                    txtGrade.setText("Fail");
                }
            }
        });

        Main.setBackground(Color.CYAN);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    txtDone.setText("Registration Successful");

                    String name = txtStName.getText();
                    String roll = txtRoll.getText();
                    String division = txtDivision.getText();
                    String branch = txtBranch.getText();
                    String email = txtEmail.getText();
                    String gender = "male";
                    if (femaleRadioButton.isSelected()) {
                        gender = "female";
                    }
                    String dob = day.getSelectedItem() + " - " + month.getSelectedItem() + " - " + year.getSelectedItem();
                    //Marks
                    String oopj = txtOOPJ.getText();
                    String ds = txtDS.getText();
                    String maths = txtMaths.getText();
                    String dlca = txtDLCA.getText();
                    String cg = txtCG.getText();
                    String tot = txtTotal.getText();
                    String per = txtAverage.getText();
                    String grade = txtGrade.getText();

                    textArea.setText("Name : " + name + "\n" + "Roll number : " + roll + "\n" + "Division : " + division +
                            "\n" + "Branch : " + branch + "\n" + "Email : " + email + "\n\n" +
                            "MARKS\n\n"+"OOPJ = "+oopj+"\n\n" + "Data Structures = "+ds+"\n\n" + "Mathematics = "+maths+"\n\n"+
                            "DLCA = "+dlca+"\n\n"+"CG = "+cg+"\n\n"+
                            "-----------------------------------------" +
                            ""+"\n\n"+"Total Marks = "+tot+"\n\n"+"Percentage = "+per+"\n\n"+"Grade = "+grade);
                }
                else {
                    txtDone.setText("Please accept terms and conditions first to submit!");
                    textArea.setText("");
                }
            }
        });
    };
}