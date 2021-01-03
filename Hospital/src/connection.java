import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String SQL;
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false",
                    "root", "Momislove");
        }catch(Exception e)
        {
            System.out.println(e);
        }


    }

}
