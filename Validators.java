import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Validators {
    public void showErrorMsgDialog(String message, String title) {
        JOptionPane.showMessageDialog(new JDialog(), message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public boolean rollNumberValidator(String strRollNumber) {
        boolean isRollNumber = false;
        if (!strRollNumber.equals("")) {
            try {
                int rollNumber = Integer.parseInt(strRollNumber);
                if (rollNumber > 0) {
                    isRollNumber = true;
                } else {
                    showErrorMsgDialog("Roll Number should be a positive and non-zero integer.", "Invalid Roll Number");
                }
            } catch(NumberFormatException nfe) {
                showErrorMsgDialog("Roll Number should consist of positive and non-zero integers only.", "Invalid Roll Number");
            }
        } else {
            showErrorMsgDialog("Roll Number should not be kept empty.", "Invalid Roll Number");
        }
        return isRollNumber;
    }

    public boolean nameValidator(String name) {
        boolean isName = false;
        if (!name.equals("")) {
            if ((name.length() >=2) && (name.length() <=25)) {
                Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
                Matcher matcher = pattern.matcher(name);
                if (matcher.find()) {
                    isName = true;
                } else {
                    showErrorMsgDialog("Name should consist of only alphabets.", "Invalid Name");
                }
            } else {
                showErrorMsgDialog("Minimum length of name should be 2 characters and maximum length is 25 characters.", "Invalid name");
            }
        } else {
            showErrorMsgDialog("Name should not be kept empty.", "Invalid Name");
        }
        return isName;
    } 

    public boolean marksValidator(String strMarks, String subjectName) {
        boolean isMarks = false;
        if (!strMarks.equals("")) {
            try {
                int marks = Integer.parseInt(strMarks);
                if ((marks >=0) && (marks <=100))
                {
                    isMarks = true;
                } else {
                    showErrorMsgDialog(subjectName + " marks should consist of integers only and must be in the range of 0-100.", "Invalid " + subjectName + " marks");
                }
            } catch(NumberFormatException nfe) {
                showErrorMsgDialog(subjectName + " marks should consist of integers only and must be in the range of 0-100.", "Invalid " + subjectName + " marks");
            }
        } else {
            showErrorMsgDialog(subjectName + " marks should not be kept empty.", "Invalid " + subjectName + " marks");
        }
        return isMarks;
    }
}