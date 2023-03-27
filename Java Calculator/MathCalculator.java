import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArithmeticCalculatorGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;

    public ArithmeticCalculatorGUI() {
        // Set up the GUI components
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("First Number: "));
        firstNumberField = new JTextField(10);
        inputPanel.add(firstNumberField);
        inputPanel.add(new JLabel("Second Number: "));
        secondNumberField = new JTextField(10);
        inputPanel.add(secondNumberField);
        inputPanel.add(new JLabel("Result: "));
        resultField = new JTextField(10);
        resultField.setEditable(false);
        inputPanel.add(resultField);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);
        JButton subtractButton = new JButton("Subtract");
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton);
        JButton multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(this);
        buttonPanel.add(multiplyButton);
        JButton mod = new JButton("mod");
        mod.addActionListener(this);
        buttonPanel.add(mod); 
        JButton divideButton = new JButton("Divide");
        divideButton.addActionListener(this);
        buttonPanel.add(divideButton);
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);
        JButton expButton = new JButton("Exp");
        expButton.addActionListener(this);
        buttonPanel.add(expButton);
        // Add the components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Set up the frame
        setTitle("GROUP 5 MATH CALCULATOR");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the first and second numbers from the text fields
        double firstNumber = Double.parseDouble(firstNumberField.getText());
        double secondNumber = Double.parseDouble(secondNumberField.getText());

        // Perform the operation based on which button was clicked
        String action = e.getActionCommand();
        switch (action) {
            case "Add":
                resultField.setText(Double.toString(firstNumber + secondNumber));
                break;
            case "Subtract":
                resultField.setText(Double.toString(firstNumber - secondNumber));
                break;
            case "Multiply":
                resultField.setText(Double.toString(firstNumber * secondNumber));
                break;
            case "mod":
                resultField.setText(Double.toString(firstNumber % secondNumber));
                break;
            case "Exp":
                resultField.setText(Double.toString(Math.pow(firstNumber, secondNumber)));
                break;
            
            case "Divide":
                if (secondNumber == 0) {
                    resultField.setText("Cannot divide by zero");
                } else {
                    resultField.setText(Double.toString(firstNumber / secondNumber));
                }
                break;
            case "Clear":
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                break;
            case "Exit":
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        ArithmeticCalculatorGUI calculator = new ArithmeticCalculatorGUI();
        calculator.setVisible(true);
    }

}
