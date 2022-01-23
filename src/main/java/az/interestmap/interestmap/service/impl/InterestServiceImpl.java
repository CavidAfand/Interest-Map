package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.constant.Language;
import az.interestmap.interestmap.dto.repo.CategoryDTO;
import az.interestmap.interestmap.dto.repo.InterestDTO;
import az.interestmap.interestmap.entity.Category;
import az.interestmap.interestmap.entity.Interest;
import az.interestmap.interestmap.repository.InterestRepository;
import az.interestmap.interestmap.service.InterestService;
import az.interestmap.interestmap.service.ObjectMapService;
import org.apache.tomcat.jni.Local;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InterestServiceImpl implements InterestService {

    private final InterestRepository interestRepository;
    private final ObjectMapService objectMapService;

    public InterestServiceImpl(InterestRepository interestRepository,
                               ObjectMapService objectMapService) {
        this.interestRepository = interestRepository;
        this.objectMapService = objectMapService;
    }

    @Override
    public List<InterestDTO> getInterestList(CategoryDTO categoryDTO) {
        Category category = objectMapService.getCategoryEntityFromDTO(categoryDTO);
        List<Interest> interestList = interestRepository.getInterestsByCategory(category);
        List<InterestDTO> interestDTOList = interestList.stream()
                .map(interest -> objectMapService.getInterestDTOFromEntity(interest, Language.valueOf(LocaleContextHolder.getLocale().getLanguage())))
                .collect(Collectors.toList());
        return interestDTOList;
    }

    @Override
    public InterestDTO getInterestById(Long id) {
        Interest interest = interestRepository.getInterestByInterestId(id);
        return objectMapService.getInterestDTOFromEntity(interest, Language.valueOf(LocaleContextHolder.getLocale().getLanguage()));
    }

}
