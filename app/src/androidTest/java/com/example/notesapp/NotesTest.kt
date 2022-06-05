package com.example.notesapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.notesapp.data.NotesDao
import com.example.notesapp.data.NotesDatabase
import com.example.notesapp.domain.Note
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest
@RunWith(AndroidJUnit4::class)
class NotesTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("note_db")
    lateinit var notesDatabase: NotesDatabase
    lateinit var notesDao: NotesDao

    @Before
    fun setup() {
        hiltRule.inject()
         notesDao = notesDatabase.notesDao()
    }

    @Test
    @Throws(Exception::class)
    fun insertNote() = runTest {
        val note = Note(id=2,title = "kotlin", content = "kotil is prosgramming lanague ")
        notesDao.insertAll(note = note)
        val allnotes = notesDao.getAll().getOrAwaitValue()
        assertThat(allnotes).contains(note)
    }

    @Test
    @kotlin.jvm.Throws(Exception::class)
    fun deleteNote()= runTest {
        val note = Note(id=3,title = "java", content = "java is prosgramming lanague ")
        notesDao.insertAll(note = note)
        notesDao.delete(note)
        val allnotes = notesDao.getAll().getOrAwaitValue()
        assertThat(allnotes).doesNotContain(note)
    }

    @Test
    fun getALlNotes()= runTest {
        val note = Note(id=4,title = "c#", content = "c# is prosgramming lanague ")
            notesDao.insertAll(note = note)
        val allnotes = notesDao.getAll().getOrAwaitValue()
        assertThat(allnotes).isNotEmpty()

    }
    @Test
    fun updateNotes()= runTest {
        val note = Note(id=4,title = "c#", content = "c# is prosgramming lanague ")
        notesDao.insertAll(note = note)
        val allnotes = notesDao.getAll().getOrAwaitValue()
        assertThat(allnotes).contains(note)

    }



    @After
    fun tearDown() {
        notesDatabase.close()
    }
}