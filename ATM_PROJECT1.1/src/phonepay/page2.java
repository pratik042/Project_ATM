package phonepay;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class page2 extends JFrame implements ActionListener {

	JFrame j2;
	JLabel l2,l3;
    JButton b2,b3;
	int i1;
	public page2(int i1)
	{ Font f=new Font("impact",Font.BOLD,30); 
		
		this.i1=i1;
		j2=new JFrame();
        j2.setVisible(true); //now frame should be visible so we should make it visible
        j2.setSize(1500, 1000); // now letsset frame size
        j2.setLayout(null);// this shd be set null
        j2.setTitle("language page");// title 
	  
  	 
        
		l2=new JLabel(); //when button is clicked this or here will change into recharge
		l3=new JLabel(" select language");
		ImageIcon  i= new ImageIcon("sunflower1.jpg");
	    l2.setIcon(i);
        
	    l3.setFont(f);
	    l3.setForeground(Color.orange);
	   // l2.setForeground(Color.orange);
	    
	    
	    b2=new JButton("MARATHI");
        b3=new JButton("ENGLISH");
	    
		l2.setBounds(0, 0, 1500,1000);
		l3.setBounds(100, 0, 350,200);
	    b2.setBounds(600, 400, 100,100);
		b3.setBounds(600,600, 100,100);
	
        l2.add(b3);// button added on label
	    l2.add(b2);// button added on label
	    j2.add(l2);//label added on frame
        l2.add(l3);
        
        l2.setBackground(Color.blue);
		b3.setBackground(Color.BLUE);
	    b2.setBackground(Color.BLUE);
	    
	    b2.setForeground(Color.orange);
	    b3.setForeground(Color.orange);
	

        b2.addActionListener(this);
	    b3.addActionListener(this);


	}
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		if(s.equals("ENGLISH"))
	    {
	    	j2.dispose();
	    	new page3(i1);
	    	
	    }
	    if(s.equals("MARATHI"))
	    {
	    	j2.dispose();
	    	new page3(i1);	
	    }
	}
}


