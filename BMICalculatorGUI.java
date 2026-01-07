import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorGUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("BMI Calculator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Create labels and text fields
        JLabel weightLabel = new JLabel("Weight (kg):");
        JTextField weightField = new JTextField();

        JLabel heightLabel = new JLabel("Height (m):");
        JTextField heightField = new JTextField();

        JLabel resultLabel = new JLabel("BMI Result:");
        JLabel categoryLabel = new JLabel("");

        JButton calculateButton = new JButton("Calculate BMI");

        // Add components to frame
        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(new JLabel("")); // Empty label for spacing
        frame.add(calculateButton);
        frame.add(resultLabel);
        frame.add(categoryLabel);

        // Button action
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    double bmi = weight / (height * height);
                    String category;

                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi < 24.9) {
                        category = "Normal weight";
                    } else if (bmi < 29.9) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }

                    resultLabel.setText(String.format("BMI: %.2f", bmi));
                    categoryLabel.setText("Category: " + category);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }
}