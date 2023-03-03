package com.example.nativedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nativedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = createUserFromJNI("Khang Tran", 29)
        binding.sampleText.text = createUserInfoFromJNI(user)
    }

    external fun createUserFromJNI(name: String, old: Int): User
    external fun createUserInfoFromJNI(user: User): String

    companion object {
        // Used to load the 'nativedemo' library on application startup.
        init {
            System.loadLibrary("nativedemo")
        }
    }
}