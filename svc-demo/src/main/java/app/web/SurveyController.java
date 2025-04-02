package app.web;




import app.model.model.Subject;
import app.model.model.Support;

import app.model.model.Survey;
import app.model.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }




    @PostMapping
    public ResponseEntity<Void> createSupportRequest(@RequestParam UUID userId,
                                                     @RequestParam Subject subject,
                                                     @RequestParam Support support) {
        try {
            // Извикване на услугата за създаване на нов SupportRequest
            surveyService.createSupportRequest(userId, subject, support);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Survey>> getAllSupportRequests() {

        List<Survey> supportRequests = surveyService.getAllSupportRequests();
        if (supportRequests.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {

            return ResponseEntity.status(HttpStatus.OK).body(supportRequests);
        }
    }
}
