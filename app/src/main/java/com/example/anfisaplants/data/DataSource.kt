package com.example.anfisaplants.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class PlantItem(
    val icon: ImageVector, // Иконка
    val label: String // Подпись
)

data class NotificationMessage(
    var createdAt: Long,
    var message: String
)

object DataSource {
    val appItems = listOf(
        PlantItem(Icons.Filled.Home, "Монстера"),
        PlantItem(Icons.Filled.Search, "Фикус Лирата"),
        PlantItem(Icons.Filled.Favorite, "Сансевиерия"),
        PlantItem(Icons.Filled.Settings, "Эпипремнум"),
        PlantItem(Icons.Filled.Person, "Алоэ Вера"),
        PlantItem(Icons.Filled.Email, "Хлорофитум")
        // PlantItem(Icons.Filled.Phone, "Phone"),
        // PlantItem(Icons.Filled.Info, "Info")
    )

    var notificationMessages = listOf(
        NotificationMessage(System.currentTimeMillis(), "test") ,
        NotificationMessage(System.currentTimeMillis(), "test2")
    )
}