package com.canteen.common.api;

/**
 * The basic status for each request
 */
public enum ResultCode implements IErrorCode{
    SUCCESS(200, "success"),
    BAD_REQUEST(400, "bad request"),
    NOT_FOUND(404,"not found"),
    UNAUTHORIZED(401, "authorized issue"),
    FORBIDDEN(403, "forbidden operation"),
    INTERNAL_ERROR(500, "internal error");

    private int code;
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
