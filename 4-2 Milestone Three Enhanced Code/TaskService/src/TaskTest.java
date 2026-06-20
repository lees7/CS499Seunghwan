import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("12345", "Task Name", "Task Description");
        assertEquals("12345", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdTooLong() {
        new Task("12345678901", "Task Name", "Task Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskNameTooLong() {
        new Task("12345", "This name is definitely more than twenty characters", "Task Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskDescriptionTooLong() {
        new Task("12345", "Task Name", "This description is certainly more than fifty characters long, which should cause an exception");
    }
}
