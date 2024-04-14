package kz.hackathon.krcm_36.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.hackathon.krcm_36.R
import kz.hackathon.krcm_36.ui.theme.PrimaryYellow
import kz.hackathon.krcm_36.ui.views.CompanyItem
import org.koin.androidx.compose.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: BankViewModel = get()
) {
    var query by remember { mutableStateOf(TextFieldValue()) }
   // val banksState = viewModel.banksState.collectAsState()
    val companiesState = viewModel.companiesToShowState.collectAsState()
    //viewModel.getBanks()
    //viewModel.getCompanies()
  //  val companiesAfterSearch = viewModel.getCompaniesMap()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
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

        Spacer(modifier = Modifier.size(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(PrimaryYellow),

            ) {
            Row {
                Column(
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = "Save Your",
                        fontFamily = fontFamily,
                        fontSize = 50.sp,
                    )
                    Text(
                        text = "Money",
                        fontFamily = fontFamily,
                        fontSize = 50.sp,
                    )
                    Text(
                        text = "With US",
                        fontFamily = fontFamily,
                        fontSize = 50.sp,
                    )
                }
                //Spacer(modifier = Modifier.size(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.cards),
                    contentDescription = "bank cards",
                    modifier = Modifier
                        .padding(top = 20.dp, end = 20.dp)
                        .size(500.dp)
                        //.border(width = 4.dp, color = Color.Black)
                )


            }
        }

        Column {
            when {
                companiesState.value.loading -> {
                    // Show loading indicator
                }
                companiesState.value.error != null -> {
                    // Show error message
                }
                else -> {
                    companiesState.value.companies?.forEach { company ->
                        CompanyItem(id = company.id, name = company.name){
                            navController.navigate("main/company/${company.name}")
                        }
                    }
                }
            }
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewSearchScreen() {
//    SearchScreen(NavController())
//}

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs

)

val fontName = GoogleFont("Italiana")

val fontFamily = FontFamily(
    Font(
        googleFont = fontName,
        fontProvider = provider,
    )
)
