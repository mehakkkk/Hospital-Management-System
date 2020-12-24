import java.awt.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;

public class connection {

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HOSPITAL","demo","Demo#123");
        }catch(Exception e)
        {
            System.out.println(e);
        }


    }
}
