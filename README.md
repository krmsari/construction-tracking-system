# Construction Tracking System 🏗️

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [JJWT - JSON Web Token](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt)
* [Kotlin Reflect](https://kotlinlang.org/docs/reflection.html)
* [Kotlin STD Lib](https://kotlinlang.org/api/latest/jvm/stdlib/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.2/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.2/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.2/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/3.4.2/reference/web/spring-security.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.2/reference/web/servlet.html)

_____________

<H3>PROJE DETAYI</H3>

**Mikroservis mimarisine** sahip, **Java** ve **Kotlin**’in hibrid şekilde kullanıldığı bu proje, inşaat projelerinin takibini sağlamak amacıyla geliştirilmiş web tabanlı bir sistemdir. Kullanıcılar, projelerin ilerleyişini, sorumlu kişileri ve kritik aşamaları takip edebilir.

Projede, veri yönetimini optimize etmek ve bağımlılığı azaltmak için **Kotlin** data class kullanılmıştır. Bu sayede, sistemde daha esnek ve ölçeklenebilir bir varlık yönetimi sağlanmıştır. Güvenli kimlik doğrulama OAuth2 protokolü ile gerçekleştirilmiş olup, kullanıcı yetkilendirme süreçleri güvenilir hale getirilmiştir.

**Jav**a ve **Spring Boot** ile geliştirilen **RESTful API** sayesinde sistem, hem web hem de mobil platformlarda sorunsuz çalışabilmektedir. Mikroservis mimarisi sayesinde ölçeklenebilirlik artırılmış, bağımsız servisler ile sistem modüler hale getirilmiştir.
______________

## Özellikler ✨
### 1. İnşaat Projesi Oluşturma
- **İnşaat Özellikleri:**
    - Proje adı, açıklama, lokasyon
    - Başlangıç/Bitiş tarihi

      [//]: # (  - Bütçe ve öncelik seviyesi)
    - Proje durumu (`Planlandı`, `Devam Ediyor`, `Tamamlandı`, `Askıda`

### 2.Kullanıcı Oluşturma 👤
- **Kullanıcı Bilgileri:**
    - Ad, soyad, e-posta, (?)telefon
    - Kullanıcı e-posta, şifre
    - Kullanıcı rolü (`ADMIN`,`MÜTEAHHİT` ,`PROJE_YÖNETİCISI`,`MÜHENDİS`,`İŞÇİ`)

### 3. Sorumlu Kişi Atama 👥
- Proje yöneticisi, müteahhitler ve ekipler atayın
- Kullanıcı rolleri (`ADMIN`,`MÜTEAHHİT` ,`PROJE_YÖNETİCISI`,`MÜHENDİS`,`İŞÇİ`)
- İletişim bilgileri (e-posta, (?)telefon )

### 4. İlerleme Takibi 📊

[//]: # (- Aşama bazlı tamamlanma yüzdesi)
[//]: # (- Günlük/haftalık ilerleme raporları)
[//]: # (- Kilometre taşı takibi)
- Gerçek zamanlı güncellemeler

## Kurulum 🔧
### Gereksinimler
- Java 17+
- Maven
- PostgreSQL 14+

### Adımlar
1. Repoyu klonlayın:
   ```bash
   git clone https://github.com/krmsari/construction-tracking-system.git
   ```
2. Veritabanını yapılandırın:
    ```yaml
    spring.datasource.url=jdbc:postgresql://localhost:5432/construction_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
     ```
3. Projeyi derleyin ve çalıştırın:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
