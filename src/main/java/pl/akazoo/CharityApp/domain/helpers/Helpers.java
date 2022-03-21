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
    private String EMAIL_INFIX;
    @Value("${rules.files.infix}")
    private String RULES_INFIX;
    @Value("${emails.files.path}")
    private String EMAIL_PATH;
    @Value("${rules.files.path}")
    private String RULES_PATH;

    public String getCurrentLanguage() {
        String lang = LocaleContextHolder.getLocale().toString();
        if (lang.indexOf('_') != -1) return lang.substring(0, lang.indexOf('_'));
        return lang;
    }

    private Path getFilePath(String content) {
        String lang = getCurrentLanguage();
        if (content.equals("RULES")) return Paths.get(RULES_PATH + RULES_INFIX + lang);
        ;
        return Paths.get(EMAIL_PATH + EMAIL_INFIX + lang);
    }

    public List<String> getMailContent(String emailCategory) {
        Path contentPath = getFilePath("EMAIL");
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

    public List<String> geRulesContent() {
        Path contentPath = getFilePath("RULES");
        List<String> rulesContent = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(contentPath)) {
            String line;
            StringBuilder rule = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("-")) {
                    if (rule.length() != 0) rulesContent.add(rule.toString());
                    rule = new StringBuilder();
                    rule.append(line.substring(1));
                }
                rule.append(line);
            }
            if (rule.length() != 0) rulesContent.add(rule.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rulesContent;
    }
}