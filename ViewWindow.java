import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

class ViewWindow extends JFrame {
    Container c;
    TextArea taRecords;
    JButton btnBack;

    ViewWindow(List<Student> studentList) {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(new Color(199, 255, 253));

        taRecords = new TextArea(30, 60);
        btnBack = new JButton("Back");

        btnBack.setIcon(new ImageIcon("icons/back.png"));
        taRecords.setFont(new Font("Calibri", Font.BOLD, 12));
        btnBack.setFont(new Font("Calibri", Font.BOLD, 24));
        btnBack.setBackground(new Color(255, 221, 201));

        c.add(taRecords);
        c.add(btnBack);

        if (!studentList.isEmpty()) {
            for (Student s: studentList) {
                taRecords.append("Roll No.: " + s.rollNumber);
                taRecords.append("\nName: " + s.name);
                taRecords.append("\nPhysics marks (out of 100): " + s.physicsMarks);
                taRecords.append("\nChemistry marks (out of 100): " + s.chemistryMarks);
                taRecords.append("\nMaths marks (out of 100): " + s.mathsMarks + "\n\n");
            }
        } else {
            JOptionPane.showMessageDialog(c, "No records in the database.", "Empty Database", JOptionPane.WARNING_MESSAGE);
        }

        ActionListener btnBackAl = (ae) -> {
            MainWindow mw = new MainWindow();
            dispose();
        };
        btnBack.addActionListener(btnBackAl);

        setTitle("View Students' Records");
        setSize(580, 580);
        setIconImage(new ImageIcon("icons/window.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}