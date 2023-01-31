package com.thenishchalraj.jetpackcomposelivestream.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.thenishchalraj.jetpackcomposelivestream.model.WellnessTaskData

@Composable
fun WellnessTasksList(
    onCheckedTask: (WellnessTaskData, Boolean) -> Unit,
    onCloseTask: (WellnessTaskData) -> Unit,
    list: List<WellnessTaskData>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(taskName = task.label, checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) })
        }
    }

}