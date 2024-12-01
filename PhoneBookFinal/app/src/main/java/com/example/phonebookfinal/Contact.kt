package com.example.phonebookfinal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null
    var phoneNumber: String? = null

    constructor()


    constructor(contactName: String, phoneNumber: String){
        this.contactName = contactName
        this.phoneNumber= phoneNumber
    }

}