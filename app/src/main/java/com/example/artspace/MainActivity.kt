package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
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
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 50.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
        ) {
            ArtImage()
        }
        Row {
            ArtTitleAndDesc("Artwork Title", "Artwork Artist", "Year")
        }
        Row {
            NavButton()
        }
    }
}

@Composable
fun ArtImage() {
    Image(
        painter = painterResource(
            id = R.drawable.ic_launcher_background),
        contentDescription = null
    )
}

@Composable
fun ArtTitleAndDesc(
    title: String,
    artist: String,
    year: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = title,
                modifier = Modifier
                    .wrapContentWidth()
            )
        }
        Row {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 12.sp)) {
                        append("$artist (")
                    }
                    withStyle(style = SpanStyle(
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic)) {
                        append(year)
                    }
                    withStyle(style = SpanStyle(fontSize = 12.sp)) {
                        append(")")
                    }
                }
            )
        }
    }
}

@Composable
fun NavButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(10.dp)
            .size(width = 150.dp, height = 35.dp)
    ) {
        Text(
            text = "Previous"
        )
    }
    Button(
        onClick = {},
        modifier = Modifier
            .padding(10.dp)
            .size(width = 250.dp, height = 35.dp)
    ) {
        Text(
            text = "Next"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}