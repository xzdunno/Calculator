package com.example.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.databinding.NoteItemBinding

class NoteRecAdapter:RecyclerView.Adapter<NoteRecAdapter.NoteHolder>() {
    val noteList=ArrayList<Note>()
    class NoteHolder(item:View):RecyclerView.ViewHolder(item){
        val binding=NoteItemBinding.bind(item)
        fun bind(note:Note)=with(binding){
            txtHeader.text="Заголовок"
            txtNote.text="Дождались меня белые ночи Над простором густых островов… Снова смотрят знакомые очи, И мелькает былое без слов."
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
    return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
    fun addNote(note:Note){
        noteList.add(note)//поменять на получение массива через getAllNotes и засунуть в getItemCount
        notifyDataSetChanged()
    }
}