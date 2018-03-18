package quiz;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;


public class briefHistory extends javax.swing.JDialog {
    
   int attempted,correct; 
   int testIDValue;

    public briefHistory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    
    public void result(int tID)
    {
        testIDValue=tID;
        String testID=String.valueOf(tID);
        try
        {
            Statement st=Quiz.con.createStatement();
            ResultSet rs=st.executeQuery("select AQ.ConductedTestID, COUNT(*) as"
                    + " [Attempted],(select COUNT(*) from attemptedQuestions "
                    + "as[A],options as[O] where A.conductedTestID= "
                    + "AQ.ConductedTestID and A.optionID=O.optionid "
                    + "and o.isAnswer=1) as [Correct ]from attemptedQuestions"
                    + " as[AQ] where AQ.conductedTestID in ("+testID+") "
                    + "group by AQ.conductedTestID");
            
            rs.next();
            attempted=rs.getInt("Attempted");
            correct=rs.getInt("Correct");
            
            rs.close();
            st.close();
            
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        
        
    }

    public void calc()
    {
        attemptedJTextField.setText(String.valueOf(attempted));
        correctJTextField.setText(String.valueOf(correct));
        incorrectJTextField.setText(String.valueOf(attempted-correct));
        float perc=correct*100/attempted;
        if(perc<50){
            percentageJTextField.setForeground(Color.red);
        }
        percentageJTextField.setText(String.valueOf(perc));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        attemptedJLabel = new javax.swing.JLabel();
        correctJLabel = new javax.swing.JLabel();
        percentJLabel = new javax.swing.JLabel();
        attemptedJTextField = new javax.swing.JTextField();
        correctJTextField = new javax.swing.JTextField();
        percentageJTextField = new javax.swing.JTextField();
        incorrectJLabel = new javax.swing.JLabel();
        incorrectJTextField = new javax.swing.JTextField();
        detailsjButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(330, 300));
        setPreferredSize(new java.awt.Dimension(330, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        attemptedJLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attemptedJLabel.setText("Attempted:");
        getContentPane().add(attemptedJLabel);
        attemptedJLabel.setBounds(69, 48, 69, 20);

        correctJLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        correctJLabel.setText("Correct:");
        getContentPane().add(correctJLabel);
        correctJLabel.setBounds(90, 79, 48, 20);

        percentJLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        percentJLabel.setText("Percentage:");
        getContentPane().add(percentJLabel);
        percentJLabel.setBounds(69, 141, 71, 20);

        attemptedJTextField.setEditable(false);
        attemptedJTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attemptedJTextField.setBorder(null);
        getContentPane().add(attemptedJTextField);
        attemptedJTextField.setBounds(174, 48, 70, 20);

        correctJTextField.setEditable(false);
        correctJTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        correctJTextField.setForeground(new java.awt.Color(51, 153, 0));
        correctJTextField.setBorder(null);
        correctJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correctJTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(correctJTextField);
        correctJTextField.setBounds(174, 79, 70, 20);

        percentageJTextField.setEditable(false);
        percentageJTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        percentageJTextField.setForeground(new java.awt.Color(51, 255, 51));
        percentageJTextField.setBorder(null);
        getContentPane().add(percentageJTextField);
        percentageJTextField.setBounds(174, 141, 70, 20);

        incorrectJLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        incorrectJLabel.setText("Incorrect:");
        getContentPane().add(incorrectJLabel);
        incorrectJLabel.setBounds(81, 110, 57, 20);

        incorrectJTextField.setEditable(false);
        incorrectJTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        incorrectJTextField.setForeground(new java.awt.Color(204, 0, 0));
        incorrectJTextField.setBorder(null);
        getContentPane().add(incorrectJTextField);
        incorrectJTextField.setBounds(174, 110, 70, 20);

        detailsjButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        detailsjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445621006_common_bookmark_book_open.png"))); // NOI18N
        detailsjButton.setText("Details");
        detailsjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsjButtonActionPerformed(evt);
            }
        });
        getContentPane().add(detailsjButton);
        detailsjButton.setBounds(10, 191, 125, 49);

        exitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445620794_common_logout_signout_exit_.png"))); // NOI18N
        exitButton.setText("Exit");
        getContentPane().add(exitButton);
        exitButton.setBounds(164, 191, 125, 49);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/cutcaster-photo-800948892-Gray-abstract-background.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 310, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void correctJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correctJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correctJTextFieldActionPerformed

    private void detailsjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsjButtonActionPerformed

        DetailTestFormNew obj=new DetailTestFormNew(null, true);
        obj.update1(testIDValue);
        obj.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsjButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(briefHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(briefHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(briefHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(briefHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                briefHistory dialog = new briefHistory(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attemptedJLabel;
    private javax.swing.JTextField attemptedJTextField;
    private javax.swing.JLabel correctJLabel;
    private javax.swing.JTextField correctJTextField;
    private javax.swing.JButton detailsjButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel incorrectJLabel;
    private javax.swing.JTextField incorrectJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel percentJLabel;
    private javax.swing.JTextField percentageJTextField;
    // End of variables declaration//GEN-END:variables
}
