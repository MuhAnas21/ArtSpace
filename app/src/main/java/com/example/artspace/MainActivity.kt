package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    val title = "Still Life of Blue Rose and Other Flowereee"
    val artist = "Owen Scott"
    val year = "2021"

//    var imageShown by remember { mutableStateOf(1) }
//    val imageResource = when (imageShown){
//        1 -> R.drawable.samplebg
//        else -> null
//    }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 20.dp)
            .safeDrawingPadding()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 60.dp, horizontal = 12.dp)
        ) {
            ArtImage(R.drawable.samplebg)
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp)
        ) {
            ArtTitleAndDesc(title,artist,year)
        }
        Row {
            NavButton()
        }
    }
}

@Composable
fun ArtImage(imageContent: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .shadow(elevation = 5.dp)
            .padding(vertical = 45.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(
                id = imageContent
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .sizeIn(
                    minWidth = 100.dp,
                    minHeight = 150.dp,
                    maxWidth = 250.dp,
                    maxHeight = 370.dp
                )
        )
    }
}

@Composable
fun ArtTitleAndDesc(
    title: String,
    artist: String,
    year: String
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(red = 220, green = 220, blue = 220))
            .padding(10.dp)
    ) {
        Row {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .wrapContentWidth()
            )
        }
        Row {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold)
                    ) {
                        append("$artist ")
                    }
                    withStyle(style = SpanStyle(fontSize = 12.sp)
                    ) {
                        append("($year)")
                    }
                }
            )
        }
    }
}

@Composable
fun NavButton() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 25.dp, bottom = 10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .size(width = 140.dp, height = 35.dp)
            ) {
                Text(
                    text = "Previous"
                )
            }
        }
        Spacer(modifier = Modifier.width(40.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .wrapContentSize()
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .size(width = 140.dp, height = 35.dp)
            ) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}