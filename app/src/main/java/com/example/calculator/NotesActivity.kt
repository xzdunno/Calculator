package com.example.calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.example.calculator.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {
    lateinit var nBind:ActivityNotesBinding
    private lateinit var noteViewModel:NoteViewModel
    private val recAdapter=NoteRecAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nBind= ActivityNotesBinding.inflate(layoutInflater)
        setContentView(nBind.root)
        nBind.colTool.setExpandedTitleColor(resources.getColor(R.color.black))
        nBind.appBarLayout.setExpanded(false)
val adapter=NoteRecAdapter()
        val recyclerView=nBind.noteRecycler
        recyclerView.adapter=adapter
        recyclerView.layoutManager=GridLayoutManager(this@NotesActivity,2)
        noteViewModel=ViewModelProvider(this).get(NoteViewModel::class.java)
        noteViewModel.getAllNotes.observe(this, Observer {note->
            adapter.addNote(note)

        })
        //init()
    }

    override fun onResume() {
        super.onResume()

            nBind.addNoteBtn.setOnClickListener(){
                /*var id=0
                val note=Note(id,"12","34")
                recAdapter.addNote(note)
                id++*/
                val intent= Intent(this, NoteActivity::class.java)
                startActivity(intent)
            }
        //}
    }}
//}