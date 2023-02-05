package com.thenishchalraj.jetpackcomposelivestream.ui.live

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thenishchalraj.jetpackcomposelivestream.R
import com.thenishchalraj.jetpackcomposelivestream.data.SampleData.commentsData
import com.thenishchalraj.jetpackcomposelivestream.data.SampleData.giftsData
import com.thenishchalraj.jetpackcomposelivestream.model.CommentsData
import com.thenishchalraj.jetpackcomposelivestream.model.GiftsData
import com.thenishchalraj.jetpackcomposelivestream.ui.components.*
import com.thenishchalraj.jetpackcomposelivestream.ui.theme.JetpackComposeTutorialTheme

class LiveActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                Scaffold {
                    setUpLiveLayout()
                }
            }
        }
    }

    @Composable
    private fun setUpLiveLayout() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.live_studio),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier.fillMaxHeight(),
                Arrangement.SpaceBetween
            ) {
                Column {
                    LiveHeader()
                    LiveIndicator()
                }
                Column {
                    LiveComments()
                    LiveGifts()
                    LiveCommentBox()
                }
            }
        }
    }

    @Preview
    @Composable
    private fun liveLayoutPreview() {
        setUpLiveLayout()
    }

}