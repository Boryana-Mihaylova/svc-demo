package app.web.dto;


import app.model.model.Subject;
import app.model.model.Support;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyResponse {



    private Subject subject;

    private Support support;
}