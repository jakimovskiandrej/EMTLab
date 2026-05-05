package mk.ukim.finki.wp.lab1b.service.application;

import mk.ukim.finki.wp.lab1b.model.dto.LoginUserRequestDto;
import mk.ukim.finki.wp.lab1b.model.dto.LoginUserResponseDto;
import mk.ukim.finki.wp.lab1b.model.dto.RegisterUserRequestDto;
import mk.ukim.finki.wp.lab1b.model.dto.RegisterUserResponseDto;
import java.util.Optional;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}