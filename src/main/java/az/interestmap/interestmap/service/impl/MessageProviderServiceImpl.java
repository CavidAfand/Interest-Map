package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.constant.Language;
import az.interestmap.interestmap.service.MessageProviderService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageProviderServiceImpl implements MessageProviderService {

    private final MessageSource messageSource;

    public MessageProviderServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String message, Language lang) {
        String langName = "null";
        if (lang != null)
            langName = lang.name();
        return messageSource.getMessage(message, null, new Locale(langName));
    }

    @Override
    public String getMessage(String message) {
        return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
    }
}
