import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounterApp() {
        setTitle("Word Counter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area for User Input
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for Button and Label
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Count Button
        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        // Result Label
        resultLabel = new JLabel("Word Count: 0");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(countButton);
        panel.add(resultLabel);

        add(panel, BorderLayout.SOUTH);
    }

    private void countWords() {
        String text = textArea.getText().trim();
        if (text.isEmpty()) {
            resultLabel.setText("Word Count: 0");
            return;
        }
        String[] words = text.split("\\s+"); // Splitting by whitespace
        resultLabel.setText("Word Count: " + words.length);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounterApp app = new WordCounterApp();
            app.setVisible(true);
        });
    }
}
