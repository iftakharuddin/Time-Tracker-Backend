package com.iftakhar.TimeTracker.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftakhar.TimeTracker.Entity.TimeEntry;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    List<TimeEntry> findByDate(LocalDate date);

    List<TimeEntry> findByDateBetween(LocalDate start, LocalDate end);
}
