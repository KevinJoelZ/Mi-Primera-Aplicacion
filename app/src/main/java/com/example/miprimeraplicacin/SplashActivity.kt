package com.example.miprimeraplicacin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imagePhone = findViewById<ImageView>(R.id.imagePhone)

        // Animación de rotación y fade in
        val rotateAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in).apply {
            duration = 1500
        }
        
        imagePhone.startAnimation(rotateAnimation)
        imagePhone.alpha = 1f

        // Esperar 3 segundos y luego ir a la pantalla principal con fade out
        Handler(Looper.getMainLooper()).postDelayed({
            val fadeOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out).apply {
                duration = 500
            }
            
            imagePhone.startAnimation(fadeOut)
            
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }, 500)
        }, 3000)
    }
} 