import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class grid extends JFrame implements ActionListener{
	JPanel p1;
	Container c;
	public grid()
	{
		JFrame j1=new JFrame();
		j1.setSize(2000, 1000);
		j1.setVisible(true);
		j1.setTitle("adding label");
		
		c=this.getContentPane();
		c.setLayout(new BorderLayout());
		
		
		
		
		
	    p1=new JPanel();
		j1.add(p1);
		p1.setBounds(100,100, 500, 500);
	    //p1.setName("panel")
		
		p1.setLayout(new GridLayout());
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      grid m =new grid();


		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
