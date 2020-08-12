import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

class MainWindow extends JFrame {
    Container c;
    JButton btnAdd, btnView, btnUpdate, btnDelete, btnCharts, btnAnalysis;

    MainWindow() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(new Color(199, 255, 253));

        btnAdd = new JButton("Add");
        btnView = new JButton("View");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnCharts = new JButton("Performance Chart");
        btnAnalysis = new JButton("Analysis of Marks");
        
        btnAdd.setFont(new Font("Calibri", Font.BOLD, 24));
        btnView.setFont(new Font("Calibri", Font.BOLD, 24));
        btnUpdate.setFont(new Font("Calibri", Font.BOLD, 24));
        btnDelete.setFont(new Font("Calibri", Font.BOLD, 24));
        btnCharts.setFont(new Font("Calibri", Font.BOLD, 24));
        btnAnalysis.setFont(new Font("Calibri", Font.BOLD, 24));

        btnAdd.setIcon(new ImageIcon("icons/add.png"));
        btnView.setIcon(new ImageIcon("icons/view.png"));
        btnUpdate.setIcon(new ImageIcon("icons/update.png"));
        btnDelete.setIcon(new ImageIcon("icons/delete.png"));
        btnCharts.setIcon(new ImageIcon("icons/chart.png"));
        btnAnalysis.setIcon(new ImageIcon("icons/analysis.png"));

        btnAdd.setBackground(new Color(255, 221, 201));
        btnView.setBackground(new Color(255, 221, 201));
        btnUpdate.setBackground(new Color(255, 221, 201));
        btnDelete.setBackground(new Color(255, 221, 201));
        btnCharts.setBackground(new Color(255, 221, 201));
        btnAnalysis.setBackground(new Color(255, 221, 201));

        ActionListener btnAddAl = (ae) -> {
            AddWindow aw = new AddWindow();
            dispose();
        };
        btnAdd.addActionListener(btnAddAl);

        ActionListener btnViewAl = (ae) -> {
            HibernateDbHandler hdbh = new HibernateDbHandler();
            List<Student> studentList = hdbh.getRecords();
            ViewWindow vw = new ViewWindow(studentList);
            dispose();
        };
        btnView.addActionListener(btnViewAl);

        ActionListener btnUpdateAl = (ae) -> {
            UpdateWindow uw = new UpdateWindow();
            dispose();
        };
        btnUpdate.addActionListener(btnUpdateAl);

        ActionListener btnDeleteAl = (ae) -> {
            DeleteWindow aw = new DeleteWindow();
            dispose();
        };
        btnDelete.addActionListener(btnDeleteAl);

        ActionListener btnChartsAl = (ae) -> {
            BarChart bch = new BarChart();
        };
        btnCharts.addActionListener(btnChartsAl);

        ActionListener btnAnalysisAl = (ae) -> {
            MarksAnalysisWindow maw = new MarksAnalysisWindow();
            dispose();
        };
        btnAnalysis.addActionListener(btnAnalysisAl);
        
        c.add(btnAdd);
        c.add(btnView);
        c.add(btnUpdate);
        c.add(btnDelete);
        c.add(btnCharts);
        c.add(btnAnalysis);

        setTitle("Student Management System");
        setSize(500, 500);
        setIconImage(new ImageIcon("icons/window.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        MainWindow mw = new MainWindow();
    }
}