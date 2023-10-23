package dev.jgranizo.inditex.launcher;

import dev.jgranizo.inditex.launcher.error.ErrorType;
import dev.jgranizo.inditex.definition.model.ErrorDefinition;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.METHOD_NOT_ALLOWED.getCode());
        error.setMessage("Method: " + request.getContextPath() + " is not supported");
        return new ResponseEntity<>(error, ErrorType.METHOD_NOT_ALLOWED.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.UNSUPPORTED_MEDIA_TYPE.getCode());
        error.setMessage("Content-Type: " + request.getHeader("Content-Type") + " is not supported");
        return new ResponseEntity<>(error, ErrorType.UNSUPPORTED_MEDIA_TYPE.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.UNSUPPORTED_MEDIA_TYPE.getCode());
        error.setMessage("Content-Type: " + request.getHeader("Content-Type") + " is not supported");
        return new ResponseEntity<>(error, ErrorType.UNSUPPORTED_MEDIA_TYPE.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.BAD_REQUEST.getCode());
        error.setMessage("Missing path variable: " + ex.getVariableName());
        return new ResponseEntity<>(error, ErrorType.BAD_REQUEST.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.BAD_REQUEST.getCode());
        error.setMessage("Missing request parameter: " + ex.getParameterName());
        return new ResponseEntity<>(error, ErrorType.BAD_REQUEST.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.BAD_REQUEST.getCode());
        error.setMessage("Missing request part: " + ex.getRequestPartName());
        return new ResponseEntity<>(error, ErrorType.BAD_REQUEST.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.BAD_REQUEST.getCode());
        error.setMessage("Request binding exception: " + ex.getLocalizedMessage());
        return new ResponseEntity<>(error, ErrorType.BAD_REQUEST.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.BAD_REQUEST.getCode());
        error.setMessage("Method argument not valid: " + ex.getLocalizedMessage());
        return new ResponseEntity<>(error, ErrorType.BAD_REQUEST.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.NOT_FOUND.getCode());
        error.setMessage("The requested resource was not found.");
        return new ResponseEntity<>(error, ErrorType.NOT_FOUND.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.INTERNAL_SERVER_ERROR.getCode());
        error.setMessage("Async request timeout exception: " + ex.getLocalizedMessage());
        return new ResponseEntity<>(error, ErrorType.INTERNAL_SERVER_ERROR.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleErrorResponseException(ErrorResponseException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.INTERNAL_SERVER_ERROR.getCode());
        error.setMessage("Error response exception: " + ex.getLocalizedMessage());
        return new ResponseEntity<>(error, ErrorType.INTERNAL_SERVER_ERROR.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.INTERNAL_SERVER_ERROR.getCode());
        error.setMessage("Conversion not supported: " + ex.getLocalizedMessage());
        return new ResponseEntity<>(error, ErrorType.INTERNAL_SERVER_ERROR.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.BAD_REQUEST.getCode());
        error.setMessage("Type mismatch: " + ex.getLocalizedMessage());
        return new ResponseEntity<>(error, ErrorType.BAD_REQUEST.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.BAD_REQUEST.getCode());
        error.setMessage(ex.getLocalizedMessage());
        return new ResponseEntity<>(error, ErrorType.BAD_REQUEST.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.INTERNAL_SERVER_ERROR.getCode());
        error.setMessage("Http message not writable: " + ex.getLocalizedMessage());
        return new ResponseEntity<>(error, ErrorType.INTERNAL_SERVER_ERROR.getHttpStatus());
    }

    @Override
    protected ProblemDetail createProblemDetail(Exception ex, HttpStatusCode status, String defaultDetail, String detailMessageCode, Object[] detailMessageArguments, WebRequest request) {
        return super.createProblemDetail(ex, status, defaultDetail, detailMessageCode, detailMessageArguments, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        ErrorDefinition error = new ErrorDefinition();
        error.setCode(ErrorType.INTERNAL_SERVER_ERROR.getCode());
        error.setMessage("Internal server error: " + ex.getLocalizedMessage());
        return new ResponseEntity<>(error, ErrorType.INTERNAL_SERVER_ERROR.getHttpStatus());
    }
}
