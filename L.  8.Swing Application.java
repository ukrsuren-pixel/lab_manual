import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StudentRegistration extends JFrame implements ActionListener {
    JLabel lblUSN, lblName, lblBranch, lblGender, lblSkills;
    JTextField txtUSN, txtName;
    JComboBox<String> cmbBranch;
    JRadioButton rbMale, rbFemale;
    ButtonGroup genderGroup;
    JCheckBox cbJava, cbPython;
    JButton btnSubmit, btnClear;
    JTextArea ta;
    StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(500, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblUSN = new JLabel("USN");
        lblUSN.setBounds(30, 30, 100, 25);
        add(lblUSN);
        txtUSN = new JTextField();
        txtUSN.setBounds(150, 30, 200, 25);
        add(txtUSN);
        lblName = new JLabel("Name");
        lblName.setBounds(30, 70, 100, 25);
        add(lblName);
        txtName = new JTextField();
        txtName.setBounds(150, 70, 200, 25);
        add(txtName);

        lblBranch = new JLabel("Branch");
        lblBranch.setBounds(30, 110, 100, 25);
        add(lblBranch);
        String branches[] = {
                "Computer Science",
                "Information Technology",
                "ECE",
                "EEE",
                "Mechanical"
        };
        cmbBranch = new JComboBox<>(branches);
        cmbBranch.setBounds(150, 110, 200, 25);
        add(cmbBranch);
        lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 150, 100, 25);
        add(lblGender);
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");.
        rbMale.setBounds(150, 150, 80, 25);
        rbFemale.setBounds(240, 150, 100, 25);
        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        add(rbMale);
        add(rbFemale);
        lblSkills = new JLabel("Skills");
        lblSkills.setBounds(30, 190, 100, 25);
        add(lblSkills);
        cbJava = new JCheckBox("Java");
        cbPython = new JCheckBox("Python");
        cbJava.setBounds(150, 190, 80, 25);
        cbPython.setBounds(240, 190, 100, 25);
        add(cbJava);
        add(cbPython);
        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");
        btnSubmit.setBounds(120, 240, 100, 30);
        btnClear.setBounds(240, 240, 100, 30);
        add(btnSubmit);
        add(btnClear);
        btnSubmit.addActionListener(this);
        btnClear.addictionListener(this);
       ta = new JTextArea();
        ta.setBounds(30, 290, 420, 180);
        ta.setEditable(false);.
        add(ta);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent (){
        if (e.getSource() == btnSubmit) {
            if (txtUSN.getText().trim().isEmpty()
                    || txtName.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "USN and Name cannot be empty!");
                return;
            }
            String gender = "";
            if (rbMale.isSelected())
                gender = "Male";
            else if (rbFemale.isSelected())
                gender = "Female";
            else
                gender = "Not Selected";
            String skills = "";
            if (cbJava.isSelected())
                skills += "Java ";
            if (cbPython.isSelected())
                skills += "Python";
            ta.setText(
                    "--------- Student Details ---------\n\n"
                            + "USN : " + txtUSN.getText() + "\n"
                            + "Name : " + txtName.getText() + "\n"
                            + "Branch : " + cmbBranch.getSelectedItem() + "\n"
                            + "Gender : " + gender + "\n"
                            + "Skills : " + skills);
        }
        if (e.getSource() == btnClear) {
            txtUSN.setText("");
            txtName.setText("");
            cmbBranch.setSelectedIndex(0);
            genderGroup.clearSelection();
            cbJava.setSelected(false);
            cbPython.setSelected(false);
            ta.setText("");
        }
    }
    public static void main(String[] args) {
        new StudentRegistration();
    }}
