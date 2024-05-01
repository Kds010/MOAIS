package test.MOAIS.common.exception;

public enum ErrorMessageCode {

    SUCCESS(200000, "success"),
    ERROR(500000, "error");

    ErrorMessageCode(final int codeValue, final String messageCode) {
        this.codeValue = codeValue;
        this.responseValue = messageCode;
    }

    private int codeValue;
    private String responseValue;

//    public int getCode() { return codeValue; }
//    public String getResponseValue() { return responseValue; }
}
