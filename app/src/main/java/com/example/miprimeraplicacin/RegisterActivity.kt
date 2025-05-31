package com.example.miprimeraplicacin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var confirmPasswordEditText: TextInputEditText
    private lateinit var registerButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initializeViews()
        setupListeners()
    }

    private fun initializeViews() {
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)
        registerButton = findViewById(R.id.registerButton)
    }

    private fun setupListeners() {
        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (validateInput(name, email, password, confirmPassword)) {
                // Aquí iría la lógica de registro
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun validateInput(name: String, email: String, password: String, confirmPassword: String): Boolean {
        if (name.isEmpty()) {
            nameEditText.error = "El nombre es requerido"
            return false
        }
        if (email.isEmpty()) {
            emailEditText.error = "El correo electrónico es requerido"
            return false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Ingrese un correo electrónico válido"
            return false
        }
        if (password.isEmpty()) {
            passwordEditText.error = "La contraseña es requerida"
            return false
        }
        if (password.length < 6) {
            passwordEditText.error = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        if (confirmPassword.isEmpty()) {
            confirmPasswordEditText.error = "Debe confirmar la contraseña"
            return false
        }
        if (password != confirmPassword) {
            confirmPasswordEditText.error = "Las contraseñas no coinciden"
            return false
        }
        return true
    }
} 