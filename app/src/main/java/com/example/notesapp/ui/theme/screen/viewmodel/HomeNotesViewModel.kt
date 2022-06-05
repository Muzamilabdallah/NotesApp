package com.example.notesapp.ui.theme.screen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.NotesDao
import com.example.notesapp.domain.Note
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeNotesViewModel    : ViewModel() {

    init {
//        insertNote()
    }

//    private fun insertNote() {
//        val note = Note(title = "kotlin", content = "kotil is prossssssgramming lanague ")
//        viewModelScope.launch {
//            notesDao.insertAll(note = note)
//            val notevalue=notesDao.getAll()
//
//            Log.d("TAG", "insertNote: "+notevalue.value)
//        }
//    }
}