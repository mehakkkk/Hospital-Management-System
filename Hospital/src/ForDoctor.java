import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ForDoctor {
    private JTextField Ptext;
    private JButton searchPatientButton;
    private JButton getPatientHistoryButton;
    public JPanel DocPanel;
    private JLabel DrName;
    private JLabel dept;
    private JTable PatientHistory;
    private JTable PatientInfo;
    private JButton ById;
    private JButton canceldoc;
    private JButton ByName;
    private JLabel EnterLabel;
    private JButton addPatientHistoryButton;

    JFrame frame = new JFrame("Doctor Dashboard");
    Statement statement;
    Connection cone=null;
    ResultSet rs;
    String c,sql;

    int flag1=0;


    public ForDoctor(String Did) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false", "root", "Momislove");
            PreparedStatement ps = cone.prepareStatement("select FName,LName from Employee where ID =\"" + Did+"\";" );
            rs = ps.executeQuery();
            rs.beforeFirst();
            rs.next();
            c= " "+rs.getString(1)+" "+rs.getString(2);
            System.out.println(c);
            DrName.setText("Dr."+c);

            statement = (Statement) cone.createStatement();
            sql = "select Doctor.ID, Department.DepartmentName From Doctor Join Department Where Doctor.Department = Department.ID and Doctor.Id =\"" + Did+"\";";
            ResultSet rs = statement.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            c= " "+rs.getString(2)+"\n";
            dept.setText(c);
        }
        catch (SQLException | ClassNotFoundException sql) {
            System.out.println(sql);
        }
        searchPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ById.setVisible(true);
            ByName.setVisible(true);
            Ptext.setVisible(true);

            }
        });
        canceldoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        getPatientHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ptext.setVisible(true);
                EnterLabel.setText("            Enter Patient ID :   ");
                String Patientid = Ptext.getText();
                String[] columnNames = {"PatientID","Details","Medicines","Admit","Disease","DoctorID"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                try {
                    statement = (Statement) cone.createStatement();
                    sql = "select * from PatientHistory where PatientID =\"" + Patientid +"\";";
                    rs = statement.executeQuery(sql);
                    tableModel.addRow(new Object[] {"PatientID","Details","Medicines","Admit","Disease","DoctorID" });
                    System.out.println(rs);

                    if (rs.next() == false) {
                        addPatientHistoryButton.setVisible(true);
                        System.out.println("ResultSet in empty in Java");
                    } else {

                        do {
                            String ID = rs.getString("PatientID");
                            String details = rs.getString("Details");
                            String medicines = rs.getString("Medicines");
                            Boolean admit = rs.getBoolean("Admit");
                            String disease = rs.getString("Disease");
                            String DocId = rs.getString("DoctorID");

                            // create a single array of one row's worth of data
                            String[] data = { ID,details,medicines,String.valueOf(admit),disease,DocId} ;
                            System.out.println(data);
                            tableModel.addRow(data);
                        } while (rs.next());
                    }
                    PatientHistory.setModel(tableModel);
                    System.out.println(rs);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        ById.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnterLabel.setText("            Enter Patient ID :   ");
                String Patientid = Ptext.getText();
                String[] columnNames = {"ID","Name","RegisterTime","Age","Sex","Address","PhoneNumber1","PhoneNumber2"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                try {
                    statement = (Statement) cone.createStatement();
                    sql = "select * from Patient where ID =\"" + Patientid +"\";";
                    rs = statement.executeQuery(sql);
                    tableModel.addRow(new Object[] {"ID","Name","RegisterTime","Age","Sex","Address","PhoneNumber1","PhoneNumber2" });
                    while (rs.next()) {
                        String ID = rs.getString("ID");
                        String Fname = rs.getString("FirstName");
                        String registerTime = rs.getString("RegisterTime");
                        String Lname = rs.getString("LastName");
                        String name = Lname+" "+Fname;
                        Integer age = rs.getInt("Age");
                        String sex = rs.getString("Sex");
                        String address = rs.getString("Address");
                        Long Ph1 = rs.getLong("PhoneNumber1");
                        Long Ph2 = rs.getLong("PhoneNumber2");

                        // create a single array of one row's worth of data
                        String[] data = { ID,name,registerTime,String.valueOf(age),sex,address,String.valueOf(Ph1),String.valueOf(Ph2)} ;
                        System.out.println(data);
                        tableModel.addRow(data);
                    }
                    PatientInfo.setModel(tableModel);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        ByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnterLabel.setText("            Enter Patient Name :   ");
                String Patientname = Ptext.getText();
                String[] columnNames = {"ID","Name","RegisterTime","Age","Sex","Address","PhoneNumber1","PhoneNumber2"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                try {
                    statement = (Statement) cone.createStatement();
                    sql = "select * from Patient where FirstName =\"" + Patientname +"\";";
                    rs = statement.executeQuery(sql);
                    tableModel.addRow(new Object[] {"ID","Name","RegisterTime","Age","Sex","Address","PhoneNumber1","PhoneNumber2" });
                    while (rs.next()) {
                        String ID = rs.getString("ID");
                        String Fname = rs.getString("FirstName");
                        String registerTime = rs.getString("RegisterTime");
                        String Lname = rs.getString("LastName");
                        String name = Lname+" "+Fname;
                        Integer age = rs.getInt("Age");
                        String sex = rs.getString("Sex");
                        String address = rs.getString("Address");
                        Long Ph1 = rs.getLong("PhoneNumber1");
                        Long Ph2 = rs.getLong("PhoneNumber2");

                        // create a single array of one row's worth of data
                        String[] data = { ID,name,registerTime,String.valueOf(age),sex,address,String.valueOf(Ph1),String.valueOf(Ph2)} ;
                        System.out.println(data);
                        tableModel.addRow(data);
                    }
                    PatientInfo.setModel(tableModel);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        addPatientHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddHistory doc = new AddHistory();
            }
        });
    }
}
