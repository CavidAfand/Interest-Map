package az.interestmap.interestmap.controller;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.dto.repo.CategoryDTO;
import az.interestmap.interestmap.dto.repo.InterestDTO;
import az.interestmap.interestmap.service.CategoryService;
import az.interestmap.interestmap.service.InterestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InterestController {

    private final CategoryService categoryService;
    private final InterestService interestService;

    public InterestController(CategoryService categoryService, InterestService interestService) {
        this.categoryService = categoryService;
        this.interestService = interestService;
    }

    @GetMapping("/categories")
    public ServiceResponse<List<CategoryDTO>> getCategories(@RequestHeader("Authorization") String token,
                                                            @RequestHeader("Accept-Language") String language) {
        List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();
        return ServiceResponse.getSuccessfulResponse(categoryDTOList);
    }

    @GetMapping("/categories/{categoryId}/interests")
    public ServiceResponse<List<InterestDTO>> getInterests(@RequestHeader("Authorization") String token,
                                                           @RequestHeader("Accept-Language") String language,
                                                           @PathVariable("categoryId") Long id) {
        CategoryDTO categoryDTO = categoryService.getCategory(id);
        List<InterestDTO> interestDTOList = interestService.getInterestList(categoryDTO);
        return ServiceResponse.getSuccessfulResponse(interestDTOList);
    }

}
