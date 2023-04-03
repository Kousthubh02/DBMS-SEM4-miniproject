import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class gui extends JFrame implements ActionListener {

    JLabel nameLabel, cityLabel, ageLabel, deptLabel, collegeLabel;
    JTextField nameText, cityText, ageText, deptText, collegeText;
    JButton submitButton;

    public gui() {
        setTitle("Input Form");
        setLayout(new GridLayout(6, 2, 10, 10)); // set horizontal and vertical gap between components

        nameLabel = new JLabel("Name:");
        nameText = new JTextField();

        cityLabel = new JLabel("City:");
        cityText = new JTextField();

        ageLabel = new JLabel("Age:");
        ageText = new JTextField();

        deptLabel = new JLabel("Department:");
        deptText = new JTextField();

        collegeLabel = new JLabel("College:");
        collegeText = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // add components to the container
        add(nameLabel);
        add(nameText);
        add(cityLabel);
        add(cityText);
        add(ageLabel);
        add(ageText);
        add(deptLabel);
        add(deptText);
        add(collegeLabel);
        add(collegeText);
        add(new JLabel("")); // add an empty label to span 2 columns
        add(submitButton);
        setPreferredSize(new Dimension(500, 300));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == submitButton) {
            String name = nameText.getText();
            String city = cityText.getText();
            int age = Integer.parseInt(ageText.getText());
            String dept = deptText.getText();
            String college = collegeText.getText();

            try {
                // Connect to MySQL database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gui", "root", "Kousthubh@mysql");

                // Prepare SQL statement
                String sql = "INSERT INTO details (name, city, age, dept, college) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, city);
                pstmt.setInt(3, age);
                pstmt.setString(4, dept);
                
                pstmt.setString(5, college);

                // Execute SQL statement
                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Data inserted successfully!");
                }
    
                // Close database connection and statement
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        new gui();
    }
}