package kz.hackathon.krcm_36.ui.screens.company

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kz.hackathon.krcm_36.domain.model.Cashback
import kz.hackathon.krcm_36.domain.use_cases.GetBanksUseCase

class CompanyViewModel(
    private val banksUseCase: GetBanksUseCase
) : ViewModel() {

    private val _cashbackState: MutableStateFlow<CashbacksState> = MutableStateFlow(
        CashbacksState()
    )
    val cashbackState: StateFlow<CashbacksState> = _cashbackState

    fun getCashbacks(id: Int){
        viewModelScope.launch {
            _cashbackState.value = _cashbackState.value.copy(loading = true, error = null)
            try {
                val cashbacks = banksUseCase.getCashbacksByCompanyId(id)
                _cashbackState.value = _cashbackState.value.copy(loading = false, cashbacks = cashbacks)
                Log.e("cashbacks in view model", "${_cashbackState.value.cashbacks}")
            } catch (e: Exception) {
                _cashbackState.value = _cashbackState.value.copy(loading = false, error = e)
            }
        }
    }

}

data class CashbacksState(
    val loading: Boolean = false,
    val cashbacks: List<Cashback>? = null,
    val error: Throwable? = null
)


//    init {
//        getCashbacks()
//    }
//
//    fun getCashbacks(){
//        viewModelScope.launch {
//            _cashbacksState.value = _cashbacksState.value.copy(loading = true, error = null)
//            try {
//                val cashbacks = banksUseCase.getCashbacks()
//                _cashbacksState.value = _cashbacksState.value.copy(loading = false, cashbacks = cashbacks)
//                Log.e("cashbacks in view model", "${cashbacksState.value.cashbacks}")
//            } catch (e: Exception) {
//                _cashbacksState.value = _cashbacksState.value.copy(loading = false, error = e)
//            }
//        }
//    }