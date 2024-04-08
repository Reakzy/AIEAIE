package com.supdevinci.aieaie.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.supdevinci.aieaie.entity.OpenAiEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OpenAiDao {
    @Query("SELECT * FROM openAi_table")
    fun getOpenAiConversations(): Flow<List<OpenAiEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(openAiEntity: OpenAiEntity)

    @Query("DELETE FROM openAi_table")
    suspend fun deleteAll()
}