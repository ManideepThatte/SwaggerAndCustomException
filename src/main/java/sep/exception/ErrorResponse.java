package sep.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
public class ErrorResponse {

    private LocalDateTime date;
    private String mesg;
}
