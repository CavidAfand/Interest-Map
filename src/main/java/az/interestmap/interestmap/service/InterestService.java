package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.repo.CategoryDTO;
import az.interestmap.interestmap.dto.repo.InterestDTO;

import java.util.List;

public interface InterestService {

    List<InterestDTO> getInterestList(CategoryDTO categoryDTO);

    InterestDTO getInterestById(Long id);

}
