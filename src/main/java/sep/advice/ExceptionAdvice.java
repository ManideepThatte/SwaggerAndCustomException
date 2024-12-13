package sep.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sep.exception.EmployeeIdNotFoundException;
import sep.exception.ErrorResponse;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(EmployeeIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeIDException(EmployeeIdNotFoundException ex){
        //return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        ErrorResponse res = new ErrorResponse();
        res.setDate(LocalDateTime.now());
        res.setMesg(ex.getMessage());
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(404));
    }
}
