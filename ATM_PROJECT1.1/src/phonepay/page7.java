package phonepay;

import java.awt.GraphicsConfiguration;
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

public class page7 extends JFrame implements ActionListener {

	JFrame j1;
	JButton b1,b2,b3;
	JTextField t1,t2,t3;
	JLabel l1;
	Connection con;
	ResultSet rs1,rs2;
	PreparedStatement ps1;
	 String  s1;
	int pin1,s2, pin2;
	static int id;
			int i1;
	public page7 (int i1)
	{
		this.i1=i1;

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
		
		l1.add(t1);
		
		
		b1=new JButton("balance");
		b1.setBounds(100, 200, 100, 50);
		b2=new JButton("back");
		b2.setBounds(100, 400, 100, 50);
		l1.add(b1);
		l1.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		}
      @Override
     	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		 if(s.equals("balance"))
		 {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(" driver loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306"+"/sbi","root","unicorn");
			System.out.println(" connection made");
            System.out.println(" "+i1);
			ps1=con.prepareStatement("select * from leftover WHERE id=?");
			ps1.setInt(1,i1);
			rs1=ps1.executeQuery();
			
		    //Statement stmt=con.createStatement();
			// rs1=	stmt.executeQuery("select * from costumer  WHERE id=?");
			//id=i1;
		    System.out.println(" selected from leftover");
		      
			// getting pin from t3
	    	// int pin1=Integer.parseInt((t1.getText()));
	    	//	System.out.println(" pin1 taken from t1");

     	   while(rs1.next())
			{			
                s2=rs1.getInt("balance");
				 System.out.println(" balance  placed"+s2);
				 }
        t1.setText(" "+s2);
         } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		 if(s.equals("back"))
		 {
			 j1.dispose();
			 new  page3(i1);
			 
		 }
		 }

}
