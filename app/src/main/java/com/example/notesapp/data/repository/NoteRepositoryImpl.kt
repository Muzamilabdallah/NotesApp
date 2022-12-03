package com.example.notesapp.data.repository

import com.example.notesapp.data.NotesDao
import com.example.notesapp.domain.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named

class NoteRepositoryImpl @Inject constructor(@Named("doa") private  val notesDao: NotesDao) : NoteRepository{
    override suspend fun insertNote(note: Note) {
         notesDao.insertAll(note = note)
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun searchNote(text: String): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun getNote(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

}