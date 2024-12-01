package com.example.phonebookfinal

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonebookfinal.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), ContactListAdapter.OnDeleteClickListener  {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.phoneNumber.setText("")
    }
    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.phoneNumber.text.toString()
                val contact = Contact(name, number)
                if(name.trim().isEmpty()){
                    Toast.makeText(this, "You must enter a valid name", Toast.LENGTH_SHORT).show()
                }else if (number.length != 10) {
                    Toast.makeText(this, "You must enter a 10 digit number", Toast.LENGTH_SHORT).show()
                }else{
                viewModel.insertContact(contact)
                clearFields()}
        }
        binding.findButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            viewModel.findContact(name)
        }
        binding.ascButton.setOnClickListener{
            viewModel.sortAsc().observe(this) { contacts ->
                contacts?.let {
                    adapter?.setContactList(it)
                }
            }
        }
        binding.descButton.setOnClickListener{
            viewModel.sortDesc().observe(this){ contacts ->
                contacts.let{
                    adapter?.setContactList(it)
                }
            }
        }
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }
        viewModel.getSearchResults().observe(this) { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    Toast.makeText(this, "you must enter a name to search", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDeleteClick(contact: Contact) {
        viewModel.deleteContact(contact)
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(this)
        binding.productRecycler.layoutManager = LinearLayoutManager(this)
        binding.productRecycler.adapter = adapter

    }


}