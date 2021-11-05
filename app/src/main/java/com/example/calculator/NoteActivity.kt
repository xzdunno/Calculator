package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
lateinit var nBind:ActivityNoteBinding
lateinit var noteViewModel: NoteViewModel
var id:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nBind= ActivityNoteBinding.inflate(layoutInflater)
        setContentView(nBind.root)
        noteViewModel=ViewModelProvider(this).get(NoteViewModel::class.java)
var c=getIntent().getStringExtra("contents")
        nBind.edTxt.setText(c)
         c=getIntent().getStringExtra("header")
        nBind.edTxtHead.setText(c)
        id=getIntent().getIntExtra("id",0)

    }

    override fun onPause() {
        super.onPause()
        if(nBind.edTxt.text.toString()==""&&nBind.edTxtHead.text.toString()==""){

        }
        else{
            val note=Note(0,nBind.edTxtHead.text.toString(),nBind.edTxt.text.toString())
            noteViewModel.addNote(note)
        }
    }
}