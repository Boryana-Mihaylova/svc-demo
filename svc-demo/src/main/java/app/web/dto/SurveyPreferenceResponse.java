package app.web.dto;


import app.model.model.Subject;
import app.model.model.Support;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SurveyPreferenceResponse {

    private UUID id;

    private UUID userId;

    private Subject subject;

    private Support support;
}
