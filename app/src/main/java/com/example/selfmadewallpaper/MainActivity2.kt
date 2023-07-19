package com.example.selfmadewallpaper

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.selfmadewallpaper.databinding.ActivityMain2Binding
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.OutputStream
import java.net.URL
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        val url = intent.getStringExtra("link")
        Glide.with(this).load(url).into(binding.finalwalpaperImage)
        val UrlImage = URL(url)



binding.setBtn.setOnClickListener {
    lifecycleScope.launch(Dispatchers.IO) {
        val inputStream = URL(url).openStream()
        WallpaperManager.getInstance(this@MainActivity2).setStream(inputStream)
        Toast.makeText(this@MainActivity2, "Done", Toast.LENGTH_SHORT).show()
    }

}

        binding.dwnldBtn.setOnClickListener {
            val result  : Deferred<Bitmap?> = GlobalScope.async {
                UrlImage.toBitmap()
            }
            GlobalScope.launch  (Dispatchers.Main ){

              saveimage(result.await())
            }


        }

    }
    fun URL.toBitmap():Bitmap?{
        return try {

            BitmapFactory.decodeStream(openStream())

        }catch (e:IOException){
            null
        }
    }
    private fun saveimage(image:Bitmap?){
        val random1 = Random().nextInt(52907)
        val random2 = Random().nextInt(92987)

        val name = "AMOLED-${random1 + random2}"
        val data :OutputStream
    }


}