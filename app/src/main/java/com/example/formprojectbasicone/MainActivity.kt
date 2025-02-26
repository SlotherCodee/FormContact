package com.example.formprojectbasicone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formprojectbasicone.classes.Contact
import com.example.formprojectbasicone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        formContact()
    }

    private fun formContact(){

        val button = binding.buttonSave
        val name = binding.nameTie
        val phone = binding.phoneTie
        val address = binding.addressTie
        val city = binding.cityTie
        val email = binding.emailTie
        val birthday = binding.birthdayTie

        val contact = Contact()

        button.setOnClickListener {
            if(name.text.isNullOrEmpty()){
                binding.nameTil.error = getString(R.string.campo_required)
            }else if(phone.text.isNullOrEmpty()){
                binding.phoneTil.error = getString(R.string.campo_required)
            }else{
                binding.nameTil.isErrorEnabled = false
                binding.phoneTil.isErrorEnabled = false
                contact.initializeContact(
                    name.text.toString(), phone.text.toString().toInt(),
                    address.text.toString(), city.text.toString(),email.text.toString(),
                    birthday.text.toString()
                )
                Toast.makeText(this,"Contact saved", Toast.LENGTH_SHORT).show()
            }
            alertDialog(contact)
        }
    }

    private fun alertDialog(contact: Contact){
        val message = "Name: ${contact.getName()}, Phone ${contact.getPhone()}," +
                "Address: ${contact.getAddress()}, City: ${contact.getCity()}, " +
                "Email: ${contact.getEmail()}, Birthday: ${contact.getBirthday()}"
        val alertBuilder = AlertDialog.Builder(this)

        alertBuilder.setTitle("New Contact!!")
        alertBuilder.setMessage(message)
        alertBuilder.setCancelable(false)
        alertBuilder.setPositiveButton("Ok") { dialog, _ ->
            dialog.dismiss()
        }
        alertBuilder.create()
        alertBuilder.show()
    }
}