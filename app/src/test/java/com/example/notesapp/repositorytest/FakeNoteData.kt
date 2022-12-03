package com.example.notesapp.repositorytest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.notesapp.domain.model.Note

class FakeNoteDataRepostoryImp : NotesRepositroy {
    val list = mutableListOf<Note>()
    val noteList = MutableLiveData<List<Note>>()


    override suspend fun updateNote(index: Int, note: Note) {
        list.set(index = index, note)
    }

    fun getAllNotes(): List<Note> = list
    override suspend fun insertNote(note: Note) {
        list.add(note)
    }

    override suspend fun deleteNote(note: Note) {
        list.remove(note)
    }


    override suspend fun getNote(): LiveData<List<Note>> {
        return noteList
    }

    fun refreshData() {
        noteList.postValue(list)
    }

}