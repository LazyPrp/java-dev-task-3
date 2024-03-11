package survey;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Properties;
public class UserLoginSurvey1 {

    private SQLManage manage;
    private JFrame frame;


    public UserLoginSurvey1() {
        try {
            manage = new SQLManage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loginView() {
        frame = new JFrame();
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel heading = new JLabel("User Login");
        heading.setBounds(150, 20, 100, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(heading);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 80, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(140, 70, 200, 30);
        frame.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 110, 80, 30);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(140, 110, 200, 30);
        frame.add(emailField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 160, 100, 30);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                // You can add validation logic here before processing the login
                if (name.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your name and email.", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    sendEmail(name, email);
                    attendSurvey();

                }
            }
        });

        frame.setVisible(true);
    }

    private void attendSurvey() {
        JOptionPane.showMessageDialog(null,"Mail has been sent to you .check mail for survey code");
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

    private void sendEmail(String name, String email) {
        try {
            String surveyCode = manage.getSurveyCode(); // Retrieve survey code
            if (surveyCode != null) {
                // Sender's email and password
                final String username = "paprasad.8.66@gmail.com"; // Enter your Gmail address
                final String password = "ivrssbighechbnep"; // Enter your Gmail app password

                // SMTP server settings
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                // Create a session with authentication
                Session session = Session.getInstance(props, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setSubject("Survey Code");
                message.setText("Dear " + name + ",\n\nYour survey code is: " + surveyCode);

                Transport.send(message);
                System.out.println("Email with survey code sent successfully.");
            } else {
                System.out.println("No survey code available.");
            }
        } catch (MessagingException | SQLException ex) {
            System.out.println("Error sending email: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"give proper email");
        }
    }

//    public static void main(String[] args) {
//        UserLoginSurvey1 userLogin = new UserLoginSurvey1();
//        userLogin.loginView();
//    }
}
