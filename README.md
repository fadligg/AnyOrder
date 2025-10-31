# AnyOrder 🛒

AnyOrder adalah sebuah platform pemesanan (ordering app) berbasis Android yang memungkinkan pengguna untuk memesan item dan mengirimkannya ke alamat tujuan.

## 🌟 Fitur Utama

* **Autentikasi Pengguna:** Sistem login dan registrasi yang aman.
* **Katalog Item:** Tampilan utama untuk menjelajah dan memilih item.
* **Keranjang Pesanan:** Tempat untuk menampung dan meninjau item sebelum *checkout*.
* **Proses Checkout:** Formulir untuk memasukkan detail pengiriman.
* **Konfirmasi Pesanan:** Layar ringkasan yang memastikan pesanan telah berhasil dibuat.

---

## 📱 Alur Aplikasi

Berikut adalah alur lengkap penggunaan aplikasi dari awal hingga selesai:

### 1. Autentikasi Pengguna
Sebelum dapat memesan, pengguna harus masuk ke akun mereka atau mendaftar jika belum memiliki akun.
* **Login:** `LoginActivity`
* **Registrasi:** `SignUpActivity` / `RegisterActivity`

### 2. Pemilihan Item (Tampilan Utama)
Setelah berhasil masuk, pengguna akan diarahkan ke layar utama (ditangani oleh `MainActivity` atau `HomeFragment`). Di sini, pengguna dapat melihat dan memilih berbagai item yang ingin dipesan.

### 3. Keranjang Pesanan (OrderFragment)
`OrderFragment` berfungsi sebagai keranjang atau daftar pesanan saat ini.
* Fragment ini akan menampilkan semua item yang telah ditambahkan oleh pengguna.
* Jika pengguna belum menambahkan item apa pun, layar ini akan menampilkan pesan "Pesanan Anda Kosong".

### 4. Pengisian Detail Pengiriman (Checkout)
Dari keranjang, pengguna akan melanjutkan ke proses *checkout*. Pada tahap ini, pengguna akan mengisi formulir detail pengiriman yang mencakup:
* Nama Lengkap
* Alamat Pengiriman
* Patokan (Petunjuk Alamat)

### 5. Konfirmasi Pesanan (ConfirmationActivity)
Setelah pesanan berhasil dikirim (data terkirim ke server), aplikasi akan menampilkan layar konfirmasi (`ConfirmationActivity`). Layar ini bertujuan untuk:
* Memberi tahu pengguna bahwa pesanan telah berhasil diterima.
* Menampilkan ringkasan detail pengiriman untuk verifikasi.
* Memberi instruksi selanjutnya kepada pengguna (jika ada).

---

## 🛠️ Teknologi yang Digunakan

* **Bahasa:** [Kotlin](https://developer.android.com/kotlin)

---

## 📸 Tangkapan Layar (Screenshots)

*(Tempatkan gambar-gambar Anda di sini untuk memberikan gambaran visual)*

| Login | Tampilan Utama | Keranjang (Isi) |
| :---: | :---: | :---: |
| [Gambar Login] | [Gambar Home] | [Gambar Keranjang] |

| Keranjang (Kosong) | Checkout | Konfirmasi |
| :---: | :---: | :---: |
| [Gambar Keranjang Kosong] | [Gambar Checkout] | [Gambar Konfirmasi] |
