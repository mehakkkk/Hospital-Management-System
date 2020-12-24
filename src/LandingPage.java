import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame {
    private JButton administratorButton;
    private JButton receptionistButton;
    private JButton doctorButton;
    private JPanel LandingPanel;



    public static void main(String[] args) {
        LandingPage lp = new LandingPage();

        JFrame frame1 = new JFrame("MyForm");
        frame1.setContentPane(lp.LandingPanel);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);

        lp.doctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lp.loadLogin();
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });

        lp.receptionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lp.loadLogin();
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
        lp.administratorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lp.loadLogin();
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
    }

    void loadLogin(){

       // LandingPage lp = new LandingPage();

        Login log1 = new Login();
        //log1.setVisible(true);

        log1.frame.setContentPane(log1.panel1);
        log1.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log1.frame.pack();
        log1.frame.setVisible(true);

//        lp.frame1.dispose();
    }

}
