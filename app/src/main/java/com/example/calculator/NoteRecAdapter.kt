package com.example.calculator

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.databinding.NoteItemBinding

class NoteRecAdapter:RecyclerView.Adapter<NoteRecAdapter.NoteHolder>() {
    var noteList=emptyList<Note>()
     lateinit var container:LinearLayout
    class NoteHolder(item:View):RecyclerView.ViewHolder(item){
        val binding=NoteItemBinding.bind(item)

        fun bind(note:Note)=with(binding){
            txtHeader.text=note.header
            txtNote.text= note.contents
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
    return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bind(noteList[position])
val current=noteList[position]
        holder.binding.noteItemLinear.setOnClickListener(){
            val intent=Intent(it.context,NoteAct::class.java)
            intent.putExtra("contents",current.contents)
            intent.putExtra("id",current.id)
            intent.putExtra("header",current.header)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
    fun addNote(note: List<Note>){
        this.noteList=note
notifyDataSetChanged()
    }
}