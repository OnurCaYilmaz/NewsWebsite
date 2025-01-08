# 📰 Haber Portalı Projesi

## 📋 İçindekiler
1. [Proje Hakkında](#proje-hakkında)
2. [Özellikler](#özellikler)
3. [Gereksinimler](#gereksinimler)
4. [Kurulum](#kurulum)
5. [Çalıştırma](#çalıştırma)
6. [Sorun Giderme](#sorun-giderme)
7. [Proje Yapısı](#proje-yapısı)

## 🎯 Proje Hakkında
Modern ve kullanıcı dostu bir haber portalı web uygulaması. Spring Boot ve SQL Server kullanılarak geliştirilmiştir. Responsive tasarımı sayesinde tüm cihazlarda sorunsuz çalışır.

## ✨ Özellikler
- 🎨 Modern ve responsive tasarım
- ✏️ Haber ekleme, düzenleme ve silme
- 📁 Kategori sistemi (Spor, Ekonomi, Teknoloji)
- 🔍 Arama özelliği
- 🎞️ Slider (son haberler için)
- 🖼️ Resim desteği
- 📱 Mobil uyumlu tasarım

## 📌 Gereksinimler
- ☕ Java JDK 17
- 💾 Microsoft SQL Server 2022
- 📝 Visual Studio Code
- 🔧 VS Code Eklentileri:
  - Spring Boot Extension Pack
  - Java Extension Pack

## 🚀 Kurulum

### 1️⃣ Java JDK 17 Kurulumu
1. [Java JDK 17'yi indirin](https://www.oracle.com/java/technologies/downloads/#java17)
2. Kurulumu tamamlayın
3. Sistem ortam değişkenlerinde JAVA_HOME'u ayarlayın:
   - Windows tuşu + R > sysdm.cpl > Gelişmiş > Ortam Değişkenleri
   - Sistem değişkenleri > Yeni
   - JAVA_HOME = JDK kurulum yolu (örn: C:\\Program Files\\Java\\jdk-17)

### 2️⃣ SQL Server Kurulumu
1. **SQL Server Kurulumu**
   - [SQL Server 2022'yi indirin](https://www.microsoft.com/en-us/sql-server/sql-server-downloads)
   - "Basic" kurulum seçeneğini seçin
   - Kurulum tamamlanana kadar bekleyin

2. **SQL Server Management Studio (SSMS) Kurulumu**
   - [SSMS'i indirin](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms)
   - Kurulumu tamamlayın

3. **SQL Server Ayarları**
   - SQL Server Configuration Manager'ı açın
   - SQL Server Network Configuration > Protocols
   - TCP/IP'yi etkinleştirin
   - SQL Server servisi yeniden başlatın

4. **Authentication Ayarları**
   - SSMS'i açın
   - Sunucuya sağ tıklayın > Properties
   - Security > SQL Server and Windows Authentication
   - Sunucuyu yeniden başlatın

5. **SA Kullanıcısı Ayarları**
   - Security > Logins > sa
   - Properties > Status > Enabled
   - Şifre: 123

6. **Veritabanı Oluşturma**
   - New Database > newswebsite
   - OK'a tıklayın

### 3️⃣ VS Code Kurulumu
1. [VS Code'u indirin](https://code.visualstudio.com/download)
2. Eklentileri yükleyin:
   - Spring Boot Extension Pack
   - Java Extension Pack

## 💻 Çalıştırma

1. **Proje Dosyalarını Açma**
   - VS Code > File > Open Folder
   - Proje klasörünü seçin

2. **Bağımlılıkların Yüklenmesi**
   - Maven bağımlılıkları otomatik indirilecek
   - İndirme işlemi birkaç dakika sürebilir

3. **Veritabanı Bağlantı Ayarları**
   ```properties
   # application.properties
   spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=newswebsite;encrypt=false
   spring.datasource.username=sa
   spring.datasource.password=123456
   ```

4. **Projeyi Başlatma**
   - Sol alttaki Spring Boot Dashboard'ı açın
   - ▶️ (play) butonuna tıklayın
   - `http://localhost:8080` adresine gidin

## ❗ Sorun Giderme

### Veritabanı Sorunları
- ✔️ SQL Server servisinin çalıştığından emin olun
- ✔️ TCP/IP protokolünün aktif olduğunu kontrol edin
- ✔️ SA kullanıcısının aktif ve şifresinin doğru olduğunu kontrol edin
- ✔️ Veritabanının oluşturulduğundan emin olun

### Port Sorunları
- ✔️ 8080 portunun müsait olduğunu kontrol edin
- ✔️ Gerekirse application.properties'den port değiştirin:
  ```properties
  server.port=8081
  ```

### Maven Sorunları
- ✔️ İnternet bağlantınızı kontrol edin
- ✔️ VS Code'u yeniden başlatın
- ✔️ Proje klasörünü kapatıp yeniden açın

## 📁 Proje Yapısı
```
src/main/
├── java/com/newswebsite/newswebsite/
│   ├── controller/    # Web istekleri kontrolü
│   ├── model/        # Veritabanı modelleri
│   ├── repository/   # Veritabanı işlemleri
│   └── service/      # İş mantığı
└── resources/
    ├── static/       # CSS, JS dosyaları
    └── templates/    # HTML şablonları
```

## 📄 Lisans
Bu proje MIT lisansı altında lisanslanmıştır.
