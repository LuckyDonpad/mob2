package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = DogAdapter()
    private val dogList = listOf(
        R.drawable.dog_akita to "Akita",
        R.drawable.dog_boxer to "Boxer",
        R.drawable.dog_chihuahuhua to "Chihuahua",
        R.drawable.dog_chow to "Chow",
        R.drawable.dog_dhole to "Dhole",
        R.drawable.dog_hound to "Hound",
        R.drawable.dog_mastiff to "Mastiff",
        R.drawable.dog_pekinese to "Pekinese",
        R.drawable.dog_pitbull to "Pitbull",
        R.drawable.dog_wolfhound to "Wolfhound",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        adapter.onItemClick = {
            val intent = Intent(this, WatchDogByBreedActivity::class.java)
            intent.putExtra("dog", it)
            startActivity(intent)
        }
    }

    private fun init() {
        binding.apply {
            rcViewBreeds.layoutManager = LinearLayoutManager(this@MainActivity)
            rcViewBreeds.adapter = adapter
            dogList.map { adapter.addDog(Dog(it.first, it.second)) }
        }
    }
}