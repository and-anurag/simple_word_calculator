
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCalculator extends JFrame {

    private JTextField inputField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public WordCalculator() {
        // Set up the frame
        setTitle("Word Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize components
        inputField = new JTextField(20);
        calculateButton = new JButton("Calculate Words");
        resultLabel = new JLabel("Number of words: 0");

        // Add components to the frame
        add(new JLabel("Enter text:"));
        add(inputField);
        add(calculateButton);
        add(resultLabel);

        // Add event listener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateWords();
            }
        });
    }

    private void calculateWords() {
        String text = inputField.getText();
        if (text.trim().isEmpty()) {
            resultLabel.setText("Number of words: 0");
        } else {
            String[] words = text.trim().split("\\s+");
            resultLabel.setText("Number of words: " + words.length);
        }
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCalculator().setVisible(true);
            }
        });
    }
}
