 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 
public class Asd {
 
    @SuppressWarnings("static-access")
	Asd(){
    	
	try{
            
            
            Class.forName("org.sqlite.JDBC");
            Connection con=DriverManager.getConnection("jdbc:sqlite:table1.db");
            Firstframe obj=new Firstframe();  
			Secondframe obj2=new Secondframe();
			ThirdFrame obj3 =new ThirdFrame();
			
			PreparedStatement stmt = null;
			 
            if(con!=null){
                try {
                	System.out.println(obj.pass);
                
                	String sql = "INSERT INTO Userdb (Uname,Passwd,Pattern,Pin,Image) VALUES (?,?,?,?,?)";
					stmt = con.prepareStatement(sql);
	                stmt.setString(1, obj.Username);
	                stmt.setLong(2, obj.pass);
	                stmt.setString(3, obj2.sb.toString());
	                stmt.setLong(4, obj3.Pin1);
	                stmt.setInt(5, obj3.image);
	                stmt.executeUpdate();
	                stmt.close();
	                con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
 

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Some error occured");
        }
		finally{
			 System.exit(0);
		}
    }    
}