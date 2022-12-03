package com.example.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.domain.model.Note

@Database(entities = [Note::class], version = 1
)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}
