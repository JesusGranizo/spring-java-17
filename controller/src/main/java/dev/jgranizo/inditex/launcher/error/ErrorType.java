package dev.jgranizo.inditex.launcher.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {

    // Common errors //
    BAD_REQUEST("0x0001", "Bad request", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("0x0002", "Unauthorized", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("0x0003", "Forbidden", HttpStatus.FORBIDDEN),
    NOT_FOUND("0x0004", "Not found", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("0x0005", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    UNSUPPORTED_MEDIA_TYPE("0x0006", "Unsupported media type", HttpStatus.UNSUPPORTED_MEDIA_TYPE),
    INVALID_PARAMETERS("0x0007", "Invalid parameters", HttpStatus.BAD_REQUEST),
    METHOD_NOT_ALLOWED("0x0008", "Method not allowed", HttpStatus.METHOD_NOT_ALLOWED),

    // Specific errors //
    BRAND_NOT_FOUND("0x0100", "Brand not found", HttpStatus.NOT_FOUND),
    PRODUCT_NOT_FOUND("0x0101", "Product not found", HttpStatus.NOT_FOUND),
    ;

    private final String code;

    private final String message;

    private final HttpStatus httpStatus;

    ErrorType(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
