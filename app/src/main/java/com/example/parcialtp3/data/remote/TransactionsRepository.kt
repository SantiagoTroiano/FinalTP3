package com.example.parcialtp3.data.remote

import com.example.parcialtp3.data.remote.firebase.FirestoreService
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TransactionsRepository @Inject constructor(
    private val firestoreService: FirestoreService
) {

    suspend fun getTransactionsGroupedByMonth(
        typeFilter: String? = null
    ): Map<String, List<Map<String, Any>>> {

        val allTransactions = firestoreService.getTransactions()

        val filtered = if (typeFilter.isNullOrBlank()) {
            allTransactions
        } else {
            allTransactions.filter {
                it["type"]?.toString() == typeFilter
            }
        }

        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        val sorted = filtered.sortedByDescending {
            val dateStr = it["date"]?.toString() ?: "1900-01-01"
            sdf.parse(dateStr)
        }

        val monthFormat = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)

        return sorted.groupBy {
            try {
                val date = sdf.parse(it["date"]?.toString() ?: "")
                monthFormat.format(date ?: Date())
            } catch (e: Exception) {
                "Unknown"
            }
        }
    }
}
