package quiz;

public class GatewayForm extends javax.swing.JDialog {

    public GatewayForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        nameLabel.setText(Quiz.loggedUserName);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        aptitudeButton = new javax.swing.JButton();
        sportsButton = new javax.swing.JButton();
        generalKnowledgeButton = new javax.swing.JButton();
        mathsButton = new javax.swing.JButton();
        programmingButton = new javax.swing.JButton();
        moviesButton = new javax.swing.JButton();
        changePassButton = new javax.swing.JButton();
        historyButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(640, 470));
        setMinimumSize(new java.awt.Dimension(640, 470));
        setPreferredSize(new java.awt.Dimension(690, 470));
        getContentPane().setLayout(null);

        welcomeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        welcomeLabel.setText("Welcome ");
        getContentPane().add(welcomeLabel);
        welcomeLabel.setBounds(158, 21, 60, 20);

        aptitudeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        aptitudeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445632966_money.png"))); // NOI18N
        aptitudeButton.setText("Aptitude");
        aptitudeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aptitudeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(aptitudeButton);
        aptitudeButton.setBounds(23, 192, 185, 73);

        sportsButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sportsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445632883_football.png"))); // NOI18N
        sportsButton.setText("Sports");
        sportsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sportsButton);
        sportsButton.setBounds(232, 192, 185, 73);

        generalKnowledgeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        generalKnowledgeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445634263_globe.png"))); // NOI18N
        generalKnowledgeButton.setText("GK");
        generalKnowledgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalKnowledgeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(generalKnowledgeButton);
        generalKnowledgeButton.setBounds(443, 192, 185, 73);

        mathsButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mathsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445634440_09.png"))); // NOI18N
        mathsButton.setText("Maths");
        mathsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mathsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mathsButton);
        mathsButton.setBounds(23, 319, 185, 73);

        programmingButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programmingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445632524_02.png"))); // NOI18N
        programmingButton.setText("Programming");
        programmingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmingButtonActionPerformed(evt);
            }
        });
        getContentPane().add(programmingButton);
        programmingButton.setBounds(232, 319, 185, 73);

        moviesButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        moviesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445624919_device_camera_recorder_video.png"))); // NOI18N
        moviesButton.setText("Movies");
        moviesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moviesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(moviesButton);
        moviesButton.setBounds(435, 319, 185, 73);

        changePassButton.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        changePassButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445670387_key.png"))); // NOI18N
        changePassButton.setText("Change Password");
        changePassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassButtonActionPerformed(evt);
            }
        });
        getContentPane().add(changePassButton);
        changePassButton.setBounds(443, 11, 147, 47);

        historyButton.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        historyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445638793_clock.png"))); // NOI18N
        historyButton.setText("History");
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(historyButton);
        historyButton.setBounds(443, 64, 147, 47);

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("nameLabel");
        getContentPane().add(nameLabel);
        nameLabel.setBounds(77, 59, 260, 25);

        logOutButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/1445670446_on-off.png"))); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logOutButton);
        logOutButton.setBounds(443, 122, 147, 41);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/media/light-bulb-powerpoint-templates (2).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 640, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changePassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassButtonActionPerformed

        changePasswordForm obj=new changePasswordForm(null, true);
        this.setVisible(false);
        obj.setVisible(true);
        this.setVisible(true);
        
    }//GEN-LAST:event_changePassButtonActionPerformed

    private void moviesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moviesButtonActionPerformed

        
        GameWindowForm obj=new GameWindowForm(null, true);
        obj.start(6);
        this.setVisible(false);
        obj.setVisible(true);
        this.setVisible(true);
        
        
    }//GEN-LAST:event_moviesButtonActionPerformed

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyButtonActionPerformed

        historyForm obj=new historyForm(null, true);
        obj.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_historyButtonActionPerformed

    private void aptitudeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aptitudeButtonActionPerformed

        GameWindowForm obj=new GameWindowForm(null, true);
        obj.start(1);
        this.setVisible(false);
        obj.setVisible(true);
        this.setVisible(true);
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_aptitudeButtonActionPerformed

    private void sportsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsButtonActionPerformed

        
        GameWindowForm obj=new GameWindowForm(null, true);
        obj.start(2);
        this.setVisible(false);
        obj.setVisible(true);
        this.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_sportsButtonActionPerformed

    private void generalKnowledgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalKnowledgeButtonActionPerformed

        GameWindowForm obj=new GameWindowForm(null, true);
        obj.start(3);
        this.setVisible(false);
        obj.setVisible(true);
        this.setVisible(true);
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_generalKnowledgeButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed

        Quiz.loggedPassword=null;
        Quiz.loggedRegId=0;
        Quiz.loggedUserName=null;
        this.dispose();
        MainForm obj=new MainForm(null, true);
        obj.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void mathsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mathsButtonActionPerformed

        GameWindowForm obj=new GameWindowForm(null, true);
        obj.start(4);
        this.setVisible(false);
        obj.setVisible(true);
        this.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_mathsButtonActionPerformed

    private void programmingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmingButtonActionPerformed

        GameWindowForm obj=new GameWindowForm(null, true);
        obj.start(5);
        this.setVisible(false);
        obj.setVisible(true);
        this.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_programmingButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aptitudeButton;
    private javax.swing.JButton changePassButton;
    private javax.swing.JButton generalKnowledgeButton;
    private javax.swing.JButton historyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton mathsButton;
    private javax.swing.JButton moviesButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton programmingButton;
    private javax.swing.JButton sportsButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
