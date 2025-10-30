package lat.pam.anyorder

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels

/**
 * Fragment untuk menampilkan halaman Order.
 */
class OrderFragment : Fragment() {

    // 1. Dapatkan ViewModel yang DI-SHARE (Ini sudah benar)
    private val orderViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout dari Canvas (fragment_order.xml)
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. Cari DUA TextView baru dari layout di Canvas
        val pesananNamaTextView: TextView = view.findViewById(R.id.text_pesanan_nama) // <-- ID BARU
        val pesananQtyTextView: TextView = view.findViewById(R.id.text_pesanan_qty)   // <-- ID BARU

        // Cari juga tombol-tombolnya
        val kirimButton: Button = view.findViewById(R.id.button_kirim)
        val clearButton: Button = view.findViewById(R.id.button_clear)

        // 3. Amati (Observe) perubahan pada daftar pesanan (Map)
        orderViewModel.orderItems.observe(viewLifecycleOwner) { itemsMap ->

            if (itemsMap.isEmpty()) {
                pesananNamaTextView.text = "Pesanan Anda kosong"
                pesananQtyTextView.text = "" // Kosongkan qty
                kirimButton.isEnabled = false
                clearButton.isEnabled = false
            } else {
                // Logika baru untuk mengisi 2 kolom

                // Buat daftar NAMA
                // {"Cireng": 2} -> ["Cireng"]
                val namaText = itemsMap.entries.map { (foodName, _) ->
                    foodName
                }.joinToString("\n")

                // Buat daftar QTY
                // {"Cireng": 2} -> ["x2"]
                val qtyText = itemsMap.entries.map { (_, quantity) ->
                    "x$quantity" // <-- DIUBAH DI SINI
                }.joinToString("\n")

                // Set teksnya ke TextView yang terpisah
                pesananNamaTextView.text = namaText
                pesananQtyTextView.text = qtyText

                kirimButton.isEnabled = true
                clearButton.isEnabled = true
            }
        }

        // 4. Atur listener untuk tombol Kirim (Ini sudah benar)
        kirimButton.setOnClickListener {
            if (orderViewModel.orderItems.value.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Anda belum memesan apapun", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(activity, ShippingActivity::class.java)
                startActivity(intent)
            }
        }

        // 5. Atur listener untuk tombol Clear (Ini sudah benar)
        clearButton.setOnClickListener {
            orderViewModel.clearItems() // Memastikan nama fungsi benar
            Toast.makeText(requireContext(), "Pesanan dibersihkan", Toast.LENGTH_SHORT).show()
        }
    }
}

