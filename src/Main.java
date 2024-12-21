import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Set the background color of the frame to blue
        frame.getContentPane().setBackground(Color.decode("#87CEFA"));

        // Create and add labels, text fields, and button to the frame
        JLabel weightLabel = new JLabel("Enter weight (kg): ");
        weightLabel.setForeground(Color.WHITE);  // Set label text color to white
        JTextField weightField = new JTextField(10);

        JLabel heightLabel = new JLabel("Enter height (m): ");
        heightLabel.setForeground(Color.WHITE);  // Set label text color to white
        JTextField heightField = new JTextField(10);

        JButton calcButton = new JButton("Calculate BMI");
        calcButton.setBackground(Color.PINK); // Set button background to pink
        calcButton.setForeground(Color.WHITE); // Set button text color to white

        JLabel resultLabel = new JLabel("BMI: ");
        resultLabel.setForeground(Color.WHITE);  // Set result label text color to white
        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setForeground(Color.WHITE);  // Set category label text color to white

        // Add components to the frame
        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(calcButton);
        frame.add(resultLabel);
        frame.add(categoryLabel);

        // Add action listener to the button
        calcButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Get input values
                        double weight = Double.parseDouble(weightField.getText());
                        double height = Double.parseDouble(heightField.getText());

                        // Calculate BMI
                        double bmi = weight / (height * height);

                        // Set the result text
                        resultLabel.setText("BMI: " + String.format("%.2f", bmi));

                        // Determine BMI category
                        String category;
                        if (bmi < 18.5) {
                            category = "Underweight";
                        } else if (bmi >= 18.5 && bmi < 24.9) {
                            category = "Normal weight";
                        } else if (bmi >= 25 && bmi < 29.9) {
                            category = "Overweight";
                        } else {
                            category = "Obese";
                        }

                        categoryLabel.setText("Category: " + category);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid numbers for weight and height.");
                    }
                }
            });

            // Make the frame visible
        frame.setVisible(true);
        }
    }