import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

class AddWindow extends JFrame {
    Container c;
    JLabel lblRollNo, lblName, lblPhysicsMarks, lblChemistryMarks, lblMathsMarks;
    JTextField txtRollNo, txtName, txtPhysicsMarks, txtChemistryMarks, txtMathsMarks;
    JButton btnAdd, btnBack;

    AddWindow() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(new Color(199, 255, 253));

        lblRollNo = new JLabel("Enter the Roll Number:");
        txtRollNo = new JTextField(20);

        lblName = new JLabel("Enter the Name:");
        txtName = new JTextField(20);

        lblPhysicsMarks = new JLabel("Enter the Physics marks:");
        txtPhysicsMarks = new JTextField(20);

        lblChemistryMarks = new JLabel("Enter the Chemistry marks:");
        txtChemistryMarks = new JTextField(20);
        
        lblMathsMarks = new JLabel("Enter the Maths marks:");
        txtMathsMarks = new JTextField(20);

        btnAdd = new JButton("Add");
        btnBack = new JButton("Back");

        lblRollNo.setFont(new Font("Calibri", Font.BOLD, 24));
        lblName.setFont(new Font("Calibri", Font.BOLD, 24));
        lblPhysicsMarks.setFont(new Font("Calibri", Font.BOLD, 24));
        lblChemistryMarks.setFont(new Font("Calibri", Font.BOLD, 24));
        lblMathsMarks.setFont(new Font("Calibri", Font.BOLD, 24));

        txtRollNo.setFont(new Font("Calibri", Font.BOLD, 24));
        txtName.setFont(new Font("Calibri", Font.BOLD, 24));
        txtPhysicsMarks.setFont(new Font("Calibri", Font.BOLD, 24));
        txtChemistryMarks.setFont(new Font("Calibri", Font.BOLD, 24));
        txtMathsMarks.setFont(new Font("Calibri", Font.BOLD, 24));

        btnAdd.setFont(new Font("Calibri", Font.BOLD, 24));
        btnBack.setFont(new Font("Calibri", Font.BOLD, 24));

        btnAdd.setIcon(new ImageIcon("icons/add.png"));
        btnBack.setIcon(new ImageIcon("icons/back.png"));

        btnAdd.setBackground(new Color(255, 221, 201));
        btnBack.setBackground(new Color(255, 221, 201));

        lblRollNo.setBackground(new Color(199, 255, 253));
        lblName.setBackground(new Color(199, 255, 253));
        lblPhysicsMarks.setBackground(new Color(199, 255, 253));
        lblChemistryMarks.setBackground(new Color(199, 255, 253));
        lblMathsMarks.setBackground(new Color(199, 255, 253));

        ActionListener btnAddAl = (ae) -> {
            String strRollNumber = txtRollNo.getText().trim();
            if (new Validators().rollNumberValidator(strRollNumber)) {
                String name = txtName.getText().trim();
                if (new Validators().nameValidator(name)) {
                    String strPhysicsMarks = txtPhysicsMarks.getText().trim();
                    String strChemistryMarks = txtChemistryMarks.getText().trim();
                    String strMathsMarks = txtMathsMarks.getText().trim();

                    if (new Validators().marksValidator(strPhysicsMarks, "Physics")) {
                        if (new Validators().marksValidator(strChemistryMarks, "Chemistry")) {
                            if (new Validators().marksValidator(strMathsMarks, "Maths")) {
                                txtRollNo.setText(strRollNumber);
                                txtName.setText(name);
                                txtPhysicsMarks.setText(strPhysicsMarks);
                                txtChemistryMarks.setText(strChemistryMarks);
                                txtMathsMarks.setText(strMathsMarks);

                                int rollNumber = Integer.parseInt(strRollNumber);
                                int physicsMarks = Integer.parseInt(strPhysicsMarks);
                                int chemistryMarks = Integer.parseInt(strChemistryMarks);
                                int mathsMarks = Integer.parseInt(strMathsMarks);

                                HibernateDbHandler hdbh = new HibernateDbHandler();
                                hdbh.addRecord(rollNumber, name, physicsMarks, chemistryMarks, mathsMarks);
                            }
                        }
                    }
                }
            }
        };
        btnAdd.addActionListener(btnAddAl);
        
        ActionListener btnBackAl = (ae) -> {
            MainWindow mw = new MainWindow();
            dispose();
        };
        btnBack.addActionListener(btnBackAl);

        c.add(lblRollNo);
        c.add(txtRollNo);
        c.add(lblName);
        c.add(txtName);
        c.add(lblPhysicsMarks);
        c.add(txtPhysicsMarks);
        c.add(lblChemistryMarks);
        c.add(txtChemistryMarks);
        c.add(lblMathsMarks);
        c.add(txtMathsMarks);
        c.add(btnAdd);
        c.add(btnBack);

        setTitle("Add a Student's Record");
        setSize(550, 550);
        setIconImage(new ImageIcon("icons/window.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}