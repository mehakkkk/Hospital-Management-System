import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class Login extends JFrame {
    public JPanel panel1;
    private JTextField textField1;
    private JButton LOGINButton;
    private JPasswordField passwordField1;

    JFrame frame = new JFrame("MyForm");

    public static void main(String[] args) {
        Login log = new Login();
//        gui_client.prepareGUI();



        log.LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //DOCTOR LOGIN
                PreparedStatement ps;
                ResultSet rs;

                String DUsername = log.textField1.getText();
                String DPassword = String.valueOf(log.passwordField1.getPassword());

                if (DUsername.trim().equals("")){
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Please Enter your ID","Empty Username",2);
                }
                else if(DPassword.trim().equals("")){
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Please Enter Password","Empty Password",2);
                }
                else {
                    connection myconnection = new connection();
                    String selectquery = "SELECT * FROM Doctors WHERE 'DoctorId'=? AND 'DoctorPwd'=?";

                    //ps = myconnection.createConnection().preparedStatement(selectquery);
                }
            }
        });
    }
}