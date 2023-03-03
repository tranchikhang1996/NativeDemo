package com.example.nativedemo

data class User(val name: String, val old: Int) {
    fun getInfo(): String {
        return "My name is $name, I am $old year old"
    }
}