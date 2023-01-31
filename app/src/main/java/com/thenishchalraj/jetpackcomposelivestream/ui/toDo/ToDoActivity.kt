package com.thenishchalraj.jetpackcomposelivestream.ui.toDo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thenishchalraj.jetpackcomposelivestream.ui.components.StatefulCounter
import com.thenishchalraj.jetpackcomposelivestream.ui.components.WellnessTasksList
import com.thenishchalraj.jetpackcomposelivestream.ui.theme.JetpackComposeTutorialTheme
import com.thenishchalraj.jetpackcomposelivestream.viewmodel.WellnessViewModel

class ToDoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                setWaterCounter()
            }
        }
    }

    @Composable
    private fun setWaterCounter(
        modifier: Modifier = Modifier,
        wellnessViewModel: WellnessViewModel = viewModel()
    ) {
        Column(modifier = modifier) {
            StatefulCounter()

            val list = wellnessViewModel.tasks
            WellnessTasksList(list = list, onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
                onCloseTask = { task -> wellnessViewModel.remove(task) })
        }
    }

    @Preview
    @Composable
    fun previewWaterCounter() {
        setWaterCounter()
    }

}