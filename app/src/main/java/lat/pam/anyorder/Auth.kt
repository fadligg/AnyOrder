package lat.pam.anyorder

// 1. Data class untuk menampung data pengguna
data class User(
    val username: String,
    val password: String
    // Anda bisa tambahkan 'namaLengkap' di sini jika mau
)

// 2. "Database" sementara kita (Singleton Object)
object UserRepository {

    // Daftar untuk menyimpan pengguna yang terdaftar
    private val users = mutableListOf<User>()

    // Properti untuk menyimpan siapa yang sedang login
    var currentUser: User? = null
        private set // Hanya bisa diubah di dalam file ini

    /**
     * Coba daftarkan pengguna baru.
     * @return true jika sukses, false jika username sudah ada.
     */
    fun registerUser(user: User): Boolean {
        // Cek apakah username sudah ada
        if (users.any { it.username.equals(user.username, ignoreCase = true) }) {
            return false // Username sudah dipakai
        }
        // Jika belum, tambahkan ke daftar
        users.add(user)
        return true // Registrasi sukses
    }

    /**
     * Coba login pengguna.
     * @return true jika username dan password cocok, false jika tidak.
     */
    fun loginUser(username: String, password: String): Boolean {
        // Cari pengguna yang cocok
        val user = users.find { it.username.equals(username, ignoreCase = true) }

        // Jika pengguna ada DAN password-nya cocok
        if (user != null && user.password == password) {
            currentUser = user // <- PENTING: Simpan pengguna yang sedang login
            return true
        }
        return false
    }

    /**
     * Fungsi baru untuk Sign Out
     */
    fun signOut() {
        currentUser = null // Lupakan pengguna
    }
}

