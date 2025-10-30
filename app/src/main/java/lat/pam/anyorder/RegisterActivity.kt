package lat.pam.anyorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // 1. Temukan tombol register DAN input fields
        // PENTING: Pastikan ID ini sesuai dengan activity_register.xml Anda!
        val usernameInput: EditText = findViewById(R.id.edit_text_username_register)
        val passwordInput: EditText = findViewById(R.id.edit_text_password_register)
        val registerButton = findViewById<Button>(R.id.button_register_submit)

        // 2. Atur listener untuk tombol
        registerButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // 3. Validasi input
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Buat objek User baru
            val newUser = User(username, password)

            // 4. Coba daftarkan pengguna ke UserRepository
            // Ini memanggil kode dari file Auth.kt Anda
            val success = UserRepository.registerUser(newUser)

            if (success) {
                // 5. Jika sukses, beri tahu & pindah ke SignUpActivity (SESUAI PERMINTAAN ANDA)
                Toast.makeText(this, "Registrasi sukses!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, SignUpActivity::class.java) // <-- PERUBAHAN DI SINI
                startActivity(intent)

                // 6. Tutup RegisterActivity agar pengguna tidak bisa kembali
                finish()
            } else {
                // 6. Jika gagal (username sudah ada)
                Toast.makeText(this, "Username '$username' sudah terpakai!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

