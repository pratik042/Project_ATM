   package phonepay;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class createac extends JFrame implements  ActionListener{
	
	
	JFrame j5;
	JButton b1;
	JLabel l1,l2,l3,l4;
	JPanel p;
	JTextField t1,t2,t3,t4,t5;
	Connection con;
	PreparedStatement p1,p2;
	  static int i1;
	int amt;
	int pin;
	int i4;
	int i5;
	int i6;
     public createac(int i1)
     {
    	  this.i1=i1;
	j5=new JFrame();
	  j5.setVisible(true);// visibility set true
	  j5.setSize(1500, 1000);// bounds of frame
	  j5.setTitle("create id page");// title 
	  j5.setLayout(null);
	   
	   l4=new JLabel();
	  // p=new JPanel();
	   //p.setLayout(null);
	   //p.setBounds(700, 200, 1000, 1000);
	   Font f=new Font("IMPACT",Font.BOLD,50);
	 
	   ImageIcon i=new ImageIcon("sunflower1.jpg");
	   l4.setBounds(0, 0,1500,1000);
	   l4.setIcon(i);
	   
	   
	
	   j5.add(l4);// adding label4 to frame
	   
	   t1=new JTextField();
	   t2=new JTextField();
	   t3=new JTextField();
	  t4=new JTextField();
	   t5=new JTextField();
	   
	   t1.setBounds(1000, 200, 200, 50);
	   t2.setBounds(1000, 400, 200, 50);
	   t3.setBounds(1000, 600, 200, 50);
	//   t4.setBounds(1000, 800, 200, 50);
	//   t5.setBounds(1000, 900, 200, 50);
	   
	   
	   l4.add(t1);
	   l4.add(t2);
	   l4.add(t3);
	   l4.add(t4);
	   l4.add(t5);
	   
	   
	   Font f1=new Font("IMPACT",Font.BOLD,30);
	   l1=new JLabel("USERNAME");
	   l2=new JLabel("PIN");
	   l3=new JLabel(" AMOUNT");
	   
	   l1.setForeground(Color.ORANGE);
	   l2.setForeground(Color.ORANGE);
	   l3.setForeground(Color.ORANGE);
	   
	   l1.setBackground(Color.BLUE);
	   l2.setBackground(Color.BLUE);
	   l3.setBackground(Color.BLUE);
	   
	   
	   l1.setFont(f1);
	   l2.setFont(f1); 
	   l3.setFont(f1); 
	   l1.setBounds(800, 200, 150, 50);
	   l2.setBounds(800, 400, 150, 50);
	   l3.setBounds(800, 600, 150, 50);
	   
	   b1=new JButton("submit");
	   b1.setBounds(50, 50, 500,50);
	   b1.setForeground(Color.blue);
	   b1.setFont(f);
	   l4.add(b1);	
	   
	   l4.add(l1);
	   l4.add(l2);
	   l4.add(l3);
	  
	   
	   b1.addActionListener(this);
	   }
  
 
    
      public void actionPerformed(ActionEvent e)
      {
		// TODO Auto-generated method stub
		
    	  String s=e.getActionCommand();
    	  if(s.equals("submit"))
    	  {
    		  try
  	        {
  	    	   
  			 Class.forName("com.mysql.cj.jdbc.Driver");
  			
  			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306 "+"/register","root","unicorn");
  			
  	         System.out.println("connection successful");
  	        
  	        
  	        
  	         p1=con.prepareStatement("insert into  list values (?,?,?)");
	     
  	       
  	         String s1=t1.getText();//for name
  	         p1.setString(1, s1);// putting name into column 1
  	         System.out.println(" name updated");
  	         
  	         String s2=t2.getText();//for pin
  	         int pin=Integer.parseInt(s2);
  	         p1.setInt(2, pin);
  	         System.out.println(" pin updated");
  	       
  	         String s3=t3.getText();//for amount
  	         int amt=Integer.parseInt(s3);
	         p1.setInt(3, amt);
  	         System.out.println(" amount updated");
  	         
  	       
  	         
  	         p1.execute();
  	          con.close();
  	         System.out.println(" connectin close");
  	         
  	      
  	        
  	    
  	       }
  	       catch (ClassNotFoundException | SQLException e1)
  	       {
  			e1.printStackTrace();
  		   }
  	    	   j5.dispose();
  	        	new START(i1); //open transaction page	
  	       }
    
    }
}

