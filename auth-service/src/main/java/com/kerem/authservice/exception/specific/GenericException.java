package com.kerem.authservice.exception.specific;

import com.kerem.authservice.exception.abstracts.BaseException;
import com.kerem.authservice.exception.abstracts.ErrorCode;

public class GenericException extends BaseException {
    public GenericException(ErrorCode errorCode) {
        super(errorCode);
    }
}
