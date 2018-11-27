import java.awt.FlowLayout;


import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;  
public class Firstframe {
	static String Username;
	static String passwd;
	private static JTextField textField;
	private static JPasswordField passwordField;
	public static Long pass;
   // public static void main(String s[])
	public Firstframe(){  
        JFrame frame = new JFrame("1 LABLE");  
        JPanel panel = new JPanel();  
        panel.setLayout(new FlowLayout());  
        JLabel label = new JLabel("JFrame By Example");  
        JButton button = new JButton();  
        button.setText("Button");  
        panel.add(label);  
        panel.add(button);  
        frame.getContentPane().add(panel);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(81, 106, 86, 14);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setBounds(81, 165, 67, 14);
        frame.getContentPane().add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(200, 103, 121, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
		
        
        passwordField = new JPasswordField();
        passwordField.setBounds(200, 162, 121, 20);
        frame.getContentPane().add(passwordField);
        
        JButton btnNext = new JButton("NEXT");
        btnNext.addActionListener(new ActionListener() {
        	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
        		passwd = passwordField.getText();
        	     Username = textField.getText();
        		if (Username.length()==0)
        			JOptionPane.showMessageDialog(frame, "Must Have a Username");
        		else
        		if (passwd.matches("[a-zA-Z0-9]+")&&passwd.length()>=7){
        			try{
        			pass = (long) passwd.hashCode();
      				  Connection c = null;
      				 Class.forName("org.sqlite.JDBC");
      		         c = DriverManager.getConnection("jdbc:sqlite:table1.db");
              		String query = "Select * from Userdb where uname=?";
              		PreparedStatement pst = c.prepareStatement(query);
              		pst.setString(1, Username);
              		int count=0;
              		ResultSet rs = pst.executeQuery();
              		while(rs.next()){
              			count++;
              		}
              		if(count==1){
              			JOptionPane.showMessageDialog(frame, "Choose another username ");  
              		}
              		else{
        			frame.dispose();
        			new Secondframe();
              		}
        			}
              		catch( Exception e1){
	              		 System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
	                       System.exit(0);
	              	}
        		}
                else{
                	JOptionPane.showMessageDialog(frame, "WEAK PASSWORD \n Your Password Must Contain Alpahabets and Number\n LEngth Must 7 digit or Greater");  
                }
        	}
        });
        btnNext.setBounds(156, 218, 89, 23);
        frame.getContentPane().add(btnNext);
        frame.setSize(400, 400);  
       // frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }
	
}  