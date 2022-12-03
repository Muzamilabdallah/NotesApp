package com.example.notesapp.di

import android.content.Context
import androidx.room.Room
import com.example.notesapp.data.NotesDao
import com.example.notesapp.data.NotesDatabase
import com.example.notesapp.data.repository.NoteRepository
import com.example.notesapp.data.repository.NoteRepositoryImpl
import com.example.notesapp.domain.model.NoteUseCase
import com.example.notesapp.domain.usecase.DeleteNoteUseCase
import com.example.notesapp.domain.usecase.GetNoteUseCase
import com.example.notesapp.domain.usecase.InsertNoteUseCase
import com.example.notesapp.domain.usecase.SearchNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NoteModule {

    @Singleton
    @Provides
    @Named("note_db_testing")
    fun providesNotesDbTesting(@ApplicationContext     context: Context): NotesDatabase =
        Room.inMemoryDatabaseBuilder(context, NotesDatabase::class.java).allowMainThreadQueries()
            .build()


    @Singleton
    @Provides
    @Named("note_db")
    fun providesNotesDb(@ApplicationContext     context: Context): NotesDatabase =
        Room.inMemoryDatabaseBuilder(context, NotesDatabase::class.java)
            .build()



    @Singleton
    @Provides
    @Named("testinng_doa")
    fun provideNotesDaotest(@Named("note_db_testing") notesDatabase: NotesDatabase): NotesDao {
        return notesDatabase.notesDao()
    }


    @Singleton
    @Provides
    @Named("doa")
    fun provideNotesDao(@Named("note_db") notesDatabase: NotesDatabase): NotesDao {
        return notesDatabase.notesDao()
    }




    @Provides
    fun provideNoteRepositroy(@Named("doa") notesDao: NotesDao): NoteRepository {
        return NoteRepositoryImpl(notesDao = notesDao)
    }


    @Provides
    fun provideInsertUseCase(noteRepository: NoteRepository) = InsertNoteUseCase(noteRepository)

    @Singleton
    @Provides
    fun provideDeleteUseCase(noteRepository: NoteRepository) = DeleteNoteUseCase(noteRepository)

    @Singleton
    @Provides
    fun provideGetUseCase(noteRepository: NoteRepository) = GetNoteUseCase(noteRepository)

    @Singleton
    @Provides
    fun provideSearchUseCase(noteRepository: NoteRepository) = SearchNoteUseCase(noteRepository)

    @Singleton
    @Provides
    fun provideAllNoteUseCase(
        insertNoteUseCase: InsertNoteUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        getNoteUseCase: GetNoteUseCase,
        searchNoteUseCase: SearchNoteUseCase
    ) = NoteUseCase(insertNoteUseCase, deleteNoteUseCase, getNoteUseCase, searchNoteUseCase)


}