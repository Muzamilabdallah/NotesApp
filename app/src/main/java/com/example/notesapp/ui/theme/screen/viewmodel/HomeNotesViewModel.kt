package com.example.notesapp.ui.theme.screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.model.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeNotesViewModel @Inject constructor(private val noteUseCase: NoteUseCase) : ViewModel() {


    fun getAllNotes() = viewModelScope.launch {
        noteUseCase.getNoteUseCase
    }



    fun hanldeNoteAction(noteEvent: NoteEvent) {
        viewModelScope.launch {
            when (noteEvent) {
                is NoteEvent.Insert -> {
                    insertNote(noteEvent.note)
                }
                is NoteEvent.Delete -> {
                    deleteNote(noteEvent.note)
                }

                is NoteEvent.Search -> {
                    searchNote(noteEvent.txt)
                }

            }
        }
    }

    fun insertNote(note: Note) =
        viewModelScope.launch { noteUseCase.insertNoteUseCase.invoke(note) }

    fun deleteNote(note: Note) =
        viewModelScope.launch { noteUseCase.deleteNoteUseCase.invoke(note) }

    fun searchNote(text: String) =
        viewModelScope.launch { noteUseCase.searchNoteUseCase.invoke(text) }


}


sealed class NoteEvent {
    data class Insert(val note: Note) : NoteEvent()
    data class Delete(val note: Note) : NoteEvent()
    data class Search(val txt: String) : NoteEvent()
}