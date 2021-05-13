package com.glinyanov.partyinvitation.sal.interfaces

import com.glinyanov.partyinvitation.models.EventModel

interface EventRepository {
    fun getEvent(rawJsonId: Int): EventModel
}