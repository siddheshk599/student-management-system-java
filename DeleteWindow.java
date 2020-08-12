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

class DeleteWindow extends JFrame {
    Container c;
    JLabel lblRollNo;
    JTextField txtRollNo;
    JButton btnDelete, btnBack;

    DeleteWindow() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(new Color(199, 255, 253));

        lblRollNo = new JLabel("Enter the Roll Number:");
        txtRollNo = new JTextField(20);

        btnDelete = new JButton("Delete");
        btnBack = new JButton("Back");

        lblRollNo.setFont(new Font("Calibri", Font.BOLD, 24));
        txtRollNo.setFont(new Font("Calibri", Font.BOLD, 24));
        btnDelete.setFont(new Font("Calibri", Font.BOLD, 24));
        btnBack.setFont(new Font("Calibri", Font.BOLD, 24));

        btnDelete.setIcon(new ImageIcon("icons/delete.png"));
        btnBack.setIcon(new ImageIcon("icons/back.png"));

        btnDelete.setBackground(new Color(255, 221, 201));
        btnBack.setBackground(new Color(255, 221, 201));

        lblRollNo.setBackground(new Color(199, 255, 253));
        
        ActionListener btnDeleteAl = (ae) -> {
            String strRollNumber = txtRollNo.getText().trim();
            if (new Validators().rollNumberValidator(strRollNumber)) {
                txtRollNo.setText(strRollNumber);
                
                int rollNumber = Integer.parseInt(strRollNumber);

                HibernateDbHandler hdbh = new HibernateDbHandler();
                hdbh.deleteRecord(rollNumber);
            }
        };
        btnDelete.addActionListener(btnDeleteAl);
        
        ActionListener btnBackAl = (ae) -> {
            MainWindow mw = new MainWindow();
            dispose();
        };
        btnBack.addActionListener(btnBackAl);

        c.add(lblRollNo);
        c.add(txtRollNo);
        c.add(btnDelete);
        c.add(btnBack);

        setTitle("Delete a Student's Record");
        setSize(550, 450);
        setIconImage(new ImageIcon("icons/window.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}