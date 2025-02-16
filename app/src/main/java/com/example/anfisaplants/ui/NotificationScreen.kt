package com.example.anfisaplants.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.anfisaplants.R
import com.example.anfisaplants.data.DataSource
import com.example.anfisaplants.data.NotificationMessage
import com.example.anfisaplants.ui.theme.AnfisaPlantsTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun NotificationAppBar(
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean,
) {
    TopAppBar(
        title = { Text(stringResource(R.string.notifications_title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = stringResource(R.string.delete_button)
                )
            }
        }
    )
}

@Composable
fun NotificationList(
    modifier: Modifier,
    notifications: List<NotificationMessage>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        notifications.forEach { notification ->
            ListItem(
                headlineContent = {
                    Text(
                        text = notification.message,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                supportingContent = {
                    Text(
                        text = formatDate(notification.createdAt),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },

                trailingContent = {
                    Text(
                        text = formatDate(notification.createdAt),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                //modifier = Modifier.padding(vertical = 4.dp)
            )

        }
    }
}

fun formatDate(timestamp: Long): String {
    val sdf = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
    return sdf.format(Date(timestamp))
}

@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier
) {
    NotificationList(
        modifier = modifier,
        notifications = DataSource.notificationMessages
    )
}

@Preview(showBackground = true)
@Composable
fun NotificationScreen() {
    AnfisaPlantsTheme {
        NotificationScreen(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}