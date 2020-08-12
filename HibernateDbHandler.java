import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.util.ArrayList;
import java.util.List;

class HibernateDbHandler {

    public void addRecord(int rollNumber, String name, int physicsMarks, int chemistryMarks, int mathsMarks) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact = cfg.buildSessionFactory();
        Session session = null;
        Transaction transac = null;
        try {
            session = sfact.openSession();
            transac = session.beginTransaction();
            Student s = new Student(rollNumber, name, physicsMarks, chemistryMarks, mathsMarks);
            session.save(s);
            transac.commit();
            JOptionPane.showMessageDialog(new JDialog(), "1 record added successfully.", "Record added", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            transac.rollback();
            JOptionPane.showMessageDialog(new JDialog(), e, "Record Insertion Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            session.close();
        }
    }

    public void deleteRecord(int rollNumber) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact = cfg.buildSessionFactory();
        Session session = null;
        Transaction transac = null;
        try {
            session = sfact.openSession();
            transac = session.beginTransaction();
            Student s = (Student) session.get(Student.class, rollNumber);
            if (s != null) {
                session.delete(s);
                transac.commit();
                JOptionPane.showMessageDialog(new JDialog(), "Record of Roll No. " + rollNumber + " deleted.", "Record deleted", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JDialog(), "Record of Roll No. " + rollNumber + " not found.", "Record deletion failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception e) {
            transac.rollback();
            JOptionPane.showMessageDialog(new JDialog(), e, "Record Deletion Error", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            session.close();
        }
    }

    public List<Student> getRecords() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact = cfg.buildSessionFactory();
        Session session = null;
        List<Student> studentList = new ArrayList<Student>();
        try {
            session = sfact.openSession();
            studentList = session.createQuery("from Student").list();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(new JDialog(), e, "Error in fetching records", JOptionPane.ERROR_MESSAGE);
        } finally {
            session.close();
        }
        return studentList;
    }

    public void updateRecord(int rollNumber, String name, int physicsMarks, int chemistryMarks, int mathsMarks) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact = cfg.buildSessionFactory();
        Session session = null;
        Transaction transac = null;
        try {
            session = sfact.openSession();
            transac = session.beginTransaction();
            Student s = (Student) session.get(Student.class, rollNumber);
            if (s != null) {
                s.setRollNumber(rollNumber);
                s.setName(name);
                s.setPhysicsMarks(physicsMarks);
                s.setChemistryMarks(chemistryMarks);
                s.setMathsMarks(mathsMarks);
                transac.commit();
                JOptionPane.showMessageDialog(new JDialog(), "Record of Roll No. " + rollNumber + " updated.", "Record updated", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JDialog(), "Record of Roll No. " + rollNumber + " not found.", "Record updation failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception e) {
            transac.rollback();
            JOptionPane.showMessageDialog(new JDialog(), e, "Record Updation Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            session.close();
        }
    }
}