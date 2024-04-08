package com.supdevinci.aieaie.repository

import androidx.annotation.WorkerThread
import com.supdevinci.aieaie.dao.OpenAiDao
import com.supdevinci.aieaie.entity.OpenAiEntity
import kotlinx.coroutines.flow.Flow

class OpenAiRoomRepository(private val openAiDao: OpenAiDao) {
        val getConversations: Flow<List<OpenAiEntity>> = openAiDao.getOpenAiConversations()

        @WorkerThread
        suspend fun insert(openAiEntity: OpenAiEntity) {
                openAiDao.insert(openAiEntity)
        }
}


