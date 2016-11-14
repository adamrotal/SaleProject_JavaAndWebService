# Tugas 2 IF3110 Pengembangan Aplikasi Berbasis Web

Melakukan *upgrade* Website Marketplace sederhana pada Tugas 1 dengan mengaplikasikan **arsitektur web service REST dan SOAP**.

**Luangkan waktu untuk membaca spek ini sampai selesai. Kerjakan hal yang perlu saja.**

### Tujuan Pembuatan Tugas

Diharapkan dengan tugas ini anda dapat mengerti:
* Produce dan Consume REST API
* Mengimplementasikan service Single Sign-On (SSO) sederhana
* Produce dan Consume Web Services dengan protokol SOAP
* Membuat web application dengan menggunakan JSP yang akan memanggil web services dengan SOAP dan REST.

## Anggota Tim
* Ahmad Fajar Prasetyo 13514053
* Adam Rotal Yuliandaru 13514091
* Dandu Satyanuraga 13515601

### Penjelasan
- Basis data dari sistem yang Anda buat.
> Basisdata yang digunakan dalam sistem ini adalah MySQL. Dengan terbagi menjadi 2 yaitu marketplace dan service. Database marketplace menyimpan data-data produk. Sedangkan service menyimpan data-data user.

- Konsep *shared session* dengan menggunakan REST.
> Setiap melakukan aktifitas token akan dikirim ke REST dan REST akan mengembalikan TRUE atau FALSE. REST akan mengembalikan TRUE jika token valid. REST akan mengembalikan FALSE jika token invalid atau expired.

- Pembangkitan token dan expire time pada sistem yang anda buat.
> Token dibangkitkan ketika melakukan login. Akan diberi String acak sepanjang 15. Dan expired time diberikan 5 menit setelah login. Dan expired time akan diperbarui setiap user melakukan aktivitas dalam web. Jadi user tidak akan terlogout secara tiba-tiba ketika melakukan aktivitasnya dalam web.

- Kelebihan dan kelemahan dari arsitektur aplikasi tugas ini, dibandingkan dengan aplikasi monolitik (login, CRUD DB, dll jadi dalam satu aplikasi)
> Kelebihan:
> - Untuk Web Service nya dapat diakses dari berbagai platfrom.
> - Server dapat dibagi jadi kerja setiap server bisa lebih ringan.
>
> Kelemahan:
> - Untuk komunikasi setiap server menggunakan network, hal ini menyebabkan server akan berkerja lebih lambat dan bandwidth akan terpakai.

### Pembagian Tugas

REST :
1. Fungsionalitas database : 13514053
2. General Constant : 13514053
3. REST Full Address : 13514091
4. REST Full Name : 13514091
5. REST ID User : 13514053
6. REST Login : 13514053
7. REST Logout : 13514053
8. REST Phone Number : 13515601
9. REST Postal Code : 13515601
10. REST Register : 13514053
11. REST Token : 13514053
12. REST User : 13514091
13. REST User By ID : 13514091
14. Token Generator : 13514053


SOAP :
1. Web Service Add Produk : 13514091
2. Web Service Catalog : 13514053
3. Web Service Database : 13514053
4. Web Service Sales : 13515601
5. Web Service Your Product : 13514091

Web app (JSP) :
1. Halaman Login : 13514053
2. Halaman Register : 13514053
3. Halaman Catalog : 13514053
4. Halaman Your Product : 13514091
5. Halaman Add Product : 13514091
6. Halaman Sales : 13514091
7. Halaman Purchase : 13514053
8. Halaman Edit Product : 13515601
9. Halaman Confirmation Purchase : 13515601

## About

Asisten IF3110 2016

Adin | Chairuni | David | Natan | Nilta | Tifani | Wawan | William

Dosen : Yudistira Dwi Wardhana | Riza Satria Perdana
