package com.example.calculator

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Note::class],version=1,exportSchema = false)
abstract class NoteDataBase:RoomDatabase() {
abstract fun noteDao():NoteDao
companion object{
    @Volatile
    private var INSTANCE:NoteDataBase?=null
    fun getDataBase(context: Context):NoteDataBase{
        val tempInstance= INSTANCE
        if(tempInstance!=null){
            return tempInstance
        }
        synchronized(this){
            val instance= Room.databaseBuilder(
                context.applicationContext,
                NoteDataBase::class.java,
                "notes"
            ).build()
            INSTANCE=instance
            return instance
        }
    }
}
}