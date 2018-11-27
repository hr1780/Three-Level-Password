import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
	public static void main(String[] args) {  
	    JFrame f=new JFrame();  
	    JButton b=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/login.png"));  
	    b.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		f.dispose();
	    		new Loginfirstframe();
	    	}
	    });
	    b.setBounds(213,93,148,147);  
	    f.getContentPane().add(b);  
	    JButton b1=new JButton(new ImageIcon("C:/Users/Harsh/workspace/3_auth/src/sign.png"));  
	    b1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		f.dispose();
	    		new Firstframe();
	    	}
	    });
	    b1.setBounds(10,93,148,147);  
	    f.getContentPane().add(b1);  
	    
	    f.setSize(400,400);  
	    f.getContentPane().setLayout(null);  
	    
	    JLabel lblSelectYourChoice = new JLabel("Select Your Choice:");
	    lblSelectYourChoice.setBounds(123, 33, 195, 14);
	    f.getContentPane().add(lblSelectYourChoice);
	    f.setVisible(true);   
	}  
}


