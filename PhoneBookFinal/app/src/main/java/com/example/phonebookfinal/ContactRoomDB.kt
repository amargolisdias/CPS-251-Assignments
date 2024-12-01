package com.example.phonebookfinal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Contact::class)], version = 3)
abstract class ContactRoomDB: RoomDatabase() {
    abstract fun contactDao(): ContactDao
    companion object {
        private var INSTANCE: ContactRoomDB? = null
        internal fun getDatabase(context: Context): ContactRoomDB? {
            if (INSTANCE == null) {
                synchronized(ContactRoomDB::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder(
                                context.applicationContext,
                                ContactRoomDB::class.java,
                                "contact_database").build()
                    }
                }
            }
            return INSTANCE
        }
    }

}