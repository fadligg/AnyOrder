package lat.pam.anyorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up) // Pastikan nama file XML Anda activity_sign_up.xml

        // Temukan kedua tombol
        val registerButton = findViewById<Button>(R.id.button_register)
        val loginButton = findViewById<Button>(R.id.button_login)

        // Atur onClickListener untuk tombol Register
        registerButton.setOnClickListener {
            // Pindah ke RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Atur onClickListener untuk tombol Login
        loginButton.setOnClickListener {
            // Pindah ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
