package app.model.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
public class SupportRequest {

    @NotNull
    private UUID id;

    @NotNull
    private UUID userId;

    @NotBlank
    private Subject subject;

    @NotBlank
    private Support support;


}




