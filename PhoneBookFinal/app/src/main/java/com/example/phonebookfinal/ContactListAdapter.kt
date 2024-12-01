package com.example.phonebookfinal

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebookfinal.databinding.ContactListItemBinding

//private var contactList: List<Contact>? = null
//private lateinit var viewModel: MainViewModel

class ContactListAdapter( private val onDeleteClickListener: OnDeleteClickListener) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    interface OnDeleteClickListener {
        fun onDeleteClick(contact: Contact)
    }


    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        contactList?.let {
            val contact = it[listPosition]
            holder.bind(contact)

            holder.binding.deleteIcon.setOnClickListener{
                onDeleteClickListener.onDeleteClick(contact)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
       val binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        Log.d("adapterContactList", "Contact list set with ${contacts.size} contacts")
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return contactList?.size ?: 0
    }

    class ViewHolder(
        val binding: ContactListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact){
            val formattedPhoneNumber = String.format("%s.%s.%s",
                contact.phoneNumber?.substring(0,3),
                contact.phoneNumber?.substring(3,6),
                contact.phoneNumber?.substring(6,10)
            )
            binding.contactRow.text = contact.contactName
            binding.contactRow2.text = formattedPhoneNumber
        }
    }

}