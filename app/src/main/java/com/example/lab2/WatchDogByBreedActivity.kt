package com.example.lab2

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.databinding.ActivityWatchDogByBreedBinding

class WatchDogByBreedActivity : AppCompatActivity() {
    private val adapter = DogAdapter()
    private var dogList = ArrayList<Dog>()

    lateinit var binding: ActivityWatchDogByBreedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWatchDogByBreedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dog = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("dog", Dog::class.java)
        } else {
            intent.getParcelableExtra<Dog>("dog")
        }
        if (dog != null) {
            repeat(10) { dogList.add(dog) }
        }
        init()
    }
    private fun init() {
        binding.apply {
            rcViewDogs.layoutManager = LinearLayoutManager(this@WatchDogByBreedActivity)
            rcViewDogs.adapter = adapter
            dogList.map { adapter.addDog(it) }
        }
    }
}

