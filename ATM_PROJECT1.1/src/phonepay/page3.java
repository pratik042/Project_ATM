package phonepay;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class page3 extends JFrame implements ActionListener {

	JFrame j3;
	JLabel l3;
	JButton b1,b2,b3,b4;
	int i1;
	public page3(int i1)
	 {Font f=new Font("impact",Font.BOLD,20); 
		
		this.i1=i1;
		j3=new JFrame();
        j3.setVisible(true); //now frame should be visible so we should make it visible
        j3.setSize(1500, 1000); // now letsset frame size
        j3.setLayout(null);// this shd be set null
        j3.setTitle("transaction page");// title 
	  
	
     
		l3=new JLabel(); //when button is clicked this or here will change into recharge
	
		ImageIcon  i= new ImageIcon("sunflower1.jpg");
	    l3.setIcon(i);
        
	    b1=new JButton("UPDATE AC");
        b2=new JButton("WITHDRAW");
        b3=new JButton("CHECK BALANCE");
        b4=new JButton("STATEMENT");
          
		l3.setBounds(0, 0, 1500,1000);
	    
	    b1.setBounds(1000, 200,150,50);
	    b2.setBounds(1000,400, 150,50);
	    b3.setBounds(1000,600, 150,50);
		b4.setBounds(1000,800, 150,50);
	
        l3.add(b1);// button added on label
	    l3.add(b2);// button added on label
	    l3.add(b3);// button added on label
	    l3.add(b4);// button added on label
	    
	  
       
     
       // l2.setBackground(Color.blue);
		b1.setBackground(Color.BLUE);
		b2.setBackground(Color.BLUE);
		b3.setBackground(Color.BLUE);
		b4.setBackground(Color.BLUE);
	
	    
	    b1.setForeground(Color.orange);
	    b2.setForeground(Color.orange);
	    b3.setForeground(Color.orange);
	    b4.setForeground(Color.orange);

        b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    
	    j3.add(l3);
	 }
	
	
	  public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  String s=e.getActionCommand();		  
		  if(s.equals("UPDATE AC"))
		    {
		    	j3.dispose();
		    	//new page5();
		    	
		    }
		  else if(s.equals("WITHDRAW"))
		    {
		    	j3.dispose();
		    	new page5(i1);	
		    }
		  else if(s.equals("CHECK BALANCE"))
		    {
		    	j3.dispose();
		    	new page7(i1);	
		    }
		  else if(s.equals("STATEMENT"))
		    {
		    	j3.dispose();
		    	//new page2();	
		    }
	  }
}
