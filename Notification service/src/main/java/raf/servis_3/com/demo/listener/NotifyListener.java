package raf.servis_3.com.demo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import raf.servis_3.com.demo.EmailSenderService;
import raf.servis_3.com.demo.dto.NotificationDto;
import raf.servis_3.com.demo.dto.NotifyDto;
import raf.servis_3.com.demo.listener.helper.MessageHelper;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.IOException;

@Component
public class NotifyListener {
    private MessageHelper messageHelper;
    private EmailSenderService senderService;

    public NotifyListener(MessageHelper messageHelper, EmailSenderService senderService) {
        this.messageHelper = messageHelper;
        this.senderService = senderService;
    }

    @JmsListener(destination = "${destination.notify}", concurrency = "5-10")
    public void sendMail(String message) throws JMSException {
        NotificationDto notifyDto = messageHelper.getMessage(message, NotificationDto.class);
        System.out.println("Converted NotifyDto: " + notifyDto);

        senderService.sendMail(notifyDto.getEmailTo(), notifyDto.getNotificationType().getSubject(), notifyDto.getNotificationType().getBody());
    }

}
