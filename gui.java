import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

            System.out.println("Name: " + name);
            System.out.println("City: " + city);
            System.out.println("Age: " + age);
            System.out.println("Department: " + dept);
            System.out.println("College: " + college);
        }
    }

    public static void main(String[] args) {
        new gui();
    }
}
