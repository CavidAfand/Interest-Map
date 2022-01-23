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

import java.math.BigDecimal;
import java.util.List;
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

//        System.out.println("User lat: " + userLatitude);
//        System.out.println("user lng: " + userLongitude);

        ClientSearchResponseDTO clientSearchResponseDTO1 = new ClientSearchResponseDTO();
        CoordsDTO coordsDTO1 = new CoordsDTO();
//        coordsDTO1.setLat(String.valueOf(userLatitude + 0.005).substring(0,7));
//        coordsDTO1.setLng(String.valueOf(userLongitude + 0.002).substring(0,7));
//        String lat1 = new BigDecimal(String.valueOf(userLatitude)).add(new BigDecimal("0.005")).toString();
        String lat1 = new BigDecimal(String.valueOf(userLatitude)).toString();
        String lt =  new BigDecimal(String.valueOf(userLatitude)).add(new BigDecimal("0.005")).setScale(3).toPlainString();
        System.out.println("LAT1 = " + lat1);
        System.out.println("lt = " + lt);
        coordsDTO1.setLat(lat1);
        coordsDTO1.setLng(lt);
//        coordsDTO1.setLng(new BigDecimal(String.valueOf(userLongitude)).add(new BigDecimal("0.002")).toString());
//        coordsDTO1.setLng("49.8475");
//        coordsDTO1.setLat("40.3776");
        clientSearchResponseDTO1.setCoords(coordsDTO1);
        clientSearchResponseDTO1.setTitle("E-karyera mərkəzi");
        clientSearchResponseDTO1.setDescription("Sevimli book kafe");
        clientSearchResponseDTO1.setDiscount(10);
        clientSearchResponseDTO1.setId(UUID.randomUUID().toString());

        ClientSearchResponseDTO clientSearchResponseDTO2 = new ClientSearchResponseDTO();
        CoordsDTO coordsDTO2 = new CoordsDTO();
//        coordsDTO2.setLat(String.valueOf(userLatitude + 0.003).substring(0,7));
//        coordsDTO2.setLng(String.valueOf(userLongitude - 0.002).substring(0,7));
        coordsDTO2.setLat(new BigDecimal(String.valueOf(userLatitude)).add(new BigDecimal("0.003")).toString());
        coordsDTO2.setLng(new BigDecimal(String.valueOf(userLongitude)).subtract(new BigDecimal("0.002")).toString());
//        coordsDTO2.setLng("49.8490");
//        coordsDTO2.setLat("40.3790");
        clientSearchResponseDTO2.setCoords(coordsDTO2);
        clientSearchResponseDTO2.setTitle("Sağlamlıq futbol meydançası");
        clientSearchResponseDTO2.setDescription("Hər gün 10:00-dan 16:00-dək açıqdır.");
        clientSearchResponseDTO2.setDiscount(1);
        clientSearchResponseDTO2.setId(UUID.randomUUID().toString());

        ClientSearchResponseDTO clientSearchResponseDTO3 = new ClientSearchResponseDTO();
        CoordsDTO coordsDTO3 = new CoordsDTO();
        coordsDTO3.setLat(String.valueOf(userLatitude + 0.001).substring(0,7));
        coordsDTO3.setLng(String.valueOf(userLongitude - 0.004).substring(0,7));
        clientSearchResponseDTO3.setCoords(coordsDTO3);
        clientSearchResponseDTO3.setTitle("Məhəllə market");
        clientSearchResponseDTO3.setDescription("Nisyə mal verilmir");
        clientSearchResponseDTO3.setDiscount(0);
        clientSearchResponseDTO3.setId(UUID.randomUUID().toString());
/*
        ClientSearchResponseDTO clientSearchResponseDTO4 = new ClientSearchResponseDTO();
        CoordsDTO coordsDTO4 = new CoordsDTO();
        coordsDTO4.setLat(String.valueOf(userLatitude - 0.003).substring(0,7));
        coordsDTO4.setLng(String.valueOf(userLongitude + 0.003).substring(0,7));
        clientSearchResponseDTO4.setCoords(coordsDTO4);
        clientSearchResponseDTO4.setTitle("Məhəllə market");
        clientSearchResponseDTO4.setDescription("Nisyə mal verilmir");
        clientSearchResponseDTO4.setDiscount(0);
        clientSearchResponseDTO4.setId(UUID.randomUUID().toString());
*/
        return List.of(clientSearchResponseDTO1, clientSearchResponseDTO2/*, clientSearchResponseDTO3, clientSearchResponseDTO4*/);
    }
    
}
