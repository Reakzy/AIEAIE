package com.supdevinci.aieaie.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "openAi_table")
data class OpenAiEntity(@PrimaryKey @ColumnInfo(name = "message") val message: String)
