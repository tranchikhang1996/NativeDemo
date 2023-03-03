package com.example.nativedemo

object JNICaller {
    init {
        System.loadLibrary("nativedemo")
    }

    external fun createUserFromJNI(name: String, old: Int): User
    external fun createUserInfoFromJNI(user: User): String
}