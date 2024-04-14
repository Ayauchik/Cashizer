package kz.hackathon.krcm_36.ui.screens.main
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kz.hackathon.krcm_36.domain.model.Bank
import kz.hackathon.krcm_36.domain.model.Company
import kz.hackathon.krcm_36.domain.use_cases.GetBanksUseCase

class BankViewModel(private val getBanksUseCase: GetBanksUseCase) : ViewModel() {

    private val _banksState: MutableStateFlow<BanksState> = MutableStateFlow(BanksState())
    val banksState: StateFlow<BanksState> = _banksState

    private val _companiesToShowState: MutableStateFlow<CompaniesState> =
        MutableStateFlow(CompaniesState())
    val companiesToShowState: StateFlow<CompaniesState> = _companiesToShowState

    init {
        // getBanks()
        getCompanies()
    }

    fun getBanks() {
        viewModelScope.launch {
            _banksState.value = _banksState.value.copy(loading = true, error = null)
            try {
                val banks = getBanksUseCase.getBanks()
                _banksState.value = _banksState.value.copy(loading = false, banks = banks)
            } catch (e: Exception) {
                _banksState.value = _banksState.value.copy(loading = false, error = e)
            }
        }
    }

    fun getCompanies() {
        viewModelScope.launch {
            _companiesToShowState.value = _companiesToShowState.value.copy(loading = true, error = null)
            try {
                val companies = getBanksUseCase.getCompanies()
                _companiesToShowState.value =
                    _companiesToShowState.value.copy(loading = false, companies = companies)
            } catch (e: Exception) {
                _companiesToShowState.value = _companiesToShowState.value.copy(loading = false, error = e)
            }
        }
    }

    fun getCompaniesByName(name: String){
        viewModelScope.launch {
            _companiesToShowState.value = _companiesToShowState.value.copy(loading = true, error = null)
            try {
                val companies = getBanksUseCase.getCompaniesByName(name)
                _companiesToShowState.value =
                    _companiesToShowState.value.copy(loading = false, companies = companies)
            } catch (e: Exception) {
                _companiesToShowState.value = _companiesToShowState.value.copy(loading = false, error = e)
            }
        }
    }


}

data class BanksState(
    val loading: Boolean = false,
    val banks: List<Bank>? = null,
    val error: Throwable? = null
)

data class CompaniesState(
    val loading: Boolean = false,
    val companies: List<Company>? = null,
    val error: Throwable? = null
)
