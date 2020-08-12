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
import javax.swing.JTextField;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class page6 extends JFrame implements ActionListener{
    static int i1;
    JFrame j1;
    JLabel l2;
    ImageIcon img;
    JTextField t1,t2;
    JButton b1;
    int amt2;
    Connection con;
    PreparedStatement ps4;
	ResultSet rs1;
    String name2,sql;
    
	 public page6(int i)
	 {
		this.i1=i1;
		j1=new JFrame();
		j1.setVisible(true);
		j1.setLayout(null);
		j1.setSize(1500, 1000);
		j1.setTitle("display amount page");
		 
	    Font f=new Font("IMPACT",Font.BOLD,20);
   	    Font f1=new Font("IMPACT",Font.BOLD,50);
   	    l2= new JLabel();
   	    //  l1.setName(" Welcome to SBI ");
   	    l2.setBounds(0, 0, 1500, 1000);
	    j1.add(l2);
	   
	    //now adding background image
	    ImageIcon img=new ImageIcon("sunflower1.jpg");
	   
	    //l1.createImage(1000, 1000);
	    l2.setIcon(img);
	    
	    t1= new JTextField();
	    t1.setBounds(400, 400, 200, 50);
		l2.add(t1);
		
		t1.setFont(f);
		
	   // t2= new JTextField();
	    //t2.setBounds(400, 500, 200, 50);
		//l2.add(t2);
		
		t1.setFont(f);
		 
		b1=new JButton("back");
		b1.setBounds(800, 800, 100, 50);
	    l2.add(b1);
		 
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306"+"/sbi","root","unicorn");

	        try{
				String sql=" SELECT  amount FROM costumer WHERE amount=?";
				ps4=con.prepareStatement(sql);
				ps4.setString(1,t1.getText());
				rs1=ps4.executeQuery(sql);
				while(rs1.next())
				{
					System.out.println("name is:"+rs1.getString(1)+"\n id: "
				+rs1.getInt(2)+"\n amount: "+rs1.getInt(3));
					System.out.println("------------------------------");
					
					t1.setText(rs1.getString("amount"));
				
				}
			}
			catch(SQLException s)
			{
				s.printStackTrace();
			}
	       // t1.setText(" "+amt2);
	      //  t2.setText(""+name2);
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	    b1.addActionListener(this);
		 
		 
		 
		 
		 
	 }
    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String s=e.getActionCommand();
		 if(s.equals("back"))
		 {
			 j1.dispose();
			 new page3(i1);
		 }
		
		
	}
}

	

	


	
	
	

