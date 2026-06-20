import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskServiceTest {
    private TaskService taskService;

    @Before
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("123", "Test Task", "A simple test task");
        taskService.addTask(task);
        assertNotNull(taskService.getTask("123"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateTask() {
        Task task1 = new Task("123", "Test Task 1", "First test task");
        taskService.addTask(task1);
        Task task2 = new Task("123", "Test Task 2", "Second test task");
        taskService.addTask(task2);
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("123", "Test Task", "A simple test task");
        taskService.addTask(task);
        taskService.deleteTask("123");
        assertNull(taskService.getTask("123"));
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("123", "Test Task", "A simple test task");
        taskService.addTask(task);
        taskService.updateTaskName("123", "Updated Name");
        taskService.updateTaskDescription("123", "Updated Description");
        Task updatedTask = taskService.getTask("123");
        assertEquals("Updated Name", updatedTask.getName());
        assertEquals("Updated Description", updatedTask.getDescription());
    }
}
