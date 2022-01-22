package az.interestmap.interestmap.controller;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.dto.StatusDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/status")
    public ServiceResponse<StatusDTO> getStatus() {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setStatus("UP");
        return ServiceResponse.getSuccessfulResponse(statusDTO);
    }

}
