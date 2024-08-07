package raf.servis_3.com.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class NotificationType {
    private Long id;
    private String notificationType, subject, body;
}
