package phonepay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class rough extends JFrame implements  ActionListener {

	JFrame j1;
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4;
	JLabel l1;
	Connection con;
	ResultSet rs1,rs2;
	PreparedStatement ps1;
	 String  s1;
	int pin1,s2, pin2;
	
	public rough()
	{
		j1=new JFrame();
		j1.setVisible(true);
		j1.setBounds(0, 0, 1500, 1000);
		j1.setLayout(null);
		j1.setTitle(" update page");
		
		
		l1=new JLabel();
		l1.setBounds(0, 0, 1500, 1000);
		
		
		ImageIcon i=new ImageIcon("sunflower1.jpg");
		
		l1.setIcon(i);
		j1.add(l1);
		
		t1=new JTextField();
		t1.setBounds(200, 200, 200, 50);
		
		t2=new JTextField();
		t2.setBounds(200, 400, 200, 50);
		
		t3=new JTextField();
		t3.setBounds(200, 600, 200, 50);
		t4=new JTextField();
		t4.setBounds(200, 800, 200, 50);
		l1.add(t1);
		l1.add(t2);
		l1.add(t3);
		l1.add(t4);
		
		b1=new JButton("update");
		b1.setBounds(100, 200, 100, 50);
		
		l1.add(b1);
		
		b1.addActionListener(this);
		
		
		
	   }
	
	public static void main(String[] args) {
		rough m=new rough();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// creating connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(" driver loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306"+"/ac","root","unicorn");
			System.out.println(" connection made");

			Statement stmt=con.createStatement();
			
		    rs1=	stmt.executeQuery("select * from costumers where pin=55");
			 System.out.println(" selected from costumers");
		      
			 // getting pin from t3
		 //int pin1=Integer.parseInt((t1.getText()));
		//	System.out.println(" pin1 taken from t1");

     	while(rs1.next())
			{			 // now we need to compare this pin with data base and get only that value
            // so we get pin2 from daatabase which is primary key
          //    int pin2=Integer.parseInt(rs1.getString(2));
     		   System.out.println("pin2 taken from database");
     		  pin2=rs1.getInt("pin");   
     		  s1=rs1.getString("name");
				 System.out.println(" name placed in s1");
				 s2=rs1.getInt("amount");
				 System.out.println(" amount placed");
				 }
     
  //   	if(pin1==pin2)
     //	{
			
     	t2.setText(s1);//name
     	t3.setText(" "+s2);// amount
    	t4.setText(""+pin2);//pin
     	//}	
			
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
