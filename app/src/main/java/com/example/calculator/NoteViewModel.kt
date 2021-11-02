package com.example.calculator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    private val getAllNotes:List<Note>
    private val repository:NoteRepository

    init{
        val noteDao=NoteDataBase.getDataBase(application).noteDao()
        repository= NoteRepository(noteDao)
        getAllNotes=repository.getAllNotes
    }
        fun addNote(note:Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.addNote(note)
        }
    }
}