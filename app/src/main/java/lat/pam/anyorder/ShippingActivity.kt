package lat.pam.anyorder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class ShippingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)

        // 1. Temukan semua View
        val finalOrderButton: Button = findViewById(R.id.button_order_kirim_final)
        val namaInputLayout: TextInputLayout = findViewById(R.id.text_input_nama)
        val alamatInputLayout: TextInputLayout = findViewById(R.id.text_input_alamat)
        val patokanInputLayout: TextInputLayout = findViewById(R.id.text_input_patokan) // <-- Tambahkan patokan

        finalOrderButton.setOnClickListener {

            // 2. Ambil teks dari 'editText'
            val nama = namaInputLayout.editText?.text.toString().trim()
            val alamat = alamatInputLayout.editText?.text.toString().trim()
            val patokan = patokanInputLayout.editText?.text.toString().trim() // <-- Ambil patokan

            // 3. LOGIKA VALIDASI
            if (nama.isEmpty() || alamat.isEmpty()) {
                Toast.makeText(this, "Nama Lengkap dan Alamat wajib diisi!", Toast.LENGTH_LONG).show()
                if (nama.isEmpty()) {
                    namaInputLayout.error = "Wajib diisi"
                } else {
                    namaInputLayout.error = null
                }

                if (alamat.isEmpty()) {
                    alamatInputLayout.error = "Wajib diisi"
                } else {
                    alamatInputLayout.error = null
                }
                return@setOnClickListener
            }

            // 4. Jika validasi lolos, siapkan Intent
            namaInputLayout.error = null
            alamatInputLayout.error = null

            val intent = Intent(this, ConfirmationActivity::class.java)

            // 5. KIRIM DATA KE CONFIRMATION ACTIVITY
            intent.putExtra("EXTRA_NAMA", nama)
            intent.putExtra("EXTRA_ALAMAT", alamat)
            intent.putExtra("EXTRA_PATOKAN", patokan) // Kirim patokan

            startActivity(intent)
        }
    }
}

