# Temel imaj olarak OpenJDK 17 kullanılıyor
FROM openjdk:17-jdk-slim

# Çalışma dizini oluşturuluyor
WORKDIR /app

# Maven build sonucu oluşan JAR dosyası konteynere kopyalanıyor
COPY target/auth-service-0.0.1.jar auth-service.jar

# Uygulama başlatılıyor
ENTRYPOINT ["java", "-jar", "auth-service.jar"]
