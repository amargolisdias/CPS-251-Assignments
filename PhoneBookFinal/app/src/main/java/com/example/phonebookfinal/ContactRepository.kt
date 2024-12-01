package com.example.phonebookfinal

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*


class ContactRepository (application: Application){
    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    var allContacts: LiveData<List<Contact>>?

    init{
        val db: ContactRoomDB? = ContactRoomDB.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newContact: Contact){
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newContact)
        }
    }
    private fun asyncInsert(contact: Contact){
        contactDao?.insertContact(contact)
    }

    fun sortAsc(): LiveData<List<Contact>> {
        return contactDao?.sortAsc()?: MutableLiveData(emptyList())
    }
    fun sortDesc(): LiveData<List<Contact>>{
        return contactDao?.sortDesc()?: MutableLiveData(emptyList())
    }

    fun deleteContact(contact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(contact.id)
        }
    }

    private fun asyncDelete(contactId: Int) {
        contactDao?.deleteContact(contactId)
    }

    fun findContact(name: String){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncFind(name).await()
        }
    }

    private fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO){
            val results = contactDao?.findContact("%$name%")
            return@async results
        }




}