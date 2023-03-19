package com.example.sofascorehw1

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.MailTo.parse
import androidx.core.view.isVisible
import com.example.sofascorehw1.databinding.ActivityMainBinding
import java.net.HttpCookie.parse
import java.time.Duration.parse
import java.util.logging.Level.parse

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var mediaPlayer = MediaPlayer.create(this, R.raw.song)


        binding.hideShowButton.setOnClickListener {

            binding.helloSofascore.isVisible = !binding.helloSofascore.isVisible

            if (binding.helloSofascore.isVisible) {
                mediaPlayer.stop()
                binding.hideShowButton.setText("Hide")
            } else {
                mediaPlayer.start()
                binding.hideShowButton.setText("Show")
            }


        }
    }
}