package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun addNote(note:Note)
@Update
suspend fun updateNote(note:Note)
@Query("select *from notes order by id asc")
fun getAllNotes():LiveData<List<Note>>

}