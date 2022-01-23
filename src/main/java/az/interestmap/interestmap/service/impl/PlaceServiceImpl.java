package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.repository.PlaceRepository;
import az.interestmap.interestmap.service.PlaceService;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


}
