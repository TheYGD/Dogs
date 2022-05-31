package pl.fidiym.demo.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.fidiym.demo.support.exceptions.ErrorMessageResponse;
import pl.fidiym.demo.support.exceptions.DogNotFoundException;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class DogExceptionAdvisor {

    private final Logger LOG = LoggerFactory.getLogger(DogExceptionAdvisor.class);

    @ExceptionHandler(DogNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse itemNotFound(DogNotFoundException e) {
        LOG.error(e.getMessage(), e);
        return new ErrorMessageResponse(e.getLocalizedMessage());
    }

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse invalidDateParse(DateTimeParseException e) {
        LOG.error(e.getMessage(), e);
        return new ErrorMessageResponse(e.getLocalizedMessage());
    }
}
