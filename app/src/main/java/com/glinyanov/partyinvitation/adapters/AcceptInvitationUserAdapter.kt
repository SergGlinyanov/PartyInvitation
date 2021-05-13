package com.glinyanov.partyinvitation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.glinyanov.partyinvitation.R
import com.glinyanov.partyinvitation.models.UserModel
import kotlinx.android.synthetic.main.layout_accept_inviation_user.view.*

class AcceptInvitationUserAdapter : ListAdapter<UserModel, AcceptInvitationUserAdapter.AcceptInvitationUserViewHolder>(AcceptInvitationUserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcceptInvitationUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_accept_inviation_user, parent, false)
        return AcceptInvitationUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: AcceptInvitationUserViewHolder, position: Int) {
        val user = getItem(position)
        with (holder) {
            userAvatar.load(user.avatarImgUrl){
                crossfade(true)
                transformations(CircleCropTransformation())
                placeholder(R.drawable.ic_baseline_face_24)
            }
            userName.text = user.name
        }
    }

    inner class AcceptInvitationUserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userAvatar: ImageView = itemView.userAvatar
        var userName: TextView = itemView.userName
    }

    class AcceptInvitationUserDiffCallback: DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
