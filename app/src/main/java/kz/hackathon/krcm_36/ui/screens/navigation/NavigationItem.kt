package kz.hackathon.krcm_36.ui.screens.navigation

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter

data class NavigationItem(
    val title: String,
    val selectedIcon: Any,
    val unselectedIcon: Any? = null,
    val bagCount: Int? = null
) {
    val isSelectedIconImageVector: Boolean
        get() = selectedIcon is ImageVector

    val isSelectedIconPainter: Boolean
        get() = selectedIcon is Painter
}
