package com.glinyanov.partyinvitation.sal

import android.content.Context
import com.glinyanov.partyinvitation.extensions.readRaw
import com.glinyanov.partyinvitation.models.EventModel
import com.glinyanov.partyinvitation.sal.interfaces.EventRepository
import com.google.gson.reflect.TypeToken

class EventRepositoryImpl(private val context: Context) : BaseConverter(), EventRepository {

    override fun getEvent(rawJsonId: Int): EventModel {
        val responseType = object : TypeToken<EventModel>() { }.type
        return createResponse(context.readRaw(rawJsonId), responseType)
    }

}