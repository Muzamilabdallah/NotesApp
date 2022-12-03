package com.example.notesapp.domain.usecase

import com.example.notesapp.data.repository.NoteRepository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(private val repository: NoteRepository) {
    operator   fun  invoke( text: String)=repository.searchNote(text = text)
}