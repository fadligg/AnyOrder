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

| Splash Screen | Landing | SignUp |
| :---: | :---: | :---: |
| ![IMG-20251031-WA0043](https://github.com/user-attachments/assets/8a4aef9d-d91d-472a-808a-07e927d1a454) |  ![IMG-20251031-WA0044](https://github.com/user-attachments/assets/840d695d-5294-4469-93f7-0d6def57d393) | ![IMG-20251031-WA0045](https://github.com/user-attachments/assets/b1cfbedc-20e8-4cba-a478-1a1eb9934179) |

| Login | Register | Home |
| :---: | :---: | :---: |
|![IMG-20251031-WA0046](https://github.com/user-attachments/assets/9035a67c-d349-4f7b-a859-281881fadffb) | ![IMG-20251031-WA0047](https://github.com/user-attachments/assets/15ff649e-cf1c-4e25-a8b5-fe9faf27d97f) | ![IMG-20251031-WA0048](https://github.com/user-attachments/assets/c57fc3cc-4190-4f15-b241-4f9d32e97dcb) |

| Keranjang (Kosong) | Keranjang (Tidak Kosong) | Alamat Pengiriman |
| :---: | :---: | :---: |
|  ![IMG-20251031-WA0049](https://github.com/user-attachments/assets/0826f14a-c21b-483b-a81a-35ff0a7e09e4)
| ![IMG-20251031-WA0053](https://github.com/user-attachments/assets/882553c0-2a98-4ca4-8fd9-1ac485066ae7) | ![IMG-20251031-WA0050](https://github.com/user-attachments/assets/ee57c995-a633-434f-b6b8-fde81f669ae2)
 |


| Konfirmasi | Profile | 
| :---: | :---: | 
| ![IMG-20251031-WA0051](https://github.com/user-attachments/assets/29d722aa-7c2b-4849-9a91-582682482e7c) |  ![IMG-20251031-WA0052](https://github.com/user-attachments/assets/d87f7e9d-4bbf-4c4e-95fc-7556acc8fd53)|

