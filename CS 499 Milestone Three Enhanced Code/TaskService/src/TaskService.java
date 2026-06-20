import java.util.*;

public class TaskService {

    private final Map<String, Task> tasks;

    public TaskService() {
        tasks = new HashMap<>();
    }

    // Add task
    public void addTask(Task task) {

        if (task == null ||
                tasks.containsKey(task.getTaskId())) {

            throw new IllegalArgumentException(
                    "Task is null or ID already exists.");
        }

        tasks.put(task.getTaskId(), task);
    }

    // Delete task
    public void deleteTask(String taskId) {

        if (!tasks.containsKey(taskId)) {

            throw new IllegalArgumentException(
                    "Task ID does not exist.");
        }

        tasks.remove(taskId);
    }

    // Retrieve task by ID
    public Task getTask(String taskId) {

        Task task = tasks.get(taskId);

        if (task == null) {

            throw new IllegalArgumentException(
                    "Task ID does not exist.");
        }

        return task;
    }

    // Update task name
    public void updateTaskName(
            String taskId,
            String newName) {

        getTask(taskId).setName(newName);
    }

    // Update task description
    public void updateTaskDescription(
            String taskId,
            String newDescription) {

        getTask(taskId).setDescription(newDescription);
    }

    // Search by task name
    public List<Task> searchByName(
            String name) {

        List<Task> results =
                new ArrayList<>();

        for (Task task : tasks.values()) {

            if (task.getName()
                    .equalsIgnoreCase(name)) {

                results.add(task);
            }
        }

        return results;
    }

    // Search keyword in description
    public List<Task> searchByDescriptionKeyword(
            String keyword) {

        List<Task> results =
                new ArrayList<>();

        for (Task task : tasks.values()) {

            if (task.getDescription()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                results.add(task);
            }
        }

        return results;
    }

    // Filter by name prefix
    public List<Task> filterByNamePrefix(
            String prefix) {

        List<Task> results =
                new ArrayList<>();

        for (Task task : tasks.values()) {

            if (task.getName()
                    .startsWith(prefix)) {

                results.add(task);
            }
        }

        return results;
    }

    // Sort alphabetically by task name
    public List<Task> getTasksSortedByName() {

        List<Task> sorted =
                new ArrayList<>(tasks.values());

        sorted.sort(
                Comparator.comparing(Task::getName));

        return sorted;
    }

    // Sort by description length
    public List<Task> getTasksSortedByDescriptionLength() {

        List<Task> sorted =
                new ArrayList<>(tasks.values());

        sorted.sort(
                Comparator.comparingInt(
                        task -> task.getDescription().length()));

        return sorted;
    }

    // Count tasks
    public int getTaskCount() {

        return tasks.size();
    }

    // Return all tasks
    public Map<String, Task> getAllTasks() {

        return new HashMap<>(tasks);
    }
}