package com.example.notesapp.data.repository

import com.example.notesapp.domain.model.Note

interface NoteRepository {
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
    fun searchNote(text: String): kotlinx.coroutines.flow.Flow<List<Note>>
    fun getNote(): kotlinx.coroutines.flow.Flow<List<Note>>
}