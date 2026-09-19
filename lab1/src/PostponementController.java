import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PostponementController implements PropertyChangeListener {
    private final PostponementModel model;
    private final MainView view;

    public PostponementController(PostponementModel model, MainView view) {
        this.model = model;
        this.view = view;
        model.addPropertyChangeListener(this);
        view.getInputButton().addActionListener(e -> openInputDialog());
    }

    private void openInputDialog() {
        InputDialog dialog = new InputDialog(view, model.getAge());
        dialog.setVisible(true);
        if (!dialog.isConfirmed()) return;

        try {
            model.setAge(dialog.getAge());
        } catch (NumberFormatException e) {
            view.showError("Введите корректное целое число.");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.updateResult(model.getAge(), model.getEstimatedPostponements());
    }
}
