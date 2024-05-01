package test.MOAIS.common.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

        private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        private ErrorMessageCode errorMessagerCode = ErrorMessageCode.ERROR;

//        public CustomException(String message) {
//            super(message);
//        }

        public CustomException(String message, HttpStatus httpStatus) {
            super(message);
            this.httpStatus = httpStatus;
        }

//        public CustomException(String message, HttpStatus httpStatus, ErrorMessageCode errorMessagerCode) {
//            super(message);
//            this.httpStatus = httpStatus;
//            this.errorMessagerCode = errorMessagerCode;
//        }
//
//        public CustomException(String message, ErrorMessageCode errorMessagerCode) {
//            super(message);
//            this.errorMessagerCode = errorMessagerCode;
//        }
//
//        public CustomException(ErrorMessageCode errorMessagerCode) { this.errorMessagerCode = errorMessagerCode; }
        public HttpStatus getHttpStatus() { return this.httpStatus; }
}
