package com.supdevinci.aieaie.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.supdevinci.aieaie.database.OpenAiDatabase
import com.supdevinci.aieaie.entity.OpenAiEntity
import com.supdevinci.aieaie.model.OpenAiMessageBody
import com.supdevinci.aieaie.model.request.BodyToSend
import com.supdevinci.aieaie.model.response.GeneratedAnswer
import com.supdevinci.aieaie.repository.OpenAiRepository
import com.supdevinci.aieaie.repository.OpenAiRoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OpenAiViewModel : ViewModel() {
    private val repository = OpenAiRepository()
    private val _openAiResponse = MutableStateFlow<GeneratedAnswer?>(null)

    val openAiResponse: StateFlow<GeneratedAnswer?> = _openAiResponse

    fun fetchMessages() {
        viewModelScope.launch {
            try {
                val bodyToSend = BodyToSend(messages = listOf(OpenAiMessageBody(role= "assistant", content= "test test")))
                _openAiResponse.value = repository.getChatFromOpenAi(bodyToSend)
                Log.e("Fetch Messages List : ", _openAiResponse.value.toString())
            } catch (e: Exception) {
                // Handle error
                Log.e("Fetch Contact List : ", e.message.toString())
            }
        }
    }


    fun getOpenAiConversationRoom(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            val database = OpenAiDatabase.getDatabase(context, this)
            val repository = OpenAiRoomRepository(database.openAiDao())
            repository.insert(OpenAiEntity("Test"))
            println(" TESTLALALALALLALALALALAL ${repository.getConversations.asLiveData().value}")
        }

    }
}