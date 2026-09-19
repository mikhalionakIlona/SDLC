import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private final JLabel ageLabel = new JLabel("Возраст: —");
    private final JLabel resultLabel = new JLabel("Примерное количество «потом»: —");
    private final JButton inputButton = new JButton("Ввести данные");

    public MainView() {
        setTitle("Сколько раз ты сказал «потом»");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 220);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(ageLabel);
        panel.add(resultLabel);
        panel.add(inputButton);
        add(panel);
    }

    public JButton getInputButton() { return inputButton; }

    public void updateResult(int age, long result) {
        ageLabel.setText("Возраст: " + age + " лет");
        resultLabel.setText("Примерное количество «потом»: " + result);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}
