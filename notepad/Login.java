package notepad;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login extends JFrame implements ActionListener{
	JButton Submit;
	JPanel panel;
	JLabel l1,l2;
	final JTextField txt1,txt2;
	public Login(){
		l1=new JLabel();
		l1.setText("Username :");
		txt1 = new JTextField(15);

		l2 = new  JLabel();
		l2.setText("Password :");
		txt2 = new JPasswordField(15); 
		
		Submit = new JButton("Submit");	
	
		
	    Submit.addActionListener(this);
        setTitle("LOGIN FORM");

        panel=new JPanel();
        panel.add(l1);
rating         panel.add(txt1);
        panel.add(l2);
        panel.add(txt2);
        panel.add(Submit);
        add(panel,BorderLayout.CENTER);

	}
	
	public void actionPerformed(ActionEvent ae) {
		String a=txt1.getText();
		String b=txt2.getText();
		if(a.equals("shubham") && b.equals("123")) {
			JOptionPane.showMessageDialog(null, "Login Successfull!!!");
		}
		else
			JOptionPane.showMessageDialog(null, "Incorrect login Id");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login frame=new Login();
		frame.setVisible(true);
		frame.setSize(600, 300);
	}

}
