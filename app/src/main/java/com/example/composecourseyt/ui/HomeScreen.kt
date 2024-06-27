package com.example.composecourseyt.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.composecourseyt.R
import com.example.composecourseyt.classes.BottomMenu
import com.example.composecourseyt.classes.Feature
import com.example.composecourseyt.classes.IconName
import com.example.composecourseyt.ui.theme.AquaBlue
import com.example.composecourseyt.ui.theme.Beige1
import com.example.composecourseyt.ui.theme.Beige2
import com.example.composecourseyt.ui.theme.Beige3
import com.example.composecourseyt.ui.theme.BlueViolet1
import com.example.composecourseyt.ui.theme.BlueViolet2
import com.example.composecourseyt.ui.theme.BlueViolet3
import com.example.composecourseyt.ui.theme.ButtonBlue
import com.example.composecourseyt.ui.theme.DarkerButtonBlue
import com.example.composecourseyt.ui.theme.DeepBlue
import com.example.composecourseyt.ui.theme.LightGreen1
import com.example.composecourseyt.ui.theme.LightGreen2
import com.example.composecourseyt.ui.theme.LightGreen3
import com.example.composecourseyt.ui.theme.LightRed
import com.example.composecourseyt.ui.theme.OrangeYellow1
import com.example.composecourseyt.ui.theme.OrangeYellow2
import com.example.composecourseyt.ui.theme.OrangeYellow3
import com.example.composecourseyt.ui.theme.Shapes
import com.example.composecourseyt.ui.theme.TextWhite

private val cardIcons = listOf(
    IconName(
        R.drawable.ic_videocam,
        "videocam"
    ),
    IconName(
        R.drawable.ic_headphone,
        "headphone",
    )
)

@Composable
fun HomeScreen() {
    val chipList = listOf("Sweet sleep", "Insomnia", "Depression")
    val cards = listOf(
        Feature(
            title = "Sleep meditation",
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        Feature(
            title = "Tips for sleeping",
            LightGreen1,
            LightGreen2,
            LightGreen3
        ),
        Feature(
            title = "Night island",
            OrangeYellow1,
            OrangeYellow2,
            OrangeYellow3
        ),
        Feature(
            title = "Calming sounds",
            Beige1,
            Beige2,
            Beige3
        )

    )

    val bottomMenu = listOf(
        BottomMenu(
            "Home",
            R.drawable.ic_home
        ),
        BottomMenu(
            "Meditate",
            R.drawable.ic_bubble
        ),
        BottomMenu(
            "Sleep",
            R.drawable.ic_moon
        ),
        BottomMenu(
            "Music",
            R.drawable.ic_music
        ),
        BottomMenu(
            "Profile",
            R.drawable.ic_profile

        )
    )

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()

    ) {
        Column(Modifier.align(Alignment.TopCenter)) {
            GreetingSection("João")
            ChipSection(chipList)
            CurrentMedia()
            FeaturedSection(cards)
        }
        BottomMenu(bottomMenu, Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun GreetingSection(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically
    ) {
        Column(Modifier.padding(0.dp, 16.dp, 0.dp)) {
            Text(

                text = "Good Morning, $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                modifier = Modifier.padding(0.dp, 4.dp, 0.dp),
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )

        }
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable(
                    onClick = { /*TODO*/ },
                    enabled = true
                ),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
            contentDescription = "Localized description",
            tint = TextWhite,
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selected by remember { mutableStateOf(false) }
    var selectedChipIndex by remember { mutableStateOf(0) }
    LazyRow {
        items(chips.size) { index ->
            FilterChip(
                modifier = Modifier.padding(15.dp, 15.dp, 0.dp),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = DarkerButtonBlue,
                    labelColor = TextWhite,
                    selectedContainerColor = ButtonBlue,
                    selectedLabelColor = TextWhite
                ),
                onClick = {
                    selectedChipIndex = index
                },
                label = {
                    Text(chips[index], modifier = Modifier.padding(3.dp, 15.dp))
                },
                selected = selectedChipIndex == index,
                leadingIcon = if (selected) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                },
            )
        }
    }
}

@Composable
fun CurrentMedia() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp, 32.dp), horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .background(LightRed, shape = MaterialTheme.shapes.small)
                .fillMaxWidth()
                .padding(15.dp, 24.dp),
            Arrangement.SpaceBetween,
            Alignment.CenterVertically


        ) {
            Column {
                Text(
                    text = "Daily Thought",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
                Text(text = "Meditation: 3-10 min", style = MaterialTheme.typography.body2)
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable(
                        onClick = { /*TODO*/ },
                        enabled = true,
                    )
                    .background(
                        ButtonBlue
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Icon(

                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_play),
                    contentDescription = "Play",
                    tint = TextWhite,
                    modifier = Modifier
                        .size(16.dp)

                )
            }
        }
    }
}

@Composable
fun FeaturedSection(features: List<Feature>) {

    Column(modifier = Modifier.padding(bottom = 120.dp)) {
        Text(
            "Featured",
            Modifier.padding(15.dp, 8.dp, 0.dp, 8.dp),
            style = MaterialTheme.typography.h1
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(7.5.dp, 7.5.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }

}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(Shapes.small)
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.fillMaxWidth(0.94f)
            )
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = (
                            if (feature.title.contains("Tips")) {
                                cardIcons[0].image
                            } else
                                cardIcons[1].image
                            )
                ), contentDescription = (
                        if (feature.title.contains("Tips")) {
                            cardIcons[0].name
                        } else
                            cardIcons[1].name
                        ),
                tint = TextWhite,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Box(
                modifier = Modifier
                    .size(60.dp, 30.dp)
                    .clip(Shapes.small)
                    .background(ButtonBlue)
                    .clickable(
                        onClick = { /*TODO*/ },
                        enabled = true,
                    )
                    .align(Alignment.BottomEnd),
                contentAlignment = Alignment.Center

            ) {
                Text(text = "Start", style = MaterialTheme.typography.body2)
            }
        }

    }
}

@Composable
fun BottomMenu(items: List<BottomMenu>, modifier: Modifier = Modifier) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, bottomMenu ->
            BottomMenuItem(bottomMenu)
        }

    }

}

@Composable
fun BottomMenuItem(item: BottomMenu) {
    Box(
        modifier = Modifier

    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = item.icon),
            contentDescription = item.title,
            tint = AquaBlue
        )
        Text(text = item.title)
    }
}


//    LazyColumn {
//        items(features.size / 2) { index ->
//            Row(
//                Modifier
//                    .fillMaxWidth()
//                    .padding(15.dp)
//            ) {
//
//                Box(
//                    modifier = Modifier
//                        .weight(1f)
//                        .clip(Shapes.small)
//                        .background(color = Beige1)
//
//
//                ) {
//                    Column(modifier = Modifier.padding(16.dp), Arrangement.SpaceBetween) {
//
//                        Text(
//                            text = features[index * 2].title,
//                            style = MaterialTheme.typography.h2,
//                            modifier = Modifier
//                                .padding(0.dp, 0.dp, 0.dp, 77.dp)
//                                .fillMaxWidth(.9f)
//                        )
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            Arrangement.SpaceBetween,
//                            Alignment.CenterVertically
//                        ) {
//                            Icon(
//
//                                imageVector = ImageVector.vectorResource(
//                                    id = (
//                                            if (features[index * 2].title.contains("Tips")) {
//                                                cardIcons[0].image
//                                            } else {
//                                                cardIcons[1].image
//                                            }
//                                            )
//                                ), contentDescription = (
//                                        if (features[index * 2].title.contains("Tips")) {
//                                            cardIcons[0].name
//                                        } else {
//                                            cardIcons[1].name
//                                        }
//                                        ), tint = TextWhite
//                            )
//                            Box(
//                                modifier = Modifier
//                                    .size(60.dp, 30.dp)
//                                    .clip(Shapes.small)
//                                    .background(ButtonBlue)
//                                    .clickable(
//                                        onClick = { /*TODO*/ },
//                                        enabled = true,
//                                    ),
//                                contentAlignment = Alignment.Center
//
//                            ) {
//                                Text(text = "Start", style = MaterialTheme.typography.body2)
//                            }
//                        }
//
//                    }
//                }
//                Spacer(modifier = Modifier.size(15.dp))
//                Box(
//                    modifier = Modifier
//                        .weight(1f)
//                        .clip(Shapes.small)
//                        .background(color = Beige1)
//
//                ) {
//                    Column(modifier = Modifier.padding(16.dp), Arrangement.SpaceBetween) {
//
//                        Text(
//                            text = features[index * 2 + 1].title,
//                            style = MaterialTheme.typography.h2,
//                            modifier = Modifier
//                                .padding(0.dp, 0.dp, 0.dp, 77.dp)
//                                .fillMaxWidth(.9f)
//                        )
//
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            Arrangement.SpaceBetween,
//                            Alignment.CenterVertically
//                        ) {
//                            Icon(
//
//                                imageVector = ImageVector.vectorResource(
//                                    id = (
//                                            if (features[index * 2].title.contains("Tips")) {
//                                                cardIcons[0].image
//                                            } else {
//                                                cardIcons[1].image
//                                            }
//                                            )
//                                ), contentDescription = (
//                                        if (features[index * 2].title.contains("Tips")) {
//                                            cardIcons[0].name
//                                        } else {
//                                            cardIcons[1].name
//                                        }
//                                        ), tint = TextWhite
//                            )
//                            Box(
//                                modifier = Modifier
//                                    .size(60.dp, 30.dp)
//                                    .clip(Shapes.small)
//                                    .background(ButtonBlue)
//                                    .clickable(
//                                        onClick = { /*TODO*/ },
//                                        enabled = true,
//                                    ),
//                                contentAlignment = Alignment.Center
//
//                            ) {
//                                Text(text = "Start", style = MaterialTheme.typography.body2)
//                            }
//                        }
//
//
//                    }
//                }
//
//            }
//
//        }
//    }