package pl.akazoo.CharityApp.domain.helpers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Helpers {

    @Value("${emails.files.infix}")
    private String infix;
    @Value("${emails.files.path}")
    private String PATH;

    public String getCurrentLanguage() {
        String lang = LocaleContextHolder.getLocale().toString();
        if(lang.indexOf('_') != -1) return lang.substring(0, lang.indexOf('_'));
        return lang;
    }

    public List<String> getMailContent(String emailCategory) {
        Path contentPath = getFilePath();
        String emailTitle = "[" + emailCategory + "]";
        List<String> emailContent = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(contentPath)) {
            String line;
            boolean save = false;
            while ((line = reader.readLine()) != null) {
                if (save) {
                    if (line.startsWith("[")) break;
                    emailContent.add(line);
                }
                if (line.startsWith(emailTitle)) save = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emailContent;
    }

    private Path getFilePath() {
        String lang = getCurrentLanguage();
        return Paths.get(PATH + infix + lang);
    }
}