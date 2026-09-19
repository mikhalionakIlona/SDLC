import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PostponementModel model = new PostponementModel();
            MainView view = new MainView();
            new PostponementController(model, view);
            view.setVisible(true);
        });
    }
}
