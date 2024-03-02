package hello.realestateadmin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hello.realestateadmin.domain.entity.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PropertyService {

    private final RedisTemplate<String, String> redisTemplate; // Redis key-value pair
    private final ObjectMapper objectMapper;

    @Autowired
    public PropertyService(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
        // Java 8의 java.time 패키지를 지원하도록 모듈 등록
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public Property getProperty(String key) {
        try {
            String jsonString = redisTemplate.opsForValue().get(key);
            if (jsonString != null) {
                return objectMapper.readValue(jsonString, Property.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception based on your requirements
        }
        return null;
    }

    public List<Property> getAllProperties() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Property> propertyList = new ArrayList<>();

        // Redis에 저장된 모든 키를 가져옵니다.
        Set<String> keys = redisTemplate.keys("*");

        // 각 키에 대한 값을 가져와서 Property 객체로 변환합니다.
        for (String key : keys) {
            String jsonString = redisTemplate.opsForValue().get(key);
            if (jsonString != null) {
                try {
                    Property property = objectMapper.readValue(jsonString, Property.class);
                    propertyList.add(property);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle the exception based on your requirements
                }
            }
        }

        return propertyList;
    }
}