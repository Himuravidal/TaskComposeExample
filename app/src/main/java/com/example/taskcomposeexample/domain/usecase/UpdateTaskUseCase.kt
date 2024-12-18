package com.example.taskcomposeexample.domain.usecase

import com.example.taskcomposeexample.domain.model.Task
import com.example.taskcomposeexample.domain.repository.TaskRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(taskDomain: Task) {
        repository.updateTask(taskDomain)
    }
}