package pl.akazoo.CharityApp.domain.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ConfirmAccMessage {

    private String to;
    private String text;

}
