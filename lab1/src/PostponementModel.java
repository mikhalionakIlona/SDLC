import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PostponementModel {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private int age;
    private long estimatedPostponements;

    public void setAge(int age) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Возраст должен быть от 1 до 120 лет.");
        }
        int oldAge = this.age;
        long oldResult = this.estimatedPostponements;
        this.age = age;
        this.estimatedPostponements = Math.round(age * 365.25 * 3);
        pcs.firePropertyChange("age", oldAge, this.age);
        pcs.firePropertyChange("estimatedPostponements", oldResult, this.estimatedPostponements);
    }

    public int getAge() { return age; }
    public long getEstimatedPostponements() { return estimatedPostponements; }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
