package raf.servis_3.com.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationDto {
    private String emailTo;
    private Long clientId;
    private NotificationType notificationType;

    public NotificationDto(String emailTo, NotificationType notificationType) {
        this.emailTo = emailTo;
        this.notificationType = notificationType;
    }

    public NotificationDto() {
    }
}
