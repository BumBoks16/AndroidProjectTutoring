package com.example.vkr

import android.app.LauncherActivity.ListItem
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkr.database.MainDb
import com.example.vkr.entity.Record
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainDb: MainDb
): ViewModel() {

    val records = mutableStateOf(emptyList<Record>())

    fun searchRecordsByKeyword(searchKeyword: String) = viewModelScope.launch {
        records.value = mainDb.dao.searchRecordsByKeyword(searchKeyword)
    }


    fun insert(record: Record) = viewModelScope.launch {
        mainDb.dao.insert(record)
    }


}