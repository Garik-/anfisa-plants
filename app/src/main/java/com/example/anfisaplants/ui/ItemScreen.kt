package com.example.anfisaplants.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.anfisaplants.ui.theme.AnfisaPlantsTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

import com.example.anfisaplants.R

@Composable
fun TestCom () {
    Text(
        text="Представители Аралиевых с достаточно покладистым нравом. Они предъявляют не столь много требований к условиям и легко справляются с промахами в уходе, но боятся сырости. Внешность у шеффлеры яркая и н",
        style =MaterialTheme.typography.bodyMedium
    )
}

/**
 * A custom Composable for creating a tabbed interface.
 *
 * @param tabs List of tab titles.
 * @param contentScreens List of Composable functions representing content screens for each tab.
 * @param modifier Modifier for the parent layout.
 * @param containerColor Background color for the tab row container.
 * @param contentColor Color for the text content of the tabs.
 * @param indicatorColor Color for the indicator line.
 */
@Composable
fun TabRowComponent(
    tabs: List<String>,
    contentScreens: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier,

) {
    // State to keep track of the selected tab index
    var selectedTabIndex  by remember { mutableIntStateOf(0) }

    // Column layout to arrange tabs vertically and display content screens
    Column(modifier = modifier.fillMaxSize()) {
        // TabRow composable to display tabs
        TabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                // Indicator for the selected tab
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                )
            }
        ) {
            // Iterate through each tab title and create a tab
            tabs.forEachIndexed { index, tabTitle ->
                Tab(
                    modifier = Modifier.padding(all = 16.dp),
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                ) {
                    // Text displayed on the tab
                    Text(text = tabTitle)
                }
            }
        }

        // Display the content screen corresponding to the selected tab
        contentScreens.getOrNull(selectedTabIndex)?.invoke()
    }
}

@Composable
fun ItemScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.plant),
            contentDescription = "Описание изображения",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),

            contentScale = ContentScale.FillBounds
        )

        Column(
                    modifier = Modifier

                        .padding(16.dp)

        ) {

            ListItem(
                headlineContent = {
                    Text(
                        text = "Когда посадила",
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                supportingContent = {
                    Text(
                        text = "05.2025",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
            )

            ListItem(
                headlineContent = {
                    Text(
                        text = "Обьем горшка",
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                supportingContent = {
                    Text(
                        text = "02л",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
            )

            ListItem(
                headlineContent = {
                    Text(
                        text = "Освещение",
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                supportingContent = {
                    Text(
                        text = "С-3",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
            )

            Text(
                text="Представители Аралиевых с достаточно покладистым нравом. Они предъявляют не столь много требований к условиям и легко справляются с промахами в уходе, но боятся сырости. Внешность у шеффлеры яркая и н",
                style =MaterialTheme.typography.bodyMedium
            )



        }

        // List of tab titles
        val tabs = listOf("Зима", "Лето")

        // Display the TabRowComponent with specified tabs and content screens
        TabRowComponent(
            tabs = tabs,
            contentScreens = listOf(
                { TestCom() },  // Content screen for Tab 1
                { TestCom() },      // Content screen for Tab 2
            ),
            modifier = Modifier.fillMaxSize(),

        )

    }
}

@Preview(showBackground = true)
@Composable
fun ItemScreen() {
    AnfisaPlantsTheme {
        ItemScreen(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}