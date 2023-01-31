package com.thenishchalraj.jetpackcomposelivestream.ui.sports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thenishchalraj.jetpackcomposelivestream.data.SampleData.alignYourBodyData
import com.thenishchalraj.jetpackcomposelivestream.ui.components.*
import com.thenishchalraj.jetpackcomposelivestream.ui.theme.JetpackComposeTutorialTheme

class SportsActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeTutorialTheme {
                Scaffold(
                    bottomBar = { BottomNavigationSection() }
                ) { padding ->
                    setSections(Modifier.padding(padding))
                }
            }
        }
    }

    @Composable
    fun setSections(modifier: Modifier = Modifier) {
        Column(
            modifier
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp)
        ) {
            SearchBar(Modifier.padding(horizontal = 16.dp))
            HomeSection(title = "Align your body") {
                AlignYourBodyRow()
            }
            HomeSection(title = "Favourite collections") {
                FavoriteCollectionsGrid()
            }
        }
    }

    @Composable
    fun AlignYourBodyRow(
        modifier: Modifier = Modifier
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(alignYourBodyData) { item ->
                AlignYourBodyElement(item.image, item.text)
            }
        }
    }

    @Composable
    fun FavoriteCollectionsGrid(
        modifier: Modifier = Modifier
    ) {
        LazyRow(
//            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.height(120.dp)
        ) {
            items(alignYourBodyData) { item ->
                FavoriteCollectionCard(
                    drawable = item.image,
                    text = item.text,
                    modifier = Modifier.height(56.dp)
                )
            }
        }
    }


}