import javax.swing.JFrame;
import java.util.List;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

class BarChart extends JFrame {
    BarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HibernateDbHandler hdbh = new HibernateDbHandler();
        List<Student> studentList = hdbh.getRecords();

        for (Student s: studentList) {
            dataset.addValue(s.physicsMarks, s.name, "Physics");
            dataset.addValue(s.chemistryMarks, s.name, "Chemistry");
            dataset.addValue(s.mathsMarks, s.name, "Maths");
        }

        JFreeChart chart = ChartFactory.createBarChart("Marks of Students", "Subjects", "Marks", dataset, PlotOrientation.VERTICAL, true, false, false);

        ChartPanel cp = new ChartPanel(chart);
        setContentPane(cp);

        setTitle("Marks of Students");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}