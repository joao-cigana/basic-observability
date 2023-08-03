package dev.cigana.observabilitybasics.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private LocalDateTime moment;

    private List<String> messages = new ArrayList<>();

    private String path;

    private String statusName;

    private int statusCode;

    public ErrorResponse(List<String> messages, HttpStatus httpStatus) {
        this.moment = LocalDateTime.now();
        this.messages = messages;
        this.path = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
        this.statusName = httpStatus.name();
        this.statusCode = httpStatus.value();
    }

    public ErrorResponse(String message, HttpStatus httpStatus) {
        this.moment = LocalDateTime.now();
        this.messages.add(message);
        this.path = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
        this.statusName = httpStatus.name();
        this.statusCode = httpStatus.value();
    }
}
