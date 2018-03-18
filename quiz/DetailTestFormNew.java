package quiz;
import java.awt.Color;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;


public class DetailTestFormNew extends javax.swing.JDialog {
    
    public ArrayList<String> questions=new ArrayList<>();
    public ArrayList<String> oCorrect=new ArrayList<>();
    public ArrayList<String> oSelected=new ArrayList<>();
    public ArrayList<String> qExplain=new ArrayList<>();
    int index=0;
    
    public void update1(int tID)
    {
        String ID=String.valueOf(tID);
        try
        {
            Statement st=Quiz.con.createStatement();
            ResultSet rs=st.executeQuery("select q.questiontext,o.optiontext as"
                    + " [attempted],q.explanation from Questions as [q],options"
                    + " as [o],attemptedQuestions as [aq] where "
                    + "q.questionID=aq.questionID and o.optionid=aq.optionID "
                    + "and aq.conductedTestID="+ID);
            while(rs.next())
            {
                questions.add(rs.getString("questiontext").trim());
                oSelected.add(rs.getString("attempted").trim());
                qExplain.add(rs.getString("explanation").trim());
                
               // rs.close();
               // st.close();
            
                
            }
            
            
            
        }
        
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        
        update2(ID);
    }
    
    public void update2(String testID)
    {
       try
       {
           Statement st1= Quiz.con.createStatement();
           ResultSet rs1=st1.executeQuery("select o.optiontext from options"
                   + " as[o], attemptedQuestions as[aq] where"
                   + " o.questionID=aq.questionID and o.isAnswer=1 "
                   + "and aq.conductedTestID="+testID);
           
           while(rs1.next())
           {
               oCorrect.add(rs1.getString("optiontext").trim());
           }
           
           
          // rs1.close();
          // st1.close();
       }
       
       
       
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(rootPane, ex.getMessage());
       }
       
       screen();
    }
    
    public void screen()
    {
        questionTextArea.setText(questions.get(index));
        attemptedTextField.setText(oSelected.get(index));
        correctTextField.setText(oCorrect.get(index));
        explainTextArea.setText(qExplain.get(index));
        
        if(attemptedTextField.getText().equals(correctTextField.getText()))
        {
            attemptedTextField.setForeground(Color.green);
        }
        else
        {
            attemptedTextField.setForeground(Color.red);
        }
        
    }
    public DetailTestFormNew(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        questionTextArea = new javax.swing.JTextArea();
        attemptedLabel = new javax.swing.JLabel();
        correctLabel = new javax.swing.JLabel();
        attemptedTextField = new javax.swing.JTextField();
        correctTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        explainTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        explainLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(456, 611));
        getContentPane().setLayout(null);

        questionTextArea.setEditable(false);
        questionTextArea.setColumns(20);
        questionTextArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        questionTextArea.setLineWrap(true);
        questionTextArea.setRows(5);
        questionTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(questionTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 37, 434, 106);

        attemptedLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attemptedLabel.setText("Attempted Option:");
        getContentPane().add(attemptedLabel);
        attemptedLabel.setBounds(75, 179, 116, 20);

        correctLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        correctLabel.setText("Correct Option:");
        getContentPane().add(correctLabel);
        correctLabel.setBounds(96, 223, 95, 20);

        attemptedTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attemptedTextField.setText("jTextField1");
        getContentPane().add(attemptedTextField);
        attemptedTextField.setBounds(226, 176, 138, 26);

        correctTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        correctTextField.setText("jTextField2");
        getContentPane().add(correctTextField);
        correctTextField.setBounds(226, 220, 138, 26);

        explainTextArea.setEditable(false);
        explainTextArea.setColumns(20);
        explainTextArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        explainTextArea.setLineWrap(true);
        explainTextArea.setRows(5);
        explainTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(explainTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 290, 444, 106);

        backButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445622975_circle_back_arrow.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(47, 417, 150, 73);

        nextButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/1445622896_circle_next_arrow_disclosure.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton);
        nextButton.setBounds(252, 417, 150, 73);

        explainLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        explainLabel.setText("Explanation:");
        getContentPane().add(explainLabel);
        explainLabel.setBounds(0, 264, 82, 20);

        questionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        questionLabel.setText("Question:");
        getContentPane().add(questionLabel);
        questionLabel.setBounds(10, 11, 59, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/world-map-science-concept-abstract-white-background-eps-vector-54116095.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 460, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        index--;
        screen();
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        index++;
        screen();
        // TODO add your handling code here:
    }//GEN-LAST:event_nextButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attemptedLabel;
    private javax.swing.JTextField attemptedTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel correctLabel;
    private javax.swing.JTextField correctTextField;
    private javax.swing.JLabel explainLabel;
    private javax.swing.JTextArea explainTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JTextArea questionTextArea;
    // End of variables declaration//GEN-END:variables
}
