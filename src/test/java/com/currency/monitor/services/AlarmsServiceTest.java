package com.currency.monitor.services;

import com.currency.monitor.datasource.AlarmDAO;
import com.currency.monitor.entities.Alarm;
import com.currency.monitor.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AlarmsServiceTest {
    @Mock
    private AlarmDAO alarmDAO;
    @InjectMocks
    private AlarmsService alarmsService;
    @Test
    void createAlarm() {
        when(alarmDAO.save(any(Alarm.class))).thenReturn(new Alarm());
        Alarm created =alarmsService.createAlarm("currency",0.00,0.00, new User());
        assertThat(created).isNotNull();
    }
}