package raf.servis_3.com.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotifyDto {
    String body, subject, email;

    public NotifyDto(String body, String subject, String email) {
        this.body = body;
        this.subject = subject;
        this.email = email;
    }
}
