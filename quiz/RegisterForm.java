package Quizzer.src.quiz;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class RegisterForm extends javax.swing.JDialog {

    public RegisterForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    
    public boolean validateData()
    {
        if(nameTextField.getText().length()==0)
        {
            JOptionPane.showMessageDialog(rootPane,"Name is empty !!!");
            return false;
        }
        if(userIDTextField.getText().length()==0)
        {
            JOptionPane.showMessageDialog(rootPane,"User ID is Empty !!!");
            return false;
        }
        
        //User ID already EXists
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:QuizDSN",
                    "sa","Abhishek");
            
            ArrayList<String> uids=new ArrayList<>();
            int len=0;
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from registrations");
            
            while(rs.next())
            {
                uids.add(rs.getString("userID").trim());
                len++;
            }
            
            String givenid=userIDTextField.getText();
        
            for(int i=0;i<len;i++)
            {
                if(givenid.equals(uids.get(i)))
                {
                    JOptionPane.showMessageDialog(rootPane,"User ID already "
                            + "Exits");
                    return false;
                }
            }
        
                   
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        
        
        
        
        if(passPasswordField.getPassword().length<8)
        {
            JOptionPane.showMessageDialog(rootPane,"Password must be "
                    + "minimum eight characters !!!");
            return false;
        }
        
        //For Confirm Passwords
        String pwd=passPasswordField.getText();
        String cpwd=confirmPasswordField.getText();
        if(pwd.equals(cpwd)==false)
        {
            JOptionPane.showMessageDialog(rootPane,"Passwords Do Not Match !!!");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        userIDTextField = new javax.swing.JTextField();
        passPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        registerButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(377, 410));
        setPreferredSize(new java.awt.Dimension(377, 410));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Name:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(26, 34, 39, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("User ID:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(26, 78, 49, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(26, 122, 61, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Confirm Password:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(26, 166, 114, 20);

        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(nameTextField);
        nameTextField.setBounds(170, 31, 176, 26);

        userIDTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(userIDTextField);
        userIDTextField.setBounds(170, 75, 176, 26);

        passPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(passPasswordField);
        passPasswordField.setBounds(170, 119, 176, 26);

        confirmPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(confirmPasswordField);
        confirmPasswordField.setBounds(170, 163, 176, 26);

        registerButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445620285_add_group.png"))); // NOI18N
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(registerButton);
        registerButton.setBounds(10, 255, 160, 73);

        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445620377_close.png"))); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);
        cancelButton.setBounds(220, 255, 160, 73);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/Capture.PNG"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(377, 410));
        jLabel6.setMinimumSize(new java.awt.Dimension(377, 410));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 410, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed

        if(validateData())
        {
          
             
            try
            {
                PreparedStatement ps=Quiz.con.prepareStatement("insert into "
                        + "registrations values(?,?,?,?)");

                //Adding To Table
                ps.setString(1,userIDTextField.getText());
                ps.setString(2,passPasswordField.getText());
                ps.setString(3,nameTextField.getText());
                ps.setString(4,"");


                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(rootPane, ""
                        + "Registration Successful..");

                userIDTextField.setText(null);
                nameTextField.setText(null);       // Making all Fields blank again
                passPasswordField.setText(null);
                confirmPasswordField.setText(null);



             }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
        
        
    }//GEN-LAST:event_registerButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed

        this.dispose();
        
    }//GEN-LAST:event_cancelButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPasswordField passPasswordField;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField userIDTextField;
    // End of variables declaration//GEN-END:variables
}
