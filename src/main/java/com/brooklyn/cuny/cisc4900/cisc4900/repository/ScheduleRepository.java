package com.brooklyn.cuny.cisc4900.cisc4900.repository;

import com.brooklyn.cuny.cisc4900.cisc4900.model.schedule.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
     Schedule findById(int id);
}
