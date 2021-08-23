package org.selenium.pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.objects.CreateCustomer;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static <T> T deserializeJson(String filePath, Class<T> T) throws IOException {
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is,T);
    }
}
