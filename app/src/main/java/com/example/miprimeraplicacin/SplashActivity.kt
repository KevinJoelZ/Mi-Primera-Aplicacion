package com.example.miprimeraplicacin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val appLogo = findViewById<ImageView>(R.id.appLogo)
        val imagePhone = findViewById<ImageView>(R.id.imagePhone)
        val imageWelcome = findViewById<ImageView>(R.id.imageWelcome)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val subtitleTextView = findViewById<TextView>(R.id.subtitleTextView)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)

        // Animación de fade in para el logo
        val logoFadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in).apply {
            duration = 1500
        }
        
        // Animación de fade in para el teléfono
        val phoneFadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in).apply {
            duration = 1500
            startOffset = 500 // Comienza después del logo
        }
        
        // Animación de rotación para el icono de bienvenida
        val welcomeRotate = AnimationUtils.loadAnimation(this, android.R.anim.fade_in).apply {
            duration = 1500
            startOffset = 1000 // Comienza después del teléfono
        }

        // Animación de fade in para los textos
        val textFadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in).apply {
            duration = 1000
            startOffset = 1500 // Comienza después del icono de bienvenida
        }

        // Aplicar animaciones
        appLogo.startAnimation(logoFadeIn)
        appLogo.alpha = 1f

        imagePhone.startAnimation(phoneFadeIn)
        imagePhone.alpha = 1f

        imageWelcome.startAnimation(welcomeRotate)
        imageWelcome.alpha = 1f

        titleTextView.startAnimation(textFadeIn)
        subtitleTextView.startAnimation(textFadeIn)
        descriptionTextView.startAnimation(textFadeIn)

        // Esperar 4.5 segundos y luego ir a la pantalla principal con fade out
        Handler(Looper.getMainLooper()).postDelayed({
            val fadeOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out).apply {
                duration = 500
            }
            
            appLogo.startAnimation(fadeOut)
            imagePhone.startAnimation(fadeOut)
            imageWelcome.startAnimation(fadeOut)
            titleTextView.startAnimation(fadeOut)
            subtitleTextView.startAnimation(fadeOut)
            descriptionTextView.startAnimation(fadeOut)
            
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }, 500)
        }, 4500)
    }
} 