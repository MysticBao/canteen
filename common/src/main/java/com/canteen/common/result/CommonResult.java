package com.canteen.common.result;

/**
 * Contains status code, message and data
 *
 * @param <T>
 */
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    protected CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    protected CommonResult(int code, String message) {
        this(code, message, null);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResult<T> fail(IErrorCode error) {
        return new CommonResult(error.getCode(), error.getMessage());
    }

}
