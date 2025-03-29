package app.web.dto;

import app.model.model.Subject;
import app.model.model.Support;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class SurveyRequest {

    @NotNull
    private UUID userId;

    @NotBlank
    private Subject subject;

    @NotBlank
    private Support support;


}
