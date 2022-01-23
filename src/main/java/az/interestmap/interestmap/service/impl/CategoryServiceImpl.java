package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.constant.Language;
import az.interestmap.interestmap.dto.repo.CategoryDTO;
import az.interestmap.interestmap.entity.Category;
import az.interestmap.interestmap.repository.CategoryRepository;
import az.interestmap.interestmap.service.CategoryService;
import az.interestmap.interestmap.service.ObjectMapService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ObjectMapService objectMapService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ObjectMapService objectMapService) {
        this.categoryRepository = categoryRepository;
        this.objectMapService = objectMapService;
    }

    @Override
    public List<CategoryDTO> getCategoryList() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = categoryList.stream()
                .map(category -> objectMapService.getCategoryDTOFromEntity(category, Language.valueOf(LocaleContextHolder.getLocale().getLanguage())))
                .collect(Collectors.toList());
        return categoryDTOList;
    }

}
