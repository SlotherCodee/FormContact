package com.example.formprojectbasicone.classes

class Contact(private var name: String = "Jv", private var phone: Int = 654,
              private var address: String = "New York 21", private var city: String = "New York",
    private var email: String = "example@gmail.com", private var birthday: String = "23 nov") {


    fun initializeContact(name: String, phone: Int, address: String, city: String,
                          email: String, birthday: String){

        this.name = name
        this.phone = phone
        this.address = address
        this.city = city
        this.email = email
        this.birthday = birthday
    }

    fun getName(): String{
        return this.name
    }

    fun getPhone(): Int{
        return this.phone
    }

    fun getAddress(): String{
        return this.address
    }

    fun getCity(): String{
        return this.city
    }

    fun getEmail(): String{
        return this.email
    }

    fun getBirthday(): String{
        return this.birthday
    }
}