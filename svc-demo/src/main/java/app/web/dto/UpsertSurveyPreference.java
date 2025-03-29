package app.web.dto;

import app.model.model.Subject;
import app.model.model.Support;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

// DTO = contract
@Data
public class UpsertSurveyPreference {

    @NotNull
    private UUID userId;

    @NotNull
    private Subject subject;

    @NotNull
    private Support support;
}
