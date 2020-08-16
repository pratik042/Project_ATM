  package phonepay;


import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class START  extends JFrame implements ActionListener
{
	  JFrame j0;
	 JLabel l1,l2,l3,l4;
	 Button b0,b1;
	 JTextField t1,t2;
		Connection con;
		  PreparedStatement ps1;
		  ResultSet rs;
		  static int i1,i2,c=0;
		  
	 
      public START(int i1)
	 {
    	  this.i1=i1;
    	   j0=new JFrame();
    	  j0.setVisible(true);// visibility set true
    	  j0.setSize(2000, 1000);// bounds of frame
    	  j0.setTitle("create id page");// title 
    	  j0.setLayout(null);
    	 
    	  Font f=new Font("IMPACT",Font.BOLD,20);
    	  Font f1=new Font("IMPACT",Font.BOLD,50);
    	  // now we need  to print
    	   l1= new JLabel();
    	//  l1.setName(" Welcome to SBI ");
    	  l1.setBounds(0, 0, 2000, 1000);
	      j0.add(l1);
	      
	      
	      //now adding background image
	      ImageIcon i=new ImageIcon("sunflower1.jpg");
	   
	      //l1.createImage(1000, 1000);
	      l1.setIcon(i);
	  
	      
	      //adding one more label
	       l2= new JLabel("WELCOME TO SBI");
	       //l1.add(l2);
	       l2.setBounds (300, 50, 600, 220);
	       l1.add(l2);
	       l2.setForeground(Color.orange);
		   l2.setFont(f1);
		   
		   b0=new Button("create ac");
		   b0.setBounds(50, 50, 100,50);
		   b0.setForeground(Color.blue);
		   b0.setFont(f);
		   l1.add(b0);	
		   
		   
		   b1=new Button("signup");
		   b1.setBounds(50, 750, 100,50);
		   b1.setForeground(Color.blue);
		   b1.setFont(f);
		   l1.add(b1);	
		   
		   l3= new JLabel("USERNAME");
		   l4= new JLabel("PIN");
		    
		  t1=new JTextField();
		   t2=new JTextField();
		   
		   l1.add(t1);
		   l1.add(t2);
		   l1.add(l3);
		   l1.add(l4);
		   
		   l3.setForeground(Color.blue);
		   l3.setFont(f);
		   
		   l4.setForeground(Color.blue);
		   l4.setFont(f);
		   
		   t1.setFont(f);
		   t2.setFont(f);
		   t1.setBounds (400, 250, 200, 50);
		   t2.setBounds (400, 450, 200, 50);
		   
		   l3.setBounds (200, 250, 100, 50);
		   l4.setBounds (200, 450, 100, 50);
	
		   
		   
		    j0.add(l1);
		   b0.addActionListener(this);
		   b1.addActionListener(this);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		START m=new START(i1);

	}
	public void actionPerformed(ActionEvent e)
	{
		String s=e.getActionCommand();
	 if(s.equals("create ac"))
	 {
		 j0.dispose();
		 new createac(i1);
	 }
	 if(s.equals("signup"))
	 {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(" 1111111111");
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306 "+"/register","root","unicorn");
			
			ps1=con.prepareStatement("select * from list");
			
			rs=ps1.executeQuery();
			
			String name=t1.getText();// username sent to name
			int  i1=Integer.parseInt(t2.getText());// for pin
			
			while(rs.next())
			 {
				String  name1=rs.getString(1);
				
				int i2=Integer.parseInt(rs.getString(2));// here we placed value of 2nd column in i2 object for comparing
				
				if(name.equals(name1)&& i1==i2)
				{
					j0.dispose();
					
					 new page2(i1);
					 c++;
				}
			}
				if(c==0)
				{
					JOptionPane.showMessageDialog(this,"incorrect pass", "error",JOptionPane.PLAIN_MESSAGE);
				}
	     } 
		 catch (SQLException e1) 
		 {
			
			e1.printStackTrace();
		 }
		//System.out.println("22222222222222");
        System.out.println(" connection successful");
		
	 }
  }

}

