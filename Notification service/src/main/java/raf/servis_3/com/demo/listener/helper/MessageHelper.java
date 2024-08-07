package raf.servis_3.com.demo.listener.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.IOException;

@Component
public class MessageHelper {
    private ObjectMapper objectMapper;

    public MessageHelper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> T getMessage(String message, Class<T> clazz) throws RuntimeException, JMSException {
        try {
            System.out.println(message);
            T data = objectMapper.readValue(message, clazz);

            return data;
        } catch (IOException exception) {
            throw new RuntimeException("Message parsing fails.", exception);
        }
    }
}
