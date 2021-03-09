package com.estudo.motivation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.estudo.motivation.R
import com.estudo.motivation.databinding.ActivityMainBinding
import com.estudo.motivation.infra.MotivationConstants
import com.estudo.motivation.infra.SecurityPreferences
import com.estudo.motivation.repository.Mock

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mSecurityPreferences = SecurityPreferences(this)
        mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        binding.textName.text = "Olá, $name!"

        binding.buttonNewPhrase.setOnClickListener { handleNewPhrase() }
        binding.imgAll.setOnClickListener { imgAllFilter() }
        binding.imgHappy.setOnClickListener { imgHappyFilter() }
        binding.imgSun.setOnClickListener { imgSunFilter() }

        // Lógica inicial de seleção de frases
        binding.imgAll.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNewPhrase()
    }

    private fun imgSunFilter() {
        setColorImgWhite()
        binding.imgSun.setColorFilter(resources.getColor(R.color.colorAccent))
        mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
    }

    private fun imgHappyFilter() {
        setColorImgWhite()
        binding.imgHappy.setColorFilter(resources.getColor(R.color.colorAccent))
        mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
    }

    private fun imgAllFilter() {
        setColorImgWhite()
        binding.imgAll.setColorFilter(resources.getColor(R.color.colorAccent))
        mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
    }

    private fun handleNewPhrase() {
        binding.textPhrase.text = Mock().getPhrase(mPhraseFilter)
    }

    private fun setColorImgWhite(){
        binding.imgSun.setColorFilter(resources.getColor(R.color.white))
        binding.imgAll.setColorFilter(resources.getColor(R.color.white))
        binding.imgHappy.setColorFilter(resources.getColor(R.color.white))
    }
}