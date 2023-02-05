package com.thenishchalraj.jetpackcomposelivestream.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thenishchalraj.jetpackcomposelivestream.data.SampleData
import com.thenishchalraj.jetpackcomposelivestream.model.CommentsData


@Composable
fun LiveComments() {
    LazyColumn(
        modifier = Modifier.height(
            (LocalConfiguration.current.screenHeightDp/5).dp
        )
    ) {
        items(SampleData.commentsData) { comment ->
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