challenge 7

penambahan antara lain:
1) implementasi microservice yang sebelumnya monolitic
    microservices diterapkan dengan membuat beberapa aplikasi kecil antara lain yaitu:
    a) binarfood dengan port 8080
        digunakan sebagai aplikasi utama dengan fitur yang ada di challenge 6 ditambah implementasi kafka
    b) socketio-chat dengan port 8877
        digunakan sebagai implementasi socketIO
    c) transaksi dengan port 8083
        digunakan sebagai aplikasi untuk pengetesan microservices yang memanggil controller di binarfud dan socketio melalui resttemplate
    d) spring-Gateway dengan port 8085
        digunakan sebagai implementasi spring gateway yang dapat mengakses aplikasi binarfud, socketio-chat dan transaksi
