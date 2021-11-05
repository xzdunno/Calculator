package com.example.calculator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    val getAllNotes:LiveData<List<Note>>
    private val repository:NoteRepository

     init{
        val noteDao=NoteDataBase.getDataBase(application).noteDao()
        repository= NoteRepository(noteDao)
        getAllNotes=repository.getAllNotes
    }
        fun addNote(note:Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.addNote(note)
        }}
            fun updateNote(note:Note){
                viewModelScope.launch(Dispatchers.IO){
                    repository.updateNote(note)
                }
    }
}