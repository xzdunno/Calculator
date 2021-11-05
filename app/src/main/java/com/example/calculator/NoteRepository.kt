package com.example.calculator

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    val getAllNotes: LiveData<List<Note>> =noteDao.getAllNotes()
            suspend fun addNote(note:Note){
                noteDao.addNote(note)
            }
    suspend fun updateNote(note:Note){
        noteDao.updateNote(note)
    }
}