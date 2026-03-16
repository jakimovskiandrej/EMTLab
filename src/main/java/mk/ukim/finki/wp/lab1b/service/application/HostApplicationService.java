package mk.ukim.finki.wp.lab1b.service.application;

import mk.ukim.finki.wp.lab1b.model.dto.*;
import java.util.*;

public interface HostApplicationService {
    Optional<DisplayHostDto> findById(Long id);

    List<DisplayHostDto> findAll();

    DisplayHostDto create(CreateHostDto createHostDto);

    Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto);

    Optional<DisplayHostDto> deleteById(Long id);
}
