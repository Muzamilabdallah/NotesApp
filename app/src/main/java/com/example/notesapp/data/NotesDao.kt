package com.example.notesapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesapp.domain.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(note: Note)

    @Query("SELECT * FROM notes ")
      fun getAll() : LiveData<List<Note>>

//    @Query("SELECT * FROM notes WHERE id IN (:id)")
//    suspend fun loadAllByIds(ids: IntArray): List<Note>

    @Delete
    suspend fun delete(note: Note)
}