package kz.hackathon.krcm_36.ui.screens.company

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kz.hackathon.krcm_36.ui.theme.PrimaryYellow
import kz.hackathon.krcm_36.ui.views.CashbackModel
import kz.hackathon.krcm_36.ui.views.CompanyItem
import org.koin.androidx.compose.get

@Composable
fun CompanyScreen(
    id: Int,
    viewModel: CompanyViewModel = get()
    // name: String
) {
    val cashbacksState = viewModel.cashbackState.collectAsState()
    //viewModel.getCashbacks(id)

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column() {
            Text(text = id.toString(), fontSize = 30.sp)
            Button(
                onClick = {
                    viewModel.getCashbacks(id)
                    Log.e("cashbcasks", "${cashbacksState.value.cashbacks}")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryYellow
                )
            ) {
                Text(text = "Analyze")
            }

            Column {
                when {
                    cashbacksState.value.loading -> {}

                    cashbacksState.value.error != null -> {}

                    else -> {
                        cashbacksState.value.cashbacks?.forEach { cashback ->
                            CashbackModel(
                                name = cashback.bankCard.bank.name,
                                percent = cashback.percent
                            )
                        }
                    }
                }
            }


        }

    }
}