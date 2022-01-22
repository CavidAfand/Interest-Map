package az.interestmap.interestmap.service;

import az.interestmap.interestmap.constant.Language;

public interface MessageProviderService {

    String getMessage(String message, Language lang);

    String getMessage(String message);


}
