package kz.hackathon.krcm_36.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyItem(
    id: Int,
    name: String,
    navController: NavController
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        onClick = {navController.navigate("company/$id")}
    ) {
        Column {
            Text(text = "ID: $id")
            Text(text = "Name: $name")
        }
    }
}