package com.currency.monitor;


import com.currency.monitor.background.AlarmsChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;

@SpringBootApplication
public class MonitorApplication {

	@Autowired
	private TaskScheduler taskScheduler;

	@Autowired
	private AlarmsChecker alarmsChecker;

	@Value("${monitor.alarmChecker.enabled}")
	private boolean alarmCheckerEnabled;

	@Value("${monitor.alarmChecker.interval}")
	private long alarmCheckerInterval;

	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void scheduleAfterStartup() {
		if (alarmCheckerEnabled) {
			taskScheduler.scheduleWithFixedDelay(alarmsChecker, alarmCheckerInterval);
		}
	}

}
