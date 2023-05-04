import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JPanel panel;
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridLayout(4, 2));
        frame.add(panel, BorderLayout.CENTER);

        // Set background color to be hot pink
        panel.setBackground(new Color(255, 100, 203));
        // Add components to the panel
        panel.add(new JLabel("Number 1:"));
        num1Field = new JTextField();
        panel.add(num1Field);

        panel.add(new JLabel("Number 2:"));
        num2Field = new JTextField();
        panel.add(num2Field);

        panel.add(new JLabel("Operator:"));
        JComboBox<String> operatorCombo = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        panel.add(operatorCombo);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                char operator = operatorCombo.getSelectedItem().toString().charAt(0);

                double res = 0;
                switch (operator) {
                    case '+':
                        res = num1 + num2;
                        break;
                    case '-':
                        res = num1 - num2;
                        break;
                    case '*':
                        res = num1 * num2;
                        break;
                    case '/':
                        res = num1 / num2;
                        break;
                }

                resultLabel.setText("Answer: " + res);
            }
        });
        panel.add(calculateButton);

        resultLabel = new JLabel();
        panel.add(resultLabel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

    }
}