import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginSecondframe {
	static StringBuffer sb= new StringBuffer("0");
	
	public LoginSecondframe(){  
		

	    JFrame f=new JFrame("2 FRame");  
	    JButton b1=new JButton("#");  
	    b1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		sb = sb.append("#");
	    	}
	    });
	    b1.setBounds(77,100,95,30);  
	    f.getContentPane().add(b1);  
	    JButton b2=new JButton("%");  
	    b2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		sb = sb.append("%");
	    	}
	    });
	    b2.setBounds(77,160,95,30);  
	    f.getContentPane().add(b2); 
	    JButton b3=new JButton("@");  
	    b3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		sb = sb.append("@");
	    	}
	    });
	    b3.setBounds(182,100,95,30);  
	    f.getContentPane().add(b3); 
	    JButton b4=new JButton("*");  
	    b4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		sb = sb.append("*");
	    	}
	    });
	    b4.setBounds(200,160,95,30);  
	    f.getContentPane().add(b4);
	    f.setSize(400,400);  
	    f.getContentPane().setLayout(null);   
	    
	    JLabel lblNewLabel = new JLabel("              Click the button in a Pattern");
	    lblNewLabel.setBounds(77, 46, 218, 30);
	    f.getContentPane().add(lblNewLabel);
	    
	    JButton btnNewButton = new JButton("NEXT");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    		if (sb.length()<=2){
	    			JOptionPane.showMessageDialog(f, "Pattern Contains more than 2 Symbols"); 
	    		}
	    		else{
	    			
	    			try{
	      				  Connection c1 = null;
	      				 Class.forName("org.sqlite.JDBC");
	      		         c1 = DriverManager.getConnection("jdbc:sqlite:table1.db");
	              		String query1 = "Select * from Userdb where uname=? and Pattern=?";
	              			              		
	              		PreparedStatement pst1 = c1.prepareStatement(query1);
	              		pst1.setString(1, Loginfirstframe.Username);
	              		//pst1.setString(2, obj.passwd);
	              		pst1.setString(2, sb.toString());
	              		int co=0;
	              		ResultSet rs1 = pst1.executeQuery();
	              		while(rs1.next()){
	              			co++;
	              		}
	              		//System.out.println(co);
	              		if(co==1){
	              			f.dispose();
	              			new LoginThirdFrame();
	              		}
	              		else{
	              			JOptionPane.showMessageDialog(f, "Wrong Pattern");  	
	              		}
	              	}
	              	catch( Exception e1){
	              		 System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
	                       System.exit(0);
	              	}
	    		}
	    	}
	    });
	    btnNewButton.setBounds(143, 233, 89, 23);
	    f.getContentPane().add(btnNewButton);
	    f.setVisible(true);   
	}  
}
