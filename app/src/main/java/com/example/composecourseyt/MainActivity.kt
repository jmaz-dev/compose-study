package com.example.composecourseyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.composecourseyt.ui.HomeScreen
import com.example.composecourseyt.ui.theme.MeditationUIYouTubeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUIYouTubeTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp)
    ) {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.elevatedCardElevation(5.dp)
        ) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.CenterEnd
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors =
                                listOf(Color.Transparent, Color.Black),
                                startY = 320f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp), contentAlignment = Alignment.BottomCenter
                ) {
                    Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }
}

@Composable
fun StylingText() {
    val fontFamily = FontFamily(
        Font(R.font.lexend_bold, FontWeight.Bold),
        Font(R.font.lexend_light, FontWeight.Light),
        Font(R.font.lexend_medium, FontWeight.Medium),
        Font(R.font.lexend_semibold, FontWeight.SemiBold),
        Font(R.font.lexend_thin, FontWeight.Thin),
        Font(R.font.lexend_extralight, FontWeight.ExtraLight),
        Font(R.font.lexend_black, FontWeight.Black),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
            .padding(16.dp)

    ) {
        Text(

            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp
                    )
                ) {
                    append("J")
                }
                append("etpack ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp,
                        textDecoration = (
                                TextDecoration.Underline
                                        + TextDecoration.LineThrough
                                )

                    )

                ) {
                    append("C")
                }
                append("ompose")
            },
            color = Color.White, fontSize = 30.sp,
            style = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                letterSpacing = .3.sp,
                textAlign = TextAlign.End,
                fontStyle = FontStyle.Italic,
            ),


            )
    }
}

@Composable
fun ScaffoldStyling() {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember {
        SnackbarHostState()
    }
    var textState by remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)

        }

    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TextField(value = textState, label = {
                Text(text = "Enter your name")
            }, onValueChange = {
                textState = it
            }
            )
            Spacer(modifier = Modifier.height(4.dp))
            Button(onClick = {
                scope.launch {
                    snackBarHostState.showSnackbar(
                        "Hello $textState",
                        duration = SnackbarDuration.Short,
                        actionLabel = "Close"
                    )
                }
            }

            ) {
                Text(text = "Pls greet me")
            }
        }
    }

}

@Composable
fun StateChange() {
    var colorState by remember {
        mutableStateOf(Color.Red)
    }

    fun updateColor(color: Color) {
        colorState = color
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(
                if (colorState == Color.Yellow) {
                    colorState.copy(red = 1f, green = 0f, blue = 0f, alpha = 1f)
                } else {
                    colorState.copy(alpha = .5f)
                }
            )
            .fillMaxSize()
            .weight(1f)
            .clickable {
                updateColor(
                    Color(
                        red = Random.nextInt(256),
                        green = Random.nextInt(256),
                        blue = Random.nextInt(256),
                        alpha = 255
                    )
                )
            }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(colorState)
        )

    }

}

@Composable
fun Lists() {
    val scrollState = rememberScrollState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(
            listOf("This", "is", "Jetpack", "Compose")
        ) { index, item ->
            Text(
                text =
                if (item.contentEquals("Compose")) {
                    item + " is cool!"
                } else {
                    item
                },
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
//        items(5000){
//            Text(
//                text = "Hello $it!",
//                textAlign = TextAlign.Center,
//                fontWeight = FontWeight.Bold,
//                fontSize = 24.sp,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            )
//        }
    }
}

@Composable
fun ConstraintLayoutStyle() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenbox")
        val redBox = createRefFor("redbox")
        val guideline = createGuidelineFromTop(.3f)


        constrain(greenBox) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            end.linkTo(redBox.start)
            width = Dimension.percent(.4f)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            top.linkTo(guideline)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width = Dimension.percent(.4f)
            height = Dimension.value(100.dp)
        }

        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.SpreadInside)
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenbox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redbox")
        )
    }
}

@Composable
fun SimpleAnimations() {
    var sizeState by remember {
        mutableStateOf(200.dp)
    }
    // Size Animation
    val size by animateDpAsState(
        targetValue = sizeState,
        label = "Increase size",
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )
    // Infinite animation
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 2000
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "background color"
    )
    Box(
        modifier = Modifier
            .size(size)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { sizeState += 40.dp },
            shape = RoundedCornerShape(corner = CornerSize(6.dp))
        ) {
            Text("Increase size")
        }
    }
}

@Composable
fun IndeterminateCircularIndicator() {

    suspend fun loadProgress(updateProgress: (Float) -> Unit) {
        for (i in 1..100) {
            updateProgress(i.toFloat() / 100)
            delay(10)
        }
    }

    var currentProgress by remember { mutableStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope() // Create a coroutine scope

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                loading = false // Reset loading when the coroutine finishes
            }
        }, enabled = !loading) {
            Text("Start loading")
        }

        if (loading) {
            Text(text = currentProgress.toString())
            CircularProgressIndicator(
                progress = { currentProgress },
                strokeCap = StrokeCap.Round,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        IndeterminateCircularIndicator()
    }


}