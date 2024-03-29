package hello.realestateadmin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Response<T> {
    private final boolean success;
    private String message;
    private T data;

    public static <T> Response<T> success(T data) {
        return Response.<T>builder()
                .success(true)
                .data(data)
                .build();
    }

    public static Response<?> error(String message) {
        return Response.builder()
                .success(false)
                .message(message)
                .build();
    }
}
