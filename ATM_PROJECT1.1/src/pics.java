import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class pics extends JFrame implements ActionListener{
	JFrame j1;
	public  pics()
	{
	     ImageIcon  i= new ImageIcon("nature.jpg");

		 j1=new JFrame();
		 j1.setLayout(null);
		 j1.setSize(800, 800);
		
		
		 j1.setVisible(true);
		
	     j1.setTitle("nature.jpg");
		
	     JLabel l1=new JLabel();
	     
	     l1.setBounds(100,100, 100,100);
	     
	     l1.setIcon(i);
	     j1.add(l1);
	  }
	
	
	
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
pics p=new pics();

	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
