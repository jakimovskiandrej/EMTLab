package mk.ukim.finki.wp.lab1b.service.domain;

import mk.ukim.finki.wp.lab1b.model.domain.Host;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface HostService {
    Optional<Host> findById(Long id);

    List<Host> findAll();

    Host create(Host host);

    Optional<Host> update(Long id, Host host);

    Optional<Host> deleteById(Long id);

    Page<Host> findAll(int page, int size, String sortBy);
}
