package com.example.taskcomposeexample.presentation.ui.list.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskcomposeexample.presentation.theme.TaskComposeExampleTheme
import com.example.taskcomposeexample.presentation.uimodel.TaskUiModel


@Composable
fun TaskItem(
    task: TaskUiModel,
    onTaskClick: (Int)-> Unit,
    onTaskToggle: (Int)-> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onTaskClick(task.id)
            }
    ){
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = task.isCompleted,
                    onCheckedChange = { onTaskToggle(task.id) }
                )
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.bodyLarge,
                    textDecoration = if (task.isCompleted)
                        TextDecoration.LineThrough
                    else
                        TextDecoration.None,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Text(task.description)
        }

    }
}

@Preview
@Composable
fun TaskItemPreview() {
    TaskComposeExampleTheme {
        val task = TaskUiModel(1,
            "This is a task",
                "Description",
                false,
                "12-20-2024"
            )
        TaskItem(
            task = task,
            onTaskClick = {},
            onTaskToggle = {}
        )
    }
}