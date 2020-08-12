 package phonepay;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class page5 extends JFrame implements ActionListener{

	
	JFrame j1;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4;
	ImageIcon i;

	String s1,s2;
	int withdraw,amt, balance,pinfromdatabase;
	Connection con;
	PreparedStatement ps2,ps3,ps4;
	ResultSet rs1,rs2;
	
	static int i1;
	
	
	public page5(int i1)
	{
		this.i1=i1;
		j1=new JFrame();
		j1.setVisible(true);
		j1.setLayout(null);
		j1.setSize(1500, 1000);
		j1.setTitle("savings amount transact page");
		
		 
		Font f1=new Font("IMPACT",Font.BOLD,30);
		   
		l1=new JLabel();
		l2=new JLabel("enter amount to withdraw");
		
		ImageIcon i=new ImageIcon("sunflower1.jpg");
		
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		
		b1=new JButton("CONFIRM");
		b2=new JButton("BACK");
		b3=new JButton("BALANCE");
		
		l1.add(t1);
		l1.add(t2);
		l1.add(t3);
		
		l1.add(b1);
		l1.add(b2);
	    l1.add(b3);
		
		l1.setIcon(i);
		j1.add(l1);
	    l1.add(l2);
		
		l2.setFont(f1);
		l2.setBackground(Color.BLUE);
		l2.setForeground(Color.ORANGE);
		
		
		
		l1.setBounds(0, 0,1500,1000);
		l2.setBounds(0, 0,500,100);
		t1.setBounds(500,300, 300, 60);
		 
		b1.setBounds(550, 600, 200, 50);
		b2.setBounds(1200, 800, 200, 50);
		
		t2=new JTextField();
		l1.add(t2);  
		t2.setBounds(500, 800, 300, 50);
		
		t2.setFont(f1);
		t1.setFont(f1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String s=e.getActionCommand();
		
		  if(s.equals("BACK"))
		    {
		    	j1.dispose();
		    	new page3(i1);	
		    }
		 else if(s.equals("confirm"));
       {
    	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306"+"/sbi","root","unicorn");
		    
            System.out.println(" connection made");
            ps2=con.prepareStatement("insert into  detail values (?)");//statement made
		    String s1=t1.getText();// getting withdraw amt
			int withdraw2=Integer.parseInt(s1);//value is here we need to minus this from amount
		    ps2.setInt(1,withdraw2); //setting in withdraw column   
		    System.out.println(" withdraw2  inserted="+withdraw2);
		    
		    
		    
            ps3=con.prepareStatement("select * from costumer where id =?");// getting amt from costumer
			 ps3.setInt(1,i1);
		    rs1 = ps3.executeQuery();
		    while(rs1.next())
			{
				 amt= rs1.getInt("amount");
			}
			System.out.println(" amount placed in amt  ="+amt);
		    ps2.executeUpdate();
		    ps3.execute();
			if(amt<withdraw)
			{	
			         	JOptionPane.showMessageDialog(this,"insufficient balance", "error",JOptionPane.PLAIN_MESSAGE);
             }
			else
			{
		    balance=amt-withdraw2;
		   System.out.println("amount retrived="+withdraw);
            System.out.println("balance left="+balance);
           
            ps4=con.prepareStatement("insert into leftover values (?)");// inserting balance in details
		
            String s2=t2.getText();// gettin g withdraw amt
     		//int balance=Integer.parseInt(s2);
            ps4.setInt(1, balance);
	       
		  System.out.println(" balance set in column"+balance);
		    t2.setText(" "+balance);// now its proper string coz of double quotes
            ps4.executeUpdate();
			
			}
			
			System.out.println(" ps2 executed");
			
		   	}
    	   catch (ClassNotFoundException e1)
    	   {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		}
      
       
       
       }
	}
