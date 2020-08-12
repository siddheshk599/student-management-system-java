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

class MarksAnalysisWindow extends JFrame {
    Container c;
    TextArea taMarksAnalysis;
    JButton btnBack;

    MarksAnalysisWindow() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(new Color(199, 255, 253));

        taMarksAnalysis = new TextArea(30, 60);
        btnBack = new JButton("Back");

        btnBack.setIcon(new ImageIcon("icons/back.png"));
        btnBack.setFont(new Font("Calibri", Font.BOLD, 24));
        taMarksAnalysis.setFont(new Font("Calibri", Font.BOLD, 12));
        btnBack.setBackground(new Color(255, 221, 201));

        c.add(taMarksAnalysis);
        c.add(btnBack);

        HibernateDbHandler hdbh = new HibernateDbHandler();
        List<Student> studentList = hdbh.getRecords();
        int maxPhysicsMarks = 0, maxChemistryMarks = 0, maxMathsMarks = 0, physicsMarksSum = 0, chemistryMarksSum = 0, mathsMarksSum = 0, count = 0;
        String maxPhysicsMarksName = "", maxChemistryMarksName = "", maxMathsMarksName = "";
        double avgPhysicsMarks = 0.0, avgChemistryMarks = 0.0, avgMathsMarks = 0.0;

        for (Student s: studentList) {
            physicsMarksSum += s.physicsMarks;
            chemistryMarksSum += s.chemistryMarks;
            mathsMarksSum += s.mathsMarks;
            ++count;

            if (maxPhysicsMarks < s.physicsMarks) {
                maxPhysicsMarks = s.physicsMarks;
                maxPhysicsMarksName = s.name;
            }
            if (maxChemistryMarks < s.chemistryMarks) {
                maxChemistryMarks = s.chemistryMarks;
                maxChemistryMarksName = s.name;
            }
            if (maxMathsMarks < s.mathsMarks) {
                maxMathsMarks = s.mathsMarks;
                maxMathsMarksName = s.name;
            }
        }

        taMarksAnalysis.setText("");
        taMarksAnalysis.append("Top Scorers:");
        taMarksAnalysis.append("\nPhysics:");
        taMarksAnalysis.append("\nName: " + maxPhysicsMarksName + "\nMarks (out of 100): " + maxPhysicsMarks);
        taMarksAnalysis.append("\n\nChemistry:");
        taMarksAnalysis.append("\nName: " + maxChemistryMarksName + "\nMarks (out of 100): " + maxChemistryMarks);
        taMarksAnalysis.append("\n\nMaths:");
        taMarksAnalysis.append("\nName: " + maxMathsMarksName + "\nMarks (out of 100): " + maxMathsMarks);

        try {
            avgPhysicsMarks = physicsMarksSum/count;
            avgChemistryMarks = chemistryMarksSum/count;
            avgMathsMarks = mathsMarksSum/count;

            taMarksAnalysis.append("\n\nAverage scores:");
            taMarksAnalysis.append("\nPhysics: " + avgPhysicsMarks + " marks out of 100." + "\nChemistry: " + avgChemistryMarks + " marks out of 100." + "\nMaths: " + avgMathsMarks + " marks out of 100.");
        } catch(ArithmeticException ae) {
            JOptionPane.showMessageDialog(c, "Insert records in the database first. Error: " + ae, "No records found", JOptionPane.WARNING_MESSAGE);
        }

        ActionListener btnBackAl = (ae) -> {
            MainWindow mw = new MainWindow();
            dispose();
        };
        btnBack.addActionListener(btnBackAl);

        setTitle("Students' Marks Analysis");
        setSize(580, 580);
        setIconImage(new ImageIcon("icons/window.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}