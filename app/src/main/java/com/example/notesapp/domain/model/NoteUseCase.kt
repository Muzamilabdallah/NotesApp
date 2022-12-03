package com.example.notesapp.domain.model

import com.example.notesapp.domain.usecase.DeleteNoteUseCase
import com.example.notesapp.domain.usecase.GetNoteUseCase
import com.example.notesapp.domain.usecase.InsertNoteUseCase
import com.example.notesapp.domain.usecase.SearchNoteUseCase

data class NoteUseCase(
    val insertNoteUseCase: InsertNoteUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val getNoteUseCase: GetNoteUseCase,
    val searchNoteUseCase: SearchNoteUseCase
)
