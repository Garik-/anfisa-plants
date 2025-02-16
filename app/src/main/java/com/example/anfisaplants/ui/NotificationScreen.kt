package com.example.anfisaplants.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.anfisaplants.data.DataSource
import com.example.anfisaplants.data.NotificationMessage
import com.example.anfisaplants.ui.theme.AnfisaPlantsTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun NotificationList(notifications: List<NotificationMessage>) {
    Column(
        modifier = Modifier
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

val sdf = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
fun formatDate(timestamp: Long): String {
    return sdf.format(Date(timestamp))
}

@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier
) {
    NotificationList(notifications = DataSource.notificationMessages)
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