import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  
public class Secondframe {
	
	static StringBuffer sb= new StringBuffer("0");
	//public static void main(String[] args)
	public Secondframe(){  
		
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
	    b3.setBounds(200,100,95,30);  
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
	    		if (sb.length()<2){
	    			JOptionPane.showMessageDialog(f, "Pattern Contains more than 2 Symbols"); 
	    		}
	    		else{
	    			f.dispose();
        			new ThirdFrame();
	    		}
	    	}
	    });
	    btnNewButton.setBounds(143, 233, 89, 23);
	    f.getContentPane().add(btnNewButton);
	    f.setVisible(true);   
	}  
}
