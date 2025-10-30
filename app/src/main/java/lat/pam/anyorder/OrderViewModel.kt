package lat.pam.anyorder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel BARU yang menggunakan Map untuk menyimpan kuantitas (jumlah)
 */
class OrderViewModel : ViewModel() {

    // Sekarang menggunakan Map<String, Int>
    // Kunci (String) = Nama Makanan, Nilai (Int) = Kuantitas
    private val _orderItems = MutableLiveData<Map<String, Int>>(mapOf())

    // LiveData publiknya juga berubah
    val orderItems: LiveData<Map<String, Int>> = _orderItems

    /**
     * Logika baru untuk menambah item
     */
    fun addItem(foodName: String) {
        // 1. Dapatkan "peta" pesanan saat ini
        val currentMap = _orderItems.value?.toMutableMap() ?: mutableMapOf()

        // 2. Cek jumlah item ini sekarang (defaultnya 0 jika tidak ada)
        val currentQuantity = currentMap.getOrDefault(foodName, 0)

        // 3. Tambah jumlahnya +1
        currentMap[foodName] = currentQuantity + 1

        // 4. Perbarui LiveData dengan "peta" yang baru
        _orderItems.value = currentMap
    }

    /**
     * Logika baru untuk mengosongkan item
     */
    fun clearItems() {
        // Set ke "peta" kosong
        _orderItems.value = mapOf()
    }
}

