package pl.akazoo.CharityApp.domain.helpers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Helpers {

    @Value("${emails.files.infix}")
    private String infix;

    public String getCurrentLanguage() {
        return LocaleContextHolder.getLocale().toString();
    }

    public List<String> getMailContent(String emailCategory) {
        String lang = getCurrentLanguage();
        List<String> emailContent = new ArrayList<>();


        return emailContent;
    }
}