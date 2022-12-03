package com.example.notesapp.repositorytest

import androidx.lifecycle.LiveData
import com.example.notesapp.domain.model.Note

interface NotesRepositroy {
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun updateNote(index:Int,note: Note)
    suspend fun getNote():LiveData<List<Note>>
}