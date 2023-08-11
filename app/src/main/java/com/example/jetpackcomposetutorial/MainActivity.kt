package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ComposeTutorialImage(
                        headline = stringResource(id = R.string.jetpack_compose_tutorial_headline),
                        firstParagraph = stringResource(id = R.string.jetpack_compose_tutorial_first_paragraph),
                        secondParagraph = stringResource(id = R.string.compose_tutorial_second_paragraph)
                    )

                }
            }
        }
    }
}


@Composable
fun ComposeTutorialText(
    headline: String,
    firstParagraph: String,
    secondParagraph: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(12.dp),
    ) {

        Text(
            text = headline,
            modifier = Modifier
                .padding(16.dp),
            fontSize = 24.sp

        )

        Text(
            text = firstParagraph,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )

        Text(
            text = secondParagraph,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )

    }

}
// you created a function that handles the text alone

@Composable
fun ComposeTutorialImage(
    headline: String,
    firstParagraph: String,
    secondParagraph: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.composetutorial)

    Box {
        Column {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(30f / 9f)
            )

            ComposeTutorialText(
                headline = headline,
                firstParagraph = firstParagraph,
                secondParagraph = secondParagraph,
            )
        }

    }
}

// you created a function that handles the image and calls the text function
// however, the use of Box{} here is totally unnecessary; The Box composable is used for
// overlaying or stacking multiple composable on top of each other.
// In your case, you have only one Column inside the Box, which serves
// no additional purpose and can be eliminated.
// IN ADDITION, the extra properties you add for the image like aspectRatio
// and contentScale are totally useless once yu use Column{} instead of Box{}








