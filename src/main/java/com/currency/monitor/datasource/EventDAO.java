package com.currency.monitor.datasource;

import com.currency.monitor.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface EventDAO extends JpaRepository<Event, Long> {

    List<Event> findAllByUserId(Long id);

    @Transactional
    void deleteAllByUserId(Long id);
}
