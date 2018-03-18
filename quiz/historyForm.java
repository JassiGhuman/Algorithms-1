package quiz;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class historyForm extends javax.swing.JDialog {
    
    ArrayList<Integer> catID=new ArrayList<Integer>();
    int categoryID;
    DefaultTableModel dtm;
    boolean flag=false;
    int tID;  
    
    
    public void selectTest(int cat,int ctID)
    {
   
        int temp=catID.indexOf(cat);
        categoryComboBox.setSelectedIndex(temp);
        
        
        for(int i=0;i<testCountTable.getRowCount();i++)
        {
            if(Integer.parseInt(testCountTable.getValueAt(i,0).toString())==ctID)
            {
                testCountTable.setRowSelectionInterval(i, i);
                break;
            }
        }
        
        
     
        
    }
    
    public void update()
    {
        String[] headings={"Test ID","Attempted Questions","Correct Answers"};
        dtm=new DefaultTableModel(headings,0);
             
        int index=categoryComboBox.getSelectedIndex();
        categoryID=catID.get(index);
        try
        {
            Statement st=Quiz.con.createStatement();
            ResultSet rs=st.executeQuery("select AQ.ConductedTestID, COUNT(*)"
                    + " as [Attempted],(select COUNT(*) from attemptedQuestions "
                    + "as[A],options as[O] where A.conductedTestID="
                    + "AQ.ConductedTestID and A.optionID=O.optionid "
                    + "and o.isAnswer=1) as [Correct ]from attemptedQuestions"
                    + " as[AQ] where AQ.conductedTestID in "
                    + "(Select conductedTestID from conductedTests where "
                    + "categoryID="+categoryID+") group by AQ.conductedTestID");
            
            while(rs.next())
            {
                Object[] row=new Object[3];
                row[0]=rs.getInt("ConductedTestID");
                row[1]=rs.getInt("Attempted");
                row[2]=rs.getInt("Correct");
                
                dtm.addRow(row);
            }
            
            rs.close();
            st.close();
            testCountTable.setModel(dtm);
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
       
    }
    
    private void delete()
    {
        try
        {
            PreparedStatement ps=Quiz.con.prepareStatement("delete from "
                    + "attemptedQuestions where conductedTestID=?");
            
            int temp=testCountTable.getSelectedRow();
            tID=Integer.parseInt(testCountTable.getValueAt(temp,0).toString());
            
            ps.setInt(1, tID);
            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        }
        
        
        try
        {
            PreparedStatement ps1=Quiz.con.prepareStatement("delete from "
                    + "conductedTests where conductedTestID=?");
            ps1.setInt(1, tID);
            ps1.executeUpdate();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        }
    }

    public historyForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        String[] headings={"Test ID","Attempted Questions","Correct Answers"};
        dtm=new DefaultTableModel(headings,0);
        testCountTable.setModel(dtm);
        
        try
        {
            Statement st=Quiz.con.createStatement();
            ResultSet rs=st.executeQuery("select * from categories");
            
            while(rs.next())
            {
                catID.add(rs.getInt("CategoryID"));
                categoryComboBox.addItem(rs.getString("categoryName"));
            }
           
           
            rs.close();
            st.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,ex.getMessage());
        }
        flag=true;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        testCountTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        showButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        categoryComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        testCountTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        testCountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(testCountTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("    Category:");

        showButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445622757_circle_info_more-information_detail.png"))); // NOI18N
        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445621383_editor_trash_delete_recycle_bin_.png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showButton)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deleteButton, showButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed

     if(flag)
     {
         update();
        
     }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed

        int temp=testCountTable.getSelectedRow();
        if(temp>=0)
        {
            int value=Integer.parseInt
                    (testCountTable.getValueAt(temp,0).toString());
        
        
            /* DetailTestForm obj=new DetailTestForm(null, true);
             obj.showTable(value);
             obj.setVisible(true);
             */
            
            DetailTestFormNew obj=new DetailTestFormNew(null, true);
            obj.update1(value);
            obj.setVisible(true);
        
            
            
             
             
        
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_showButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        if(testCountTable.getSelectedRow()>=0)
        {
           int reply=JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to"
                   + " delete ?","Delete Record",JOptionPane.YES_NO_OPTION);
           
           if(reply==JOptionPane.YES_OPTION)
           {
               delete();
               update();
        
           }
                             
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton showButton;
    private javax.swing.JTable testCountTable;
    // End of variables declaration//GEN-END:variables
}
