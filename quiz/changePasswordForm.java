package quiz;

import javax.swing.JOptionPane;
import java.sql.*;

public class changePasswordForm extends javax.swing.JDialog {
    
    public boolean validateData()
    {
        if(currentPassPasswordField.getText().equals(Quiz.loggedPassword)
                ==false)
        {
            JOptionPane.showMessageDialog(rootPane,"Wrong Password !!!",""
                    + "Change Password",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(newPassPasswordField.getText().length()<8)
        {
            JOptionPane.showMessageDialog(rootPane,"Password must be Atleast "
                    + "Eight Characters Long !!!");
            return false;
        }
        if(confirmPasswordField.getText().equals(newPassPasswordField.getText())
                ==false)
        {
            JOptionPane.showMessageDialog(rootPane,""
                    + "Password and Confirm Passwords do not Match !!!",""
                    + "Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
      
        
        return true;
    }

    public changePasswordForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        currentPassPasswordField = new javax.swing.JPasswordField();
        newPassPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        changePasswordButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(435, 314));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Current Password:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(36, 42, 112, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("New Password:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(56, 95, 92, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Confirm Password:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(34, 146, 114, 20);

        currentPassPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        currentPassPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentPassPasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(currentPassPasswordField);
        currentPassPasswordField.setBounds(166, 39, 157, 26);

        newPassPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(newPassPasswordField);
        newPassPasswordField.setBounds(166, 92, 157, 26);

        confirmPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(confirmPasswordField);
        confirmPasswordField.setBounds(166, 143, 157, 26);

        changePasswordButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        changePasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445621140_basics-21.png"))); // NOI18N
        changePasswordButton.setText("Change Password");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });
        getContentPane().add(changePasswordButton);
        changePasswordButton.setBounds(10, 213, 193, 57);

        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445621232_basics-22.png"))); // NOI18N
        cancelButton.setText("Cancel");
        getContentPane().add(cancelButton);
        cancelButton.setBounds(221, 213, 193, 57);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp1\\Desktop\\portfolio_slidemaster.jpg")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 440, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void currentPassPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentPassPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentPassPasswordFieldActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed

        if(validateData())
        {
            try
            {
                PreparedStatement ps=Quiz.con.prepareStatement("update"
                        + " registrations"
                        + " set password=? where registrationid=?");
                ps.setString(1,newPassPasswordField.getText());
                ps.setInt(2,Quiz.loggedRegId);
                ps.executeUpdate();
                
                ps.close();
                
                Quiz.loggedPassword=newPassPasswordField.getText();
                
                JOptionPane.showMessageDialog(rootPane,"Password Changed "
                        + "Successfully ");
                
                this.dispose();
            }
            catch(Exception ex)
            {

                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
        
        
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JPasswordField currentPassPasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField newPassPasswordField;
    // End of variables declaration//GEN-END:variables
}
