package com.thenishchalraj.jetpackcomposelivestream.ui.hello

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thenishchalraj.jetpackcomposelivestream.R
import com.thenishchalraj.jetpackcomposelivestream.data.SampleData
import com.thenishchalraj.jetpackcomposelivestream.model.GreetingData
import com.thenishchalraj.jetpackcomposelivestream.ui.theme.JetpackComposeTutorialTheme

class HelloActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<GreetingData>) {
    LazyColumn {
        items(messages) { message ->
            Greeting(greetingData = message)
            
        }
    }
}

@Composable
fun Greeting(greetingData: GreetingData) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)

    ){
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_front_hand_24),
            contentDescription = "Hey hand",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.onBackground, CircleShape)
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        /*
        * when using the below, we can have the state of isExpanded persist when the view is not in composition
        * var isExpanded by rememberSaveable { mutableStateOf(false) }
        * */

        /*
        * when using below, we can use isExpanded.value to check for the condition
        * val isExpanded = remember { mutableStateOf(false) }
        */
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        val extraPadding by animateDpAsState(
            if (isExpanded) 48.dp else 0.dp,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )

        Column(
            modifier = Modifier.clickable {
                isExpanded = !isExpanded
            }
        ) {
            Button(
                onClick = {

                }
            ) {
                Text("Click me")
            }
            Text(
                text = "Hello ${greetingData.name}!",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor
            ) {
                Text(
                    text = greetingData.message,
                    style = if (isExpanded) MaterialTheme.typography.body2
                    else MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .padding(if (isExpanded) extraPadding else 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

// different previews added with different attributes
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTutorialTheme {
        Greeting(GreetingData("Raj", "Have a great day"))
    }
}
