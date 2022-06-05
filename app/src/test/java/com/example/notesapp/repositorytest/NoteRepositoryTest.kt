package com.example.notesapp.repositorytest

import com.example.notesapp.domain.Note
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
@ExperimentalCoroutinesApi
class NoteRepositoryTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var repostory:FakeNoteDataRepostoryImp
    @Before
    fun  setup(){
        repostory= FakeNoteDataRepostoryImp()
    }
    @Test
    fun insertNote()= runBlocking{
    val note= Note(id = 1, title = "title", content = "content")
        repostory.insertNote(note = note)
        val notes=repostory.getAllNotes()
        assertThat(notes).contains(note)
    }

    @Test
    fun deleteNote()= runBlocking{
    val note= Note(id = 1, title = "title", content = "content")
        repostory.insertNote(note = note)
        repostory.deleteNote(note = note)
        val notes=repostory.getAllNotes()
        assertThat(notes).doesNotContain(note)
    }
}