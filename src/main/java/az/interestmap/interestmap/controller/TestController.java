package az.interestmap.interestmap.controller;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.dto.StatusDTO;
import az.interestmap.interestmap.entity.Category;
import az.interestmap.interestmap.entity.Interest;
import az.interestmap.interestmap.repository.CategoryRepository;
import az.interestmap.interestmap.repository.InterestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final CategoryRepository categoryRepository;
    private final InterestRepository interestRepository;

    public TestController(CategoryRepository categoryRepository, InterestRepository interestRepository) {
        this.categoryRepository = categoryRepository;
        this.interestRepository = interestRepository;
    }

    @GetMapping("/status")
    public ServiceResponse<StatusDTO> getStatus() {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setStatus("UP");
        return ServiceResponse.getSuccessfulResponse(statusDTO);
    }

}
