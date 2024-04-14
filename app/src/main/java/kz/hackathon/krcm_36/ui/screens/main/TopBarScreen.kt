package kz.hackathon.krcm_36.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kz.hackathon.krcm_36.R
import kz.hackathon.krcm_36.ui.theme.PrimaryYellow
import org.koin.androidx.compose.get

@Composable
fun TopBarScreen(viewModel: BankViewModel = get()){
    var query by remember { mutableStateOf(TextFieldValue()) }
    val companiesState = viewModel.companiesToShowState.collectAsState()

    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
    ) {

        TextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { Text(text = "Search") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(20.dp)),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFE5E7EB),
                focusedContainerColor = Color(0xFFE5E7EB),
                focusedIndicatorColor = Color(0xFFE5E7EB),
                unfocusedIndicatorColor = Color(0xFFE5E7EB)
            ),
            leadingIcon = {
                IconButton(
                    onClick = {viewModel.getCompaniesByName(query.text)},
                    modifier = Modifier.align(Alignment.Top)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search",
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.Top)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = "Search",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

        )

        Spacer(modifier = Modifier.size(12.dp))

        IconButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.Top)
                .padding(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_login),
                contentDescription = "Search",
                tint = PrimaryYellow,
                modifier = Modifier.size(32.dp)
            )
        }

    }
}