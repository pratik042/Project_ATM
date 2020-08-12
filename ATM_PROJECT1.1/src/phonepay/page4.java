package phonepay;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class page4 extends JFrame implements ActionListener  {

	JFrame j4;
	JLabel l4;
	JButton b1,b2,b3;
	int i1;
	public page4(int i1)
	 {Font f=new Font("impact",Font.BOLD,20); 
		 this.i1=i1;
		
		j4=new JFrame();
        j4.setVisible(true); //now frame should be visible so we should make it visible
        j4.setSize(1500, 1000); // now letsset frame size
        j4.setLayout(null);// this shd be set null
        j4.setTitle("transaction page");// title 
	  
	
     
		l4=new JLabel(); //when button is clicked this or here will change into recharge
	
		ImageIcon  i= new ImageIcon("sunflower1.jpg");
	    l4.setIcon(i);
        
	    b1=new JButton("CURRENT AC");
        b2=new JButton("SAVING AC");
        b3=new JButton("CREDIT");
     
        
		l4.setBounds(0, 0, 1500,1000);
	    
	    b1.setBounds(1000, 200,150,50);
	    b2.setBounds(1000,400, 150,50);
	    b3.setBounds(1000,600, 150,50);
		
	
        l4.add(b1);// button added on label
	    l4.add(b2);// button added on label
	    l4.add(b3);// button added on label
	  
	    
	    // l2.setBackground(Color.blue);
		b1.setBackground(Color.BLUE);
		b2.setBackground(Color.BLUE);
		b3.setBackground(Color.BLUE);
		
	
	    
	    b1.setForeground(Color.orange);
	    b2.setForeground(Color.orange);
	    b3.setForeground(Color.orange);
	

        b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	
	    
	    j4.add(l4);
	 }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();

		if(s.equals("CURRENT AC"))
	    {
	    	j4.dispose();
	    	new page5(i1);
	    	
	    }
		else if(s.equals("SAVING AC"))
	    {
	    	j4.dispose();
	    	new page5(i1);	
	    }
		else if(s.equals("CREDIT"))
	    {
	    	j4.dispose();
	    	new page5(i1);	
	    }
	}
}
