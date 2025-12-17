package com.example.parcialtp3.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3.data.remote.TransactionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val repository: TransactionsRepository
) : ViewModel() {

    private val _transactionsByMonth =
        MutableStateFlow<Map<String, List<Map<String, Any>>>>(emptyMap())
    val transactionsByMonth: StateFlow<Map<String, List<Map<String, Any>>>> =
        _transactionsByMonth

    fun loadTransactions(typeFilter: String?) {
        viewModelScope.launch {
            try {
                _transactionsByMonth.value =
                    repository.getTransactionsGroupedByMonth(typeFilter)
            } catch (e: Exception) {
                _transactionsByMonth.value = emptyMap()
            }
        }
    }
}
