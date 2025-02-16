package com.example.anfisaplants.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.anfisaplants.R
import com.example.anfisaplants.data.DataSource
import com.example.anfisaplants.ui.theme.AnfisaPlantsTheme

@Composable
fun PlantsGrid(
    modifier: Modifier
) {
    val items = DataSource.appItems

    Column(modifier = modifier.padding(dimensionResource(R.dimen.padding_small))) {
        for (i in items.indices step 4) { // Шаг 4 для 4 колонок
            Row {
                for (j in 0 until 4) {
                    if (i + j < items.size) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(dimensionResource(R.dimen.padding_small))
                                //.fillMaxWidth()
                                .weight(1f)
                        ) {
                            val item = DataSource.appItems[i + j]
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                            Text(
                                text = item.label,
                                style = MaterialTheme.typography.labelMedium,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun StartScreenBottomBar(
    onNotificationsClick: () -> Unit
) {
    BottomAppBar(
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = stringResource(R.string.delete_button)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.AcUnit,
                    contentDescription = stringResource(R.string.cold_button)
                )
            }
            IconButton(onClick = onNotificationsClick) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = stringResource(R.string.notifications_title)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, stringResource(R.string.add_button))
            }
        },

        )
}

@Composable
fun StartScreen(
    modifier: Modifier = Modifier
) {
    PlantsGrid(
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    AnfisaPlantsTheme {
        StartScreen(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
