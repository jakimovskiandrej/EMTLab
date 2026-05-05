package mk.ukim.finki.wp.lab1b.service.domain;

import mk.ukim.finki.wp.lab1b.model.domain.AuthLog;
import java.util.List;

public interface AuthLogService {
    List<AuthLog> findAll();
}