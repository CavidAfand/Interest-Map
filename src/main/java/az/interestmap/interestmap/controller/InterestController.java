package az.interestmap.interestmap.controller;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.dto.repo.CategoryDTO;
import az.interestmap.interestmap.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InterestController {

    private final CategoryService categoryService;

    public InterestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ServiceResponse<List<CategoryDTO>> getCategories(@RequestHeader("Authorization") String authorization,
                                                            @RequestHeader("Accept-Language") String language) {
        List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
        return ServiceResponse.getSuccessfulResponse(categoryDTOList);
    }

}
