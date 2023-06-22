import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingProject {
    private final JFrame frame;
    private final JLabel label;
    private final JTextField textField;
    private final JButton button;
    private final JComboBox<String> comboBox;
    private final JRadioButton radioButton1;
    private final JRadioButton radioButton2;
    private final ButtonGroup radioGroup;

    public SwingProject() {
        // Create and configure the main frame
        frame = new JFrame("Swing Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create and add components to the frame
        label = new JLabel("Enter your name:");
        frame.add(label);

        textField = new JTextField(15);
        frame.add(textField);

        button = new JButton("Submit");
        button.addActionListener(new ButtonListener());
        frame.add(button);

        String[] options = {"Option 1", "Option 2", "Option 3"};
        comboBox = new JComboBox<>(options);
        frame.add(comboBox);

        radioButton1 = new JRadioButton("Option A");
        radioButton2 = new JRadioButton("Option B");
        radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        frame.add(radioButton1);
        frame.add(radioButton2);

        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }

    // Event listener for the button
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = textField.getText();
            String option = (String) comboBox.getSelectedItem();
            String radioButtonSelected = radioButton1.isSelected() ? "Option A" : "Option B";

            JOptionPane.showMessageDialog(frame,
                    "Hello, " + name + "! You selected: " + option + " and " + radioButtonSelected);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingProject::new);
    }
}
