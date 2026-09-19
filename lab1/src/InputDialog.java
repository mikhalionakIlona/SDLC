import javax.swing.*;
import java.awt.*;

public class InputDialog extends JDialog {
    private final JTextField ageField = new JTextField(10);
    private boolean confirmed;

    public InputDialog(Frame owner, int previousAge) {
        super(owner, "Ввод данных", true);
        ageField.setText(previousAge > 0 ? String.valueOf(previousAge) : "");

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Отмена");

        okButton.addActionListener(e -> { confirmed = true; setVisible(false); });
        cancelButton.addActionListener(e -> { confirmed = false; setVisible(false); });

        JPanel form = new JPanel(new GridLayout(2, 2, 8, 8));
        form.add(new JLabel("Возраст:"));
        form.add(ageField);
        form.add(okButton);
        form.add(cancelButton);

        add(form);
        pack();
        setLocationRelativeTo(owner);
    }

    public boolean isConfirmed() { return confirmed; }
    public int getAge() { return Integer.parseInt(ageField.getText().trim()); }
}
