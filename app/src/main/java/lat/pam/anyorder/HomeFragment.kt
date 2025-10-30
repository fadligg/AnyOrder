package lat.pam.anyorder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    // Dapatkan ViewModel yang dibagikan
    private val orderViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout untuk fragment ini
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- LOGIKA UNTUK SAPAAN ---
        // 1. Temukan TextView sapaan dari fragment_home.xml
        val greetingTextView: TextView = view.findViewById(R.id.text_greeting_home)

        // 2. Dapatkan username dari UserRepository (file Auth.kt)
        val username = UserRepository.currentUser?.username ?: "Gantenk" // Default jika null

        // 3. Atur teks sapaan
        greetingTextView.text = "Halo, $username"
        // --- SELESAI LOGIKA SAPAAN ---


        // --- LOGIKA BARU UNTUK 10 MAKANAN ---

        // 1. Definisikan map (peta) dari ID CardView ke nama makanan
        //    ID ini harus sama persis dengan di fragment_home.xml
        val foodItems = mapOf(
            R.id.card_food_1 to "Cireng aci Bandung",
            R.id.card_food_2 to "Batagor Bandung",
            R.id.card_food_3 to "Seblak Pedas",
            R.id.card_food_4 to "Karedok",
            R.id.card_food_5 to "Nasi Timbel",
            R.id.card_food_6 to "Sate Maranggi",
            R.id.card_food_7 to "Mie Kocok",
            R.id.card_food_8 to "Lotek",
            R.id.card_food_9 to "Surabi Manis",
            R.id.card_food_10 to "Telur Gulung"
        )

        // 2. Loop (ulangi) untuk setiap item di map
        foodItems.forEach { (cardId, foodName) ->
            // Temukan CardView. Gunakan '?' agar tidak crash jika ID tidak ada di layout
            val cardView = view.findViewById<CardView?>(cardId)

            // Atur listener untuk CardView ini
            cardView?.setOnClickListener {
                // Tampilkan Toast
                Toast.makeText(requireContext(), "$foodName ditambahkan ke order", Toast.LENGTH_SHORT).show()

                // Tambahkan item ke ViewModel
                orderViewModel.addItem(foodName)

                // Pindahkan navigasi (cara yang benar agar tetap sinkron)
                activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.selectedItemId = R.id.navigation_order
            }
        }
    }
}

