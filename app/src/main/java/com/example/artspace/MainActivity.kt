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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.model.Artwork
import com.example.artspace.ui.theme.ArtSpaceTheme
import kotlin.rem

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

    val artworks = remember {
        listOf(
            Artwork(R.drawable.art1, R.string.art1_title, R.string.art1_artist, R.string.art1_year),
            Artwork(R.drawable.art2, R.string.art2_title, R.string.art2_artist, R.string.art2_year),
            Artwork(R.drawable.art3, R.string.art3_title, R.string.art3_artist, R.string.art3_year),
            Artwork(R.drawable.art4, R.string.art4_title, R.string.art4_artist, R.string.art4_year),
            Artwork(R.drawable.art5, R.string.art5_title, R.string.art5_artist, R.string.art5_year)
        )
    }

    var currentIndex by remember { mutableStateOf(0) }
    val currentArtwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .shadow(elevation = 5.dp)
                .padding(vertical = 45.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(currentArtwork.imageResId),
                contentDescription = stringResource(currentArtwork.title),
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
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(red = 220, green = 220, blue = 220))
                .padding(10.dp)
        ) {
            Row {
                Text(
                    text = stringResource(currentArtwork.title),
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
                            append("${stringResource(currentArtwork.artist)} ")
                        }
                        withStyle(style = SpanStyle(fontSize = 12.sp)
                        ) {
                            append("(${stringResource(currentArtwork.year)})")
                        }
                    }
                )
            }
        }

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
                    onClick = {
                        currentIndex = (currentIndex - 1 + artworks.size) % artworks.size
                    },
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
                    onClick = {
                        currentIndex = (currentIndex + 1) % artworks.size
                    },
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
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}