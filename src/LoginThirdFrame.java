import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class LoginThirdFrame {
	private static JPasswordField passwordField;
	static int image;
	static String pin;
	static Long pin1;
	//public static void main(String[] args){
	public LoginThirdFrame(){ 
		JFrame f=new JFrame("ThirdFrame");    
		JButton b1=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/Boat.png"));    
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image = 10;
			}
		});
		b1.setBounds(151,184,101, 58);    
		f.getContentPane().add(b1);  
		JButton b2=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/Cycle.png"));    
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image = 24;
			}
		});
		b2.setBounds(37,184,92, 58);    
		f.getContentPane().add(b2); 
		JButton b3=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/Beer.png"));    
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image = 34;
			}
		});
		b3.setBounds(37,100,92, 58);    
		f.getContentPane().add(b3); 
		JButton b4=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/Che.png"));    
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image = 22;
			}
		});
		b4.setBounds(160,100,101, 58);    
		f.getContentPane().add(b4); 
		f.setSize(400,400);    
		f.getContentPane().setLayout(null);    
		
		JLabel lblSelectYourImage = new JLabel("   Select Your Image");
		lblSelectYourImage.setBounds(71, 43, 148, 21);
		f.getContentPane().add(lblSelectYourImage);
		
		JLabel lblEnterYourPin = new JLabel("Enter 4 digit Pin");
		lblEnterYourPin.setBounds(32, 271, 92, 14);
		f.getContentPane().add(lblEnterYourPin);
		
		JButton btnFinish = new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/reg.png"));
		btnFinish.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				pin = passwordField.getText();
				pin1 = (long) pin.hashCode();
				if(pin.matches("[0-9]+")&&pin.length()==4){
					if(image!=0){
						try{
		      				  Connection c = null;
		      				 Class.forName("org.sqlite.JDBC");
		      		         c = DriverManager.getConnection("jdbc:sqlite:table1.db");
		              		String query = "Select * from Userdb where uname=? and Pin=? and Image=?";
		              		PreparedStatement pst = c.prepareStatement(query);
		              		pst.setString(1, Loginfirstframe.Username);
		              		pst.setLong(2, pin1);
		              		pst.setInt(3, image);
		              		int count=0;
		              		ResultSet rs1 = pst.executeQuery();
		              		while(rs1.next()){
		              			count++;
		              		}

		              		if(count==1){
		              			f.dispose();
		              			JOptionPane.showMessageDialog(f, "Welcome");  
		              		}
		              		else{
		              			JOptionPane.showMessageDialog(f, "Wrong Pin or Image selection");  
		              		}
		              	}
		              	catch( Exception e1){
		              		 System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
		                       System.exit(0);
		              	}
						
				f.dispose();
				}
					
				}
					
			}
		});
		btnFinish.setBounds(88, 300, 116, 31);
		f.getContentPane().add(btnFinish);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 268, 67, 20);
		f.getContentPane().add(passwordField);
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		 
		    }
	        
}