package com.example.notesapp.domain.usecase

import com.example.notesapp.data.repository.NoteRepository
import com.example.notesapp.domain.model.Note
import javax.inject.Inject

class InsertNoteUseCase @Inject constructor(private val repository: NoteRepository) {
    operator suspend fun  invoke( note: Note)=repository.insertNote(note = note)
}