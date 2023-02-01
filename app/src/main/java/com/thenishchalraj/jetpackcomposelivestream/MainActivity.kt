package com.thenishchalraj.jetpackcomposelivestream

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.thenishchalraj.jetpackcomposelivestream.ui.live.LiveActivity
import com.thenishchalraj.jetpackcomposelivestream.ui.theme.JetpackComposeTutorialTheme

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                setUpLayoutForActivities()
            }
        }
    }

    @Composable
    private fun setUpLayoutForActivities() {
        val mContext = LocalContext.current
        Column {
            Button(onClick = {
                mContext.startActivity(Intent(mContext, LiveActivity::class.java))
            }) {
                Text(text = "Live Screen")
            }
        }
    }

    @Preview
    @Composable
    fun showPreview() {
        setUpLayoutForActivities()
    }
}