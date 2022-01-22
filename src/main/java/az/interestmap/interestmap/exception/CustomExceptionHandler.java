package az.interestmap.interestmap.exception;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.service.MessageProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    private final MessageProviderService messageProviderService;

    public CustomExceptionHandler(MessageProviderService messageProviderService) {
        this.messageProviderService = messageProviderService;
    }

    @ExceptionHandler({ExistedUsernameException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ServiceResponse getErrorResponse(ExistedUsernameException ex) {
        log.error("ExistedUsername exception");
        ServiceResponse serviceResponse = ServiceResponse.getErrorResponse("400", messageProviderService.getMessage("error.existed_username"));
        return serviceResponse;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServiceResponse getErrorResponse(Exception ex) {
        log.error("", ex);
        ServiceResponse serviceResponse = ServiceResponse.getErrorResponse("500", messageProviderService.getMessage("error.technical"));
        return serviceResponse;
    }

}
