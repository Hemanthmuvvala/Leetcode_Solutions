// Last updated: 7/12/2026, 11:12:37 PM
import java.util.*;

class TaskManager {
    static class Task {
        int userId;
        int taskId;
        int priority;
        Task(int u, int t, int p) {
            userId = u;
            taskId = t;
            priority = p;
        }
    }

    private Map<Integer, Task> taskMap;
    private PriorityQueue<Task> maxHeap;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) return Integer.compare(b.priority, a.priority);
            return Integer.compare(b.taskId, a.taskId);
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            Task task = new Task(userId, taskId, priority);
            taskMap.put(taskId, task);
            maxHeap.offer(task);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        maxHeap.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        if (oldTask != null) {
            Task newTask = new Task(oldTask.userId, taskId, newPriority);
            taskMap.put(taskId, newTask);
            maxHeap.offer(newTask);
        }
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy removal
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            Task current = taskMap.get(top.taskId);

            // Validate both priority and userId to avoid accepting stale entries
            if (current != null && current.priority == top.priority && current.userId == top.userId) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}