package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {
@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun addNote(note:Note)
@Query("select *from notes order by id asc")
fun getAllNotes():LiveData<List<Note>>

}