import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task is null or ID already exists.");
        }
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        tasks.remove(taskId);
    }

    public void updateTaskName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setName(newName);
        } else {
            throw new IllegalArgumentException("Task with ID " + taskId + " not found.");
        }
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setDescription(newDescription);
        } else {
            throw new IllegalArgumentException("Task with ID " + taskId + " not found.");
        }
    }

    // Added for testing purposes
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
