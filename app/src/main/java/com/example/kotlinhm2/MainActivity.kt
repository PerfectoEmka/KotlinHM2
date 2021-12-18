package com.example.kotlinhm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.kotlinhm2.databinding.ActivityMainBinding
import com.example.kotlinhm2.extensions.load
import com.example.kotlinhm2.extensions.showToast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillList()
        binding.btnAdd.setOnClickListener {
            setImageUrl()
        }

        binding.btnShuffle.setOnClickListener {
            shuffleImages()
        }

    }

    private fun shuffleImages() {
        val randomIndex = Random.nextInt(list.size)
        val randomElement = list.get(randomIndex)
        binding.ivPicture.load(randomElement)
    }

    private fun setImageUrl() {
        val url = binding.etEdit.text.toString()
        if (url.isNotEmpty()){
            list.add(url)
            binding.etEdit.setText("")
        } else {
            showToast(getString(R.string.set_message))
        }
    }

    private fun fillList() {
        list.add("https://static.remove.bg/remove-bg-web/6c5ea334216f9ded64486efb0e2a4421757cbce5/assets/start_remove-c851bdf8d3127a24e2d137a55b1b427378cd17385b01aec6e59d5d4b5f39d2ec.png")
        list.add("https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dmlld3xlbnwwfHwwfHw%3D&w=1000&q=80")
        list.add("https://miro.medium.com/max/1200/1*mk1-6aYaf_Bes1E3Imhc0A.jpeg")
        list.add("https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg")
        list.add("https://images.ctfassets.net/hrltx12pl8hq/euxCffMOPuxAnPLcN3nzW/eb14f1deaa1e6edce8981124825aefb9/ULOHP.png?fit=fill&w=800&h=400")
    }
}