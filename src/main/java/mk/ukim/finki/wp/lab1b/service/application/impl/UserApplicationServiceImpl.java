package mk.ukim.finki.wp.lab1b.service.application.impl;

import mk.ukim.finki.wp.lab1b.helpers.JwtHelper;
import mk.ukim.finki.wp.lab1b.model.domain.AuthLog;
import mk.ukim.finki.wp.lab1b.model.domain.User;
import mk.ukim.finki.wp.lab1b.model.dto.*;
import mk.ukim.finki.wp.lab1b.repository.AuthLogRepository;
import mk.ukim.finki.wp.lab1b.service.application.UserApplicationService;
import mk.ukim.finki.wp.lab1b.service.domain.UserService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserService userService;
    private final JwtHelper jwtHelper;
    private final AuthLogRepository authLogRepository;

    public UserApplicationServiceImpl(UserService userService,
                                      JwtHelper jwtHelper,
                                      AuthLogRepository authLogRepository) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
        this.authLogRepository = authLogRepository;
    }

    @Override
    public Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto) {
        User user = userService.register(registerUserRequestDto.toUser());
        RegisterUserResponseDto displayUserDto = RegisterUserResponseDto.from(user);
        return Optional.of(displayUserDto);
    }

    @Override
    public Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto) {
        try {
            User user = userService.login(loginUserRequestDto.username(), loginUserRequestDto.password());
            String token = jwtHelper.generateToken(user);

            Date issuedAt = jwtHelper.extractIssuedAt(token);
            Date expiresAt = jwtHelper.extractExpiration(token);
            AuthLog authLog = new AuthLog(user.getUsername(), token, issuedAt, expiresAt);
            authLogRepository.save(authLog);

            return Optional.of(new LoginUserResponseDto(token));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<RegisterUserResponseDto> findByUsername(String username) {
        return userService
                .findByUsername(username)
                .map(RegisterUserResponseDto::from);
    }
}