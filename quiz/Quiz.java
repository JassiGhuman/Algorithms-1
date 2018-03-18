package quiz;

import java.sql.*;
import javax.swing.JOptionPane;

public class Quiz {
    
    public static Connection con;
    public static int loggedRegId;
    public static String loggedUserName;
    public static String loggedPassword;
    
    public static void main(String[] args) {
        
        try
        {
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con=DriverManager.getConnection("jdbc:odbc:QuizDSN","sa","Abhishek");
         
         
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        MainForm obj=new MainForm(null, true);
        obj.setVisible(true);
    }
    
}
