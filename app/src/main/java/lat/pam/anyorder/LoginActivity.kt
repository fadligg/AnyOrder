package lat.pam.anyorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menghubungkan ke layout activity_login.xml
        setContentView(R.layout.activity_login)

        // 1. Temukan tombol login DAN input fields
        // PENTING: Pastikan ID ini sesuai dengan activity_login.xml Anda!
        val usernameInput: EditText = findViewById(R.id.edit_text_username_login)
        val passwordInput: EditText = findViewById(R.id.edit_text_password_login)
        val loginButton = findViewById<Button>(R.id.button_login_submit)

        // 2. Atur listener untuk tombol
        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // 3. Validasi input
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 4. Coba login menggunakan UserRepository
            // Ini memanggil kode dari file Auth.kt Anda
            val loginSuccess = UserRepository.loginUser(username, password)

            if (loginSuccess) {
                // 5. Jika sukses, beri tahu & pindah ke Home
                Toast.makeText(this, "Login sukses! Selamat datang.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

                // 6. Tutup LoginActivity agar pengguna tidak bisa kembali
                finish()
            } else {
                // 6. Jika gagal (username/password salah)
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

