package test.MOAIS.common.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

        private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        private ErrorMessageCode errorMessagerCode = ErrorMessageCode.ERROR;

        public CustomException(String message, HttpStatus httpStatus) {
            super(message);
            this.httpStatus = httpStatus;
        }
        public HttpStatus getHttpStatus() { return this.httpStatus; }
}
