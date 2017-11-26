package notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Notepad implements ActionListener{
	JFrame frame= new JFrame();
	JMenuBar mb=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenuItem newFile=new JMenuItem("New");
	JMenuItem openFile=new JMenuItem("Open");
	JTextArea textArea = new JTextArea();
	public Notepad() {
		newFile.addActionListener(this);
		frame.add(textArea);
		file.add(newFile);	
		file.add(openFile);
		mb.add(file);
		frame.setTitle("Notepad 2017");
		frame.setJMenuBar(mb);
		frame.setSize(1000, 500);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notepad nt = new Notepad();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(newFile)) {
			JOptionPane.showMessageDialog(null, "It works");
		}
	}
}
