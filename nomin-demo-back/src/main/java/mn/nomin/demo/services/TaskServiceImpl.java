package mn.nomin.demo.services;

import mn.nomin.demo.core.BaseServiceImpl;
import mn.nomin.demo.entities.Task;
import mn.nomin.demo.repositories.TaskRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends BaseServiceImpl<Task> implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public JpaRepository<Task, Long> getRepo() {
        return taskRepository;
    }
}
