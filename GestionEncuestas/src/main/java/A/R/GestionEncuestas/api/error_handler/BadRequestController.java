package A.R.GestionEncuestas.api.error_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import A.R.GestionEncuestas.api.dto.errors.ListErrorsResponse;
import A.R.GestionEncuestas.util.exceptions.ResourceNotFoundException;
import A.R.GestionEncuestas.util.exceptions.UnauthorizedException;
import A.R.GestionEncuestas.api.dto.errors.BaseErrorResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class BadRequestController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public A.R.GestionEncuestas.api.dto.errors.BaseErrorResponse handleErrors(MethodArgumentNotValidException exception) {

        List<Map<String, String>> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(e -> {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getDefaultMessage());
            error.put("field", e.getField());
            errors.add(error);
        });

        return ListErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public BaseErrorResponse handleError(BadRequestException exception) {
        List<Map<String, String>> errors = new ArrayList<>();

        Map<String, String> error = new HashMap<>();

        error.put("Message", exception.getMessage());

        errors.add(error);

        return ListErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();

    }


    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseErrorResponse handleBadRequestException(BadRequestException exception) {
        return BaseErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseErrorResponse handleResourceNotFoundException(ResourceNotFoundException exception) {
        return BaseErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseErrorResponse handleUnauthorizedException(UnauthorizedException exception) {
        return BaseErrorResponse.builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .status(HttpStatus.UNAUTHORIZED.name())
                .message(exception.getMessage())
                .build();
    }
}