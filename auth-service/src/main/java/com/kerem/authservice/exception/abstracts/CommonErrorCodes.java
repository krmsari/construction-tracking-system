package com.kerem.authservice.exception.abstracts;

public enum CommonErrorCodes implements ErrorCode{

    AUTHENTICATION_FAILED("AUTH_001", "Kimlik doğrulama başarısız. Geçersiz kimlik bilgileri."),
    USER_NOT_FOUND("USER_001", "Kullanıcı bulunamadı."),
    DATABASE_ERROR("DB_001", "Veritabanına erişilirken bir hata oluştu."),
    INVALID_INPUT("VALID_001", "Geçersiz giriş sağlandı."),
    CONSTRUCTION_NOT_FOUND("CONST_001", "İnşaat projesi bulunamadı."),
    ROLE_NOT_FOUND("ROLE_001", "Rol bulunamadı."),
    ROLE_ALREADY_EXISTS("ROLE_002", "Rol zaten mevcut."),
    USER_ALREADY_EXISTS("USER_002", "Kullanıcı zaten mevcut."),
    USER_NOT_ACTIVE("USER_003", "Kullanıcı aktif değil."),
    EMAIL_OR_PASSWORD_WRONG("AUTH_002", "E-posta veya şifre yanlış."),
    INVALID_TOKEN("AUTH_003","Geçersiz token.")


    ;

    private final String code;
    private final String message;

    CommonErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
