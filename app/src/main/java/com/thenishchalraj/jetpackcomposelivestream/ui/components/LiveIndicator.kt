package com.thenishchalraj.jetpackcomposelivestream.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thenishchalraj.jetpackcomposelivestream.R

@Composable
fun LiveIndicator() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        ViewersIndicator()
        GiftsIndicator()
        CoinsIndicator()
        FollowersIndicator()
    }
}

@Composable
private fun ViewersIndicator() {
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
            modifier = Modifier
                .size(24.dp)
                .padding(vertical = 4.dp),
            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
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
}

@Composable
private fun CoinsIndicator() {
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
            modifier = Modifier.size(24.dp).padding(vertical = 4.dp),
            painter = painterResource(id = R.drawable.baseline_monetization_on_24),
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
}

@Composable
private fun GiftsIndicator() {
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
            modifier = Modifier
                .size(24.dp)
                .padding(vertical = 4.dp),
            painter = painterResource(id = R.drawable.baseline_card_giftcard_24),
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
}

@Composable
private fun FollowersIndicator() {
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
            modifier = Modifier.size(24.dp).padding(vertical = 4.dp),
            painter = painterResource(id = R.drawable.baseline_groups_2_24),
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

@Composable
@Preview
fun previewIndicators() {
    LiveIndicator()
}