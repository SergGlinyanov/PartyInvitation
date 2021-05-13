package com.glinyanov.partyinvitation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import com.glinyanov.partyinvitation.adapters.AcceptInvitationUserAdapter
import com.glinyanov.partyinvitation.models.EventModel
import com.glinyanov.partyinvitation.sal.EventRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val acceptInvitationUserAdapter = AcceptInvitationUserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val eventModel: EventModel = EventRepositoryImpl(this).getEvent(R.raw.party)
        setLayout(eventModel)
    }

    private fun setLayout(eventModel: EventModel) {
        partyImage.load(eventModel.partyImageUrl)
        partyOwnerAvatar.load(eventModel.partyOwner.avatarImgUrl){ transformations(CircleCropTransformation()) }
        eventName.text = eventModel.partyName
        ownerName.text = getString(R.string.ownerName, eventModel.partyOwner.name)
        acceptInvitationsContainer.adapter = acceptInvitationUserAdapter
        acceptInvitationUserAdapter.submitList(eventModel.listAcceptedInvitations.toMutableList())
    }

}