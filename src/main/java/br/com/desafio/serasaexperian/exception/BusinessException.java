package br.com.desafio.serasaexperian.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Long timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public static BusinessExceptionBody of(int status, String error, String message, String path) {
        return BusinessExceptionBody.builder().timestamp(System.currentTimeMillis()).status(status).error(error).message(String.format(message)).path(path).build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BusinessExceptionBody {
        private Long timestamp;
        private int status;
        private String error;
        private String message;
        private String path;
    }
}
