import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {
    public JPanel panel1;
    private JTextField textField1;
    private JButton LOGINButton;
    private JPasswordField passwordField1;
    private JButton CANCELButton;

    JFrame frame = new JFrame("MyForm");

    public Login(String role) {
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                        System.out.println(role);
                        String DuserID = textField1.getText();
                        String DPassword = String.valueOf(passwordField1.getPassword());

                        if (DuserID.trim().equals("")){
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Please Enter your ID","Empty Username",2);
                        }
                        else if(DPassword.trim().equals("")){
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Please Enter Password","Empty Password",2);
                        }
                        else {

                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false", "root", "Momislove");
                                PreparedStatement ps = cone.prepareStatement("select * from "+role);
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                                    if (rs.getString("ID").equals(DuserID) && rs.getString("pwd").equals(DPassword)) {
                                       System.out.println("reception exists");
                                        break;
                                    }
                                }
                            }
                            catch (SQLException | ClassNotFoundException sql) {
                                System.out.println(sql);
                            }
                        }

                    }
                });
        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.toBack();
                frame.dispose();
                LandingPage lp = new LandingPage();
                lp.frame1.setContentPane(lp.LandingPanel);
                lp.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                lp.frame1.pack();
                lp.frame1.setVisible(true);
                lp.frame1.toFront();

            }
        });
    }

}