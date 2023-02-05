package com.thenishchalraj.jetpackcomposelivestream.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thenishchalraj.jetpackcomposelivestream.data.SampleData
import com.thenishchalraj.jetpackcomposelivestream.model.GiftsData

@Composable
fun LiveGifts() {
    LazyRow {
        items(SampleData.giftsData) { gift ->
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