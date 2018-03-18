package quiz;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class GameWindowForm extends javax.swing.JDialog {
    
    public ArrayList<Question> list=new ArrayList<>();
   // public ArrayList<Option> opt=new ArrayList<>();
    int index=0;
    int cat;
    int OID1,OID2,OID3,OID4;
    int conductID;
    
    
    public void start(int val)
    {
        
        cat=val;
        //int qID;
        try
        {
            Statement st=Quiz.con.createStatement();
            ResultSet rs=st.executeQuery("select top 10 * from questions "
                    + "where categoryid="+cat);
            
            String str="";
            
            while(rs.next())
            {
                Question q=new Question();
                q.questionID=rs.getInt("QuestionID");
                q.questionText=rs.getString("QuestionText").trim();
                
                list.add(q);
                str=str+q.questionID+",";
                
            }
            rs.close();
            st.close();
            str=str.substring(0,str.length()-1);
            
           Statement stmt=Quiz.con.createStatement();
            ResultSet rst=stmt.executeQuery("select * from options "
                    + "where questionid in("+str+")");
            
            int qID;
            while(rst.next())
            {
                Option op=new Option();
                op.optionID=rst.getInt("OptionID");
                op.optionText=rst.getString("OptionText");
                
                qID=rst.getInt("QuestionID");
                
                for(Question q:list)
                {
                    if(q.questionID==qID)
                    {
                        q.options.add(op);
                        break;
                    }
                }
                
            }
            rst.close();
            stmt.close();
            
            Question qs=list.get(index);
            quesTextArea.setText(qs.questionText);
            
                                   
            aOptionRadioButton.setText(qs.options.get(0).optionText);
            bOptionRadioButton.setText(qs.options.get(1).optionText);
            cOptionRadioButton.setText(qs.options.get(2).optionText);
            dOptionRadioButton.setText(qs.options.get(3).optionText);
            
            OID1=qs.options.get(0).optionID;
            OID2=qs.options.get(1).optionID;
            OID3=qs.options.get(2).optionID;
            OID4=qs.options.get(3).optionID;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    public GameWindowForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        aOptionRadioButton = new javax.swing.JRadioButton();
        bOptionRadioButton = new javax.swing.JRadioButton();
        cOptionRadioButton = new javax.swing.JRadioButton();
        dOptionRadioButton = new javax.swing.JRadioButton();
        nextButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        quesTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(434, 456));
        getContentPane().setLayout(null);

        buttonGroup1.add(aOptionRadioButton);
        aOptionRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        aOptionRadioButton.setText("jRadioButton1");
        aOptionRadioButton.setMaximumSize(new java.awt.Dimension(200, 29));
        aOptionRadioButton.setPreferredSize(new java.awt.Dimension(200, 29));
        getContentPane().add(aOptionRadioButton);
        aOptionRadioButton.setBounds(10, 153, 210, 29);

        buttonGroup1.add(bOptionRadioButton);
        bOptionRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bOptionRadioButton.setText("jRadioButton2");
        getContentPane().add(bOptionRadioButton);
        bOptionRadioButton.setBounds(10, 200, 210, 29);

        buttonGroup1.add(cOptionRadioButton);
        cOptionRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cOptionRadioButton.setText("jRadioButton3");
        getContentPane().add(cOptionRadioButton);
        cOptionRadioButton.setBounds(10, 247, 210, 29);

        buttonGroup1.add(dOptionRadioButton);
        dOptionRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dOptionRadioButton.setText("jRadioButton4");
        getContentPane().add(dOptionRadioButton);
        dOptionRadioButton.setBounds(10, 294, 210, 29);

        nextButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445622896_circle_next_arrow_disclosure.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.setBorder(null);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton);
        nextButton.setBounds(271, 325, 125, 79);

        quesTextArea.setEditable(false);
        quesTextArea.setBackground(new java.awt.Color(204, 204, 204));
        quesTextArea.setColumns(20);
        quesTextArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quesTextArea.setLineWrap(true);
        quesTextArea.setRows(5);
        quesTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(quesTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 29, 396, 106);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/patterns_abstract_circles_lines_stripes_psychedelic_800x600.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 410, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        int selectedOptionID=-1;
        if(aOptionRadioButton.isSelected())
            selectedOptionID=OID1;
        if(bOptionRadioButton.isSelected())
            selectedOptionID=OID2;
        if(cOptionRadioButton.isSelected())
            selectedOptionID=OID3;
        if(dOptionRadioButton.isSelected())
            selectedOptionID=OID4;
        
        buttonGroup1.clearSelection();
        
        if(selectedOptionID>=0)
        {
            Question q=list.get(index);
            q.selectedOptionID=selectedOptionID;
        }
        
        index++;
        if(index==9)
        {
            
        }
       if(index<10)
       {
           Question qs=list.get(index);
            quesTextArea.setText(qs.questionText);
            
                                   
            aOptionRadioButton.setText(qs.options.get(0).optionText);
            bOptionRadioButton.setText(qs.options.get(1).optionText);
            cOptionRadioButton.setText(qs.options.get(2).optionText);
            dOptionRadioButton.setText(qs.options.get(3).optionText);
            
            OID1=qs.options.get(0).optionID;
            OID2=qs.options.get(1).optionID;
            OID3=qs.options.get(2).optionID;
            OID4=qs.options.get(3).optionID;
       }
       else
       {
           try
           {
               CallableStatement cs= Quiz.con.prepareCall("{call sp_addaTable(?,?,?)}");
               cs.registerOutParameter(1,java.sql.Types.INTEGER);
               cs.setInt(2, cat);
               cs.setInt(3,Quiz.loggedRegId);
               
               cs.executeUpdate();
               
               
                
               conductID=cs.getInt(1);
               cs.close();
               for(Question q :list )
               {
                   if(q.selectedOptionID>0)
                   {
                       
                       PreparedStatement ps1=Quiz.con.prepareStatement("insert into"
                           + " attemptedquestions values(?,?,?)");
                   ps1.setInt(1,q.questionID);
                   ps1.setInt(2,q.selectedOptionID);
                   ps1.setInt(3,conductID);
                   
                   ps1.executeUpdate();
                   ps1.close();
                   
                   }
                   
               }
               
               this.dispose();
               briefHistory obj=new briefHistory(null,true);
               obj.result(conductID);
               obj.calc();
               obj.setVisible(true);
               
               
               
              //historyForm obj=new historyForm(null, true);
              //obj.selectTest(cat,conductID);
              //obj.setVisible(true);
               
           }
           catch(Exception ex)
           {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage());
           }
       }
    }//GEN-LAST:event_nextButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aOptionRadioButton;
    private javax.swing.JRadioButton bOptionRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cOptionRadioButton;
    private javax.swing.JRadioButton dOptionRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextArea quesTextArea;
    // End of variables declaration//GEN-END:variables
}
