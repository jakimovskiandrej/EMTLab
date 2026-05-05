package mk.ukim.finki.wp.lab1b.service.domain.impl;

import mk.ukim.finki.wp.lab1b.model.domain.AuthLog;
import mk.ukim.finki.wp.lab1b.repository.AuthLogRepository;
import mk.ukim.finki.wp.lab1b.service.domain.AuthLogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthLogServiceImpl implements AuthLogService {

    private final AuthLogRepository authLogRepository;

    public AuthLogServiceImpl(AuthLogRepository authLogRepository) {
        this.authLogRepository = authLogRepository;
    }

    @Override
    public List<AuthLog> findAll() {
        return authLogRepository.findAll();
    }
}