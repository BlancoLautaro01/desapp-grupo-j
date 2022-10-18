package ar.edu.unq.desapp.grupoj.desapp.model.inout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String username;
    private String token;
}
