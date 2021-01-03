import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

    public connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String SQL;
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false",
                    "root", "");
        }catch(Exception e)
        {
            System.out.println(e);
        }


    }

}
