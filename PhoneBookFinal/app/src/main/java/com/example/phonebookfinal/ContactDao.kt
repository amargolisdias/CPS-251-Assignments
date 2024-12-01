package com.example.phonebookfinal

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {
    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%'")
    fun findContact(name: String): List<Contact>

    @Query("DELETE FROM contacts WHERE contactId = :contactId")
    fun deleteContact(contactId: Int)

    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun sortAsc(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun sortDesc(): LiveData<List<Contact>>



    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>

}