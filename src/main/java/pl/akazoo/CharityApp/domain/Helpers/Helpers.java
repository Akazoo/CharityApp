package pl.akazoo.CharityApp.domain.Helpers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Helpers {

    public String getCurrentLanguage() {
        return LocaleContextHolder.getLocale().toString();
    }

    public String getMailContent(String emailCategory){

        return"done";
    }
}
