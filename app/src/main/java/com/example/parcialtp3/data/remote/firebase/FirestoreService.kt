package com.example.parcialtp3.data.remote.firebase

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirestoreService {

    private val firestore = FirebaseFirestore.getInstance()

    suspend fun getTransactions(): List<Map<String, Any>> {
        val snapshot = firestore
            .collection("transactions")
            .get()
            .await()

        return snapshot.documents.mapNotNull { it.data }
    }
}
