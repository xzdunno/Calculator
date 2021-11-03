package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.databinding.ActivityNoteBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

class NoteActivity : AppCompatActivity() {
    lateinit var nBind:ActivityNoteBinding
    private val recAdapter=NoteRecAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nBind= ActivityNoteBinding.inflate(layoutInflater)
        setContentView(nBind.root)
        nBind.colTool.setExpandedTitleColor(resources.getColor(R.color.black))
        nBind.appBarLayout.setExpanded(false)
        init()
    }
    private fun init(){
        nBind.apply {
            noteRecycler.layoutManager=GridLayoutManager(this@NoteActivity,2)
            noteRecycler.adapter=recAdapter
            addNoteBtn.setOnClickListener(){
                var id=0
                val note=Note(id,"12","34")
                recAdapter.addNote(note)
                id++
            }
        }
    }
}