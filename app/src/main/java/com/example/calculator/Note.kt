package com.example.calculator

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note (
@PrimaryKey(autoGenerate = true)
  val id:Int,
@ColumnInfo(name="header")
val header:String?,
@ColumnInfo(name="contents")
val contents:String?

)