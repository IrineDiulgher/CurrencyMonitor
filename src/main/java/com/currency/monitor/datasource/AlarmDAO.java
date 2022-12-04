package com.currency.monitor.datasource;

import com.currency.monitor.entities.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AlarmDAO extends JpaRepository<Alarm, Long> {

    List<Alarm> findAllByUserId(Long id);

    @Transactional
    void deleteAllByUserId(Long id);

}
