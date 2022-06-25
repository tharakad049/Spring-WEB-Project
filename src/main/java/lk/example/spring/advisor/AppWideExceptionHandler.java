package lk.example.spring.advisor;

import lk.example.spring.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin
@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandler(Exception e){
        return new ResponseEntity(new ResponseUtil(500, e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
