import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;      
public class ThirdFrame {
	private static JPasswordField passwordField;
	static int image;
	static String pin;
	static Long Pin1;
	//public static void main(String[] args){
	public ThirdFrame(){ 
		JFrame f=new JFrame("ThirdFrame");    
		JButton b1=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/Boat.png"));    
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image = 10;
			}
		});
		b1.setBounds(193,166,101, 58);    
		f.getContentPane().add(b1);  
		JButton b2=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/Cycle.png"));    
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image = 24;
			}
		});
		b2.setBounds(73,166,92, 58);    
		f.getContentPane().add(b2); 
		JButton b3=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/Beer.png"));    
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image = 34;
			}
		});
		b3.setBounds(73,82,92, 58);    
		f.getContentPane().add(b3); 
		JButton b4=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/Che.png"));    
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image = 22;
			}
		});
		b4.setBounds(193,82,101, 58);    
		f.getContentPane().add(b4); 
		f.setSize(400,400);    
		f.getContentPane().setLayout(null);    
		
		JLabel lblSelectYourImage = new JLabel("   Select Your Image");
		lblSelectYourImage.setBounds(127, 37, 148, 21);
		f.getContentPane().add(lblSelectYourImage);
		
		JLabel lblEnterYourPin = new JLabel("Enter 4 digit Pin");
		lblEnterYourPin.setBounds(73, 251, 92, 14);
		f.getContentPane().add(lblEnterYourPin);
		
		JButton btnFinish = new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/reg.png"));
		btnFinish.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				pin = passwordField.getText();
				Pin1 = (long)pin.hashCode();
				if(pin.matches("[0-9]+")&&pin.length()==4){
					if(image!=0){
						new Asd();					
				JOptionPane.showMessageDialog(f, "You Have Regester Sucessfully");
				
				f.dispose();
				}
					else
						JOptionPane.showMessageDialog(f, "Please Select a Image");	
				}
				else{
					JOptionPane.showMessageDialog(f, "Pin only Contain Numeric and length of 4 digit");
				}
					
			}
		});
		btnFinish.setBounds(127, 293, 116, 31);
		f.getContentPane().add(btnFinish);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 248, 67, 20);
		f.getContentPane().add(passwordField);
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		    }         
}