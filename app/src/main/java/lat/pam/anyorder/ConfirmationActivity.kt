package lat.pam.anyorder

import android.content.Intent
import android.os.Bundle
import android.view.View // <-- Import ditambahkan
import android.widget.Button
import android.widget.TextView // <-- Import ditambahkan
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    // Dapatkan ViewModel untuk MENGOSONGKAN keranjang
    private val orderViewModel: OrderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menggunakan layout "Resi" dari Canvas Anda
        setContentView(R.layout.activity_confirmation)

        // 1. Temukan semua TextView dari layout "Resi"
        val usernameTextView: TextView = findViewById(R.id.text_conf_username)
        val namaTextView: TextView = findViewById(R.id.text_conf_nama)
        val alamatTextView: TextView = findViewById(R.id.text_conf_alamat)
        val patokanTextView: TextView = findViewById(R.id.text_conf_patokan)
        val finishButton: Button = findViewById(R.id.button_finish) // <-- ID tombol dari layout "Resi"

        // 2. Ambil data dari UserRepository
        val username = UserRepository.currentUser?.username ?: "Tamu"

        // 3. Ambil data dari Intent (yang dikirim ShippingActivity)
        val namaLengkap = intent.getStringExtra("EXTRA_NAMA") ?: "Tidak ada nama"
        val alamat = intent.getStringExtra("EXTRA_ALAMAT") ?: "Tidak ada alamat"
        val patokan = intent.getStringExtra("EXTRA_PATOKAN") ?: "" // Default string kosong

        // 4. Tampilkan data ke TextView
        usernameTextView.text = "Username: $username"
        namaTextView.text = "Nama Lengkap: $namaLengkap"
        alamatTextView.text = "Alamat: $alamat"

        // 5. Hanya tampilkan patokan JIKA diisi
        if (patokan.isNotEmpty()) {
            patokanTextView.text = "Patokan: $patokan"
            patokanTextView.visibility = View.VISIBLE
        } else {
            patokanTextView.visibility = View.GONE // Sembunyikan jika kosong
        }

        // 6. Atur tombol Selesai
        finishButton.setOnClickListener {
            // Tampilkan pesan
            Toast.makeText(this, "Pesanan sukses! Terima kasih.", Toast.LENGTH_LONG).show()

            // KOSONGKAN KERANJANG di sini
            orderViewModel.clearItems()

            // Kembali ke Home
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish() // Tutup activity ini
        }
    }
}

