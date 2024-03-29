package com.example.notesapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "notes")
data class Note(@PrimaryKey(autoGenerate = false) val id:Int=0, val title:String, val content:String)
