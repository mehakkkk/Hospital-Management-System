import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital","root","1234");
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
