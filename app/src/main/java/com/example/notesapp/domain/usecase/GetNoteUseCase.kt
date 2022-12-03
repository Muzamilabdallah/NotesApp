package com.example.notesapp.domain.usecase

import com.example.notesapp.data.repository.NoteRepository
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(private val repository: NoteRepository) {
    operator suspend fun  invoke(   )=repository.getNote( )
}