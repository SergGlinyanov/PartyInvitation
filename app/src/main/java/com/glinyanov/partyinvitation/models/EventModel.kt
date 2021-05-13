package com.glinyanov.partyinvitation.models

data class EventModel(val id: Int, val partyImageUrl: String, val partyName: String, val partyOwner: UserModel, val listAcceptedInvitations: Array<UserModel>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EventModel) return false

        if (partyImageUrl != other.partyImageUrl) return false
        if (partyOwner != other.partyOwner) return false
        if (!listAcceptedInvitations.contentEquals(other.listAcceptedInvitations)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = partyImageUrl.hashCode()
        result = 31 * result + partyOwner.hashCode()
        result = 31 * result + listAcceptedInvitations.contentHashCode()
        return result
    }
}
