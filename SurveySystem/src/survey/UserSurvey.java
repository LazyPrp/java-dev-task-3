package survey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserSurvey {

    private JFrame frame;
    private SQLManage manage; // Assuming SurveyManager is a class that handles survey operations

    public UserSurvey() throws SQLException {
        initialize();
    }

    private void initialize() throws SQLException {
        frame = new JFrame();
        frame.setBounds(440, 100, 500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        manage = new SQLManage(); // Initialize your SurveyManager here

        JButton btnTakeSurvey = new JButton("Do you want to take a survey?");
        btnTakeSurvey.setBounds(100, 200, 250, 40);
        frame.add(btnTakeSurvey);
        btnTakeSurvey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserLoginSurvey1 uls=new UserLoginSurvey1();
                uls.loginView();
            }
        });

        JButton btnCreateSurvey = new JButton("Do you want to create a survey?");
        btnCreateSurvey.setBounds(100, 300, 250, 40);
        frame.add(btnCreateSurvey);
        btnCreateSurvey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createSurvey();
            }
        });

        frame.setVisible(true);
    }

    private void attendSurvey() {
        // Code to attend a survey
        String surveyCode = JOptionPane.showInputDialog("Enter the Survey Code : ");
        try {
            if (surveyCode != null && !surveyCode.isEmpty() && surveyCode.length() == 5) {
                if (manage.check(surveyCode)) {
                    Guest guest = new Guest();
                    guest.guestView(surveyCode);
                } else {
                    JOptionPane.showMessageDialog(frame, "No Survey Available!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createSurvey() {
        Login log=new Login();
//        Login1 log=new Login1();
        try {
            log.loginView();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    UserSurvey window = new UserSurvey();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}


