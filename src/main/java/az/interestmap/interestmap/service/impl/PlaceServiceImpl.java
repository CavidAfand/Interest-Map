package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.constant.Language;
import az.interestmap.interestmap.dto.controller.response.ClientSearchResponseDTO;
import az.interestmap.interestmap.dto.controller.response.CoordsDTO;
import az.interestmap.interestmap.dto.repo.InterestDTO;
import az.interestmap.interestmap.dto.repo.PlaceDTO;
import az.interestmap.interestmap.entity.Place;
import az.interestmap.interestmap.repository.PlaceRepository;
import az.interestmap.interestmap.service.ObjectMapService;
import az.interestmap.interestmap.service.PlaceService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

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

    @Override
    public List<ClientSearchResponseDTO> searchInterestingPlaces(double userLatitude, double userLongitude,
                                                                 List<InterestDTO> userInterestList) {
        // FIXME vaxt qıtlığından hesablama əvəzinə mock datalar generate olundu.
        Random random = new Random();
        double value1 = random.nextDouble() / 100;
        double value2 = random.nextDouble() / 100;

        ClientSearchResponseDTO clientSearchResponseDTO1 = new ClientSearchResponseDTO();
        CoordsDTO coordsDTO1 = new CoordsDTO();
        coordsDTO1.setLat(String.valueOf(userLatitude + value1));
        coordsDTO1.setLng(String.valueOf(userLongitude + value2));
        clientSearchResponseDTO1.setCoords(coordsDTO1);
        clientSearchResponseDTO1.setTitle("E-karyera mərkəzi");
        clientSearchResponseDTO1.setDescription("Sevimli book kafe");
        clientSearchResponseDTO1.setDiscount(10);
        clientSearchResponseDTO1.setId(UUID.randomUUID().toString());

        value1 = random.nextDouble() / 100;
        value2 = random.nextDouble() / 100;

        ClientSearchResponseDTO clientSearchResponseDTO2 = new ClientSearchResponseDTO();
        CoordsDTO coordsDTO2 = new CoordsDTO();
        coordsDTO2.setLat(String.valueOf(userLatitude + value1));
        coordsDTO2.setLng(String.valueOf(userLongitude - value2));
        clientSearchResponseDTO2.setCoords(coordsDTO2);
        clientSearchResponseDTO2.setTitle("Sağlamlıq futbol meydançası");
        clientSearchResponseDTO2.setDescription("Hər gün 10:00-dan 16:00-dək açıqdır.");
        clientSearchResponseDTO2.setDiscount(1);
        clientSearchResponseDTO2.setId(UUID.randomUUID().toString());

        value1 = random.nextDouble() / 100;
        value2 = random.nextDouble() / 100;

        ClientSearchResponseDTO clientSearchResponseDTO3 = new ClientSearchResponseDTO();
        CoordsDTO coordsDTO3 = new CoordsDTO();
        coordsDTO3.setLat(String.valueOf(userLatitude + value1));
        coordsDTO3.setLng(String.valueOf(userLongitude - value2));
        clientSearchResponseDTO3.setCoords(coordsDTO3);
        clientSearchResponseDTO3.setTitle("Məhəllə market");
        clientSearchResponseDTO3.setDescription("Nisyə mal verilmir");
        clientSearchResponseDTO3.setDiscount(0);
        clientSearchResponseDTO3.setId(UUID.randomUUID().toString());

        value1 = random.nextDouble() / 100;
        value2 = random.nextDouble() / 100;

        ClientSearchResponseDTO clientSearchResponseDTO4 = new ClientSearchResponseDTO();
        CoordsDTO coordsDTO4 = new CoordsDTO();
        coordsDTO4.setLat(String.valueOf(userLatitude - value1));
        coordsDTO4.setLng(String.valueOf(userLongitude + value2));
        clientSearchResponseDTO4.setCoords(coordsDTO4);
        clientSearchResponseDTO4.setTitle("Məhəllə market");
        clientSearchResponseDTO4.setDescription("Nisyə mal verilmir");
        clientSearchResponseDTO4.setDiscount(0);
        clientSearchResponseDTO4.setId(UUID.randomUUID().toString());

        return List.of(clientSearchResponseDTO1, clientSearchResponseDTO2, clientSearchResponseDTO3, clientSearchResponseDTO4);
    }

}
