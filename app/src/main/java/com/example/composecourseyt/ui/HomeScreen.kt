package com.example.composecourseyt.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.composecourseyt.R
import com.example.composecourseyt.ui.theme.DeepBlue
import com.example.composecourseyt.ui.theme.TextWhite

@Composable
fun HomeScreen(chipList: List<String>) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {

            GreetingSection("João")
            ChipSection(chipList)
        }
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
        Column {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )

        }
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
            contentDescription = "Localized description",
            tint = TextWhite,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selected by remember { mutableStateOf(false) }
    var selectedChipIndex by remember { mutableStateOf(0) }
    LazyRow {
        items(chips.size) {
            Box(modifier = Modifier.padding(15.dp, 15.dp, 0.dp)) {
                FilterChip(

                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = { selectedChipIndex = it },
                    label = {
                        Text(chips[it])
                    },
                    selected = selected,
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
}