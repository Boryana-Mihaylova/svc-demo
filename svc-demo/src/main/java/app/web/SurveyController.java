package app.web;




import app.model.model.Survey;
import app.model.service.SurveyService;
import app.web.dto.SurveyRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/api/v1/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }


    @PostMapping
    public ResponseEntity<Survey> submitSurvey(@RequestBody SurveyRequest surveyRequest) {
        // Връща записаната анкета
        Survey survey = surveyService.submitSurvey(surveyRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(survey);
    }

    @GetMapping("/user-survey")
    public ResponseEntity<Survey> getSurvey(@RequestParam(name = "userId") UUID userId) {

        // Връща анкетата на конкретен потребител
        Survey survey = surveyService.getSurvey(userId);

        return ResponseEntity
                .ok(survey);
    }


}
