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
                    liveHeader()
                    liveIndicator()
                }
                Column {
                    liveComments()
                    liveGifts()
                    liveCommentBox()
                }
            }
        }
    }

    @Composable
    private fun liveCommentBox() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(32.dp),
            trailingIcon = { Icon(Icons.Filled.Send, "", tint = Color.Black) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(text = "Type a comment")
            },
        )
    }

    @Composable
    private fun liveGifts() {
        LazyRow {
            items(giftsData) { gift ->
                GiftItem(gift)
            }
        }
    }

    @Composable
    private fun GiftItem(gift: GiftsData) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 6.dp)
        ) {
            Image(
                painter = painterResource(id = gift.giftImage),
                contentDescription = gift.giftName,
                modifier = Modifier.size(32.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = gift.giftValue,
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }

    @Composable
    private fun liveComments() {
        LazyColumn(
            modifier = Modifier.height(
                (LocalConfiguration.current.screenHeightDp/5).dp
            )
        ) {
            items(commentsData) { comment ->
                CommentsItem(comment)
            }
        }
    }

    @Composable
    private fun CommentsItem(comment: CommentsData) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 2.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(16.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = comment.avatar),
                contentDescription = "avatar",
                modifier = Modifier
                    .size(16.dp)
                    .border(color = Color.White, width = 1.dp, shape = CircleShape)
                    .padding(2.dp)
            )
            Text(
                text = "${comment.name}:",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(text = comment.comment, color = Color.White)
        }
    }

    @Composable
    private fun liveIndicator() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .background(
                        Color.LightGray, shape = RoundedCornerShape(
                            topStart = 24.dp, bottomStart = 24.dp
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_front_hand_24),
                    contentDescription = "viewers watching"
                )
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 10.dp),
                    text = "2M",
                    fontSize = 12.sp,
                    color = Color.Black,
                )
            } // viewers watching
            Row(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .background(
                        Color.LightGray, shape = RoundedCornerShape(
                            topStart = 24.dp, bottomStart = 24.dp
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_front_hand_24),
                    contentDescription = "gifts received"
                )
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 10.dp),
                    text = "1M",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            } // gifts got
            Row(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .background(
                        Color.LightGray, shape = RoundedCornerShape(
                            topStart = 24.dp, bottomStart = 24.dp
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_front_hand_24),
                    contentDescription = "coins earned",
                )
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 10.dp),
                    text = "13M",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            } // coins earned
            Row(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .background(
                        Color.LightGray, shape = RoundedCornerShape(
                            topStart = 24.dp, bottomStart = 24.dp
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_front_hand_24),
                    contentDescription = "followers gained"
                )
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 10.dp),
                    text = "200K",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            } // followers gained
        }
    }

    @Composable
    private fun liveHeader() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.live_profile),
                    contentDescription = "live profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(text = "Nishchal Raj", fontSize = 14.sp, color = Color.White)
                    Text(text = "Following", fontSize = 12.sp, color = Color.White)
                }
            }
            Image(
                Icons.Filled.Close,
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }

    @Preview
    @Composable
    private fun liveLayoutPreview() {
        setUpLiveLayout()
    }

}