package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.constant.Language;
import az.interestmap.interestmap.dto.repo.PlaceDTO;
import az.interestmap.interestmap.entity.Place;
import az.interestmap.interestmap.repository.PlaceRepository;
import az.interestmap.interestmap.service.ObjectMapService;
import az.interestmap.interestmap.service.PlaceService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;
    private final ObjectMapService objectMapService;

    public PlaceServiceImpl(PlaceRepository placeRepository,
                            ObjectMapService objectMapService) {
        this.placeRepository = placeRepository;
        this.objectMapService = objectMapService;
    }

    @Override
    public PlaceDTO savePlace(PlaceDTO placeDTO) {
        Place place = objectMapService.getPlaceEntityFromDTO(placeDTO);
        place = placeRepository.save(place);
        placeDTO = objectMapService.getPlaceDTOFromEntity(place, Language.valueOf(LocaleContextHolder.getLocale().getLanguage()));
        return placeDTO;
    }
}
