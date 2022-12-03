package com.example.notesapp.domain.usecase

import com.example.notesapp.data.repository.NoteRepository
import com.example.notesapp.domain.model.Note
import javax.inject.Inject

class SearchNoteUseCase @Inject constructor(private val repository: NoteRepository) {
    operator   fun  invoke( text: String)=repository.searchNote(text = text)
}