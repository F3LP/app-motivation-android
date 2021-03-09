package com.estudo.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.estudo.motivation.databinding.ActivitySplashBinding
import com.estudo.motivation.infra.MotivationConstants
import com.estudo.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mSecurityPreferences = SecurityPreferences(this)

        binding.buttonSave.setOnClickListener { handleSave() }

        verifyName()
    }

    private fun verifyName() {
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if(name != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave() {
        val name = binding.editYourName.text.toString()

        if (name.trim() != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Digite um nome!", Toast.LENGTH_SHORT).show()
        }
    }

}