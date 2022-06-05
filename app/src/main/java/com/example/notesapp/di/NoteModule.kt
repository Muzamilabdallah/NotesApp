package com.example.notesapp.di

import android.content.Context
import androidx.room.Room
import com.example.notesapp.data.NotesDao
import com.example.notesapp.data.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    @Named("note_db")
    fun providesNotesDb(@ApplicationContext context: Context): NotesDatabase =
        Room.inMemoryDatabaseBuilder(context, NotesDatabase::class.java).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun  provideNotesDao(notesDatabase: NotesDatabase):NotesDao{
        return  notesDatabase.notesDao()
    }
}