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

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 1. Inflate layout yang BENAR (dari Canvas Anda)
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. Temukan Views dari layout
        val usernameTextView: TextView = view.findViewById(R.id.text_profile_username)
        val signOutButton: Button = view.findViewById(R.id.button_sign_out)

        // 3. Tampilkan username dari UserRepository (file Auth.kt Anda)
        //    Jika tidak ada (error?), tampilkan "Tamu"
        val username = UserRepository.currentUser?.username ?: "Tamu"
        usernameTextView.text = "Username: $username"

        // 4. Atur listener untuk tombol Sign Out
        signOutButton.setOnClickListener {
            // Panggil fungsi signOut dari UserRepository
            UserRepository.signOut()

            // Tampilkan pesan
            Toast.makeText(requireContext(), "Anda telah sign out.", Toast.LENGTH_SHORT).show()

            // Buat Intent untuk kembali ke halaman awal (SignUpActivity)
            val intent = Intent(requireActivity(), SignUpActivity::class.java)

            // PENTING: Flag ini akan membersihkan semua activity sebelumnya
            // Ini mencegah pengguna menekan "back" dan kembali ke HomeActivity
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            requireActivity().finish() // Tutup HomeActivity
        }
    }
}

