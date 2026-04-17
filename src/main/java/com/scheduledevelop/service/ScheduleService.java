package com.scheduledevelop.service;

import com.scheduledevelop.dtos.*;
import com.scheduledevelop.entity.Schedule;
import com.scheduledevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse create(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getDetail(),
                request.getName(),
                request.getPassword()
        );

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getDetail(),
                savedSchedule.getName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public GetScheduleResponse findOne(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () ->new IllegalAccessError("없는 일정입니다.")
        );


        return new GetScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getDetail(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetScheduleResponse> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll(
                Sort.by(Sort.Direction.DESC, "modifiedAt")  //수정일 기준 내림차순 정렬
        );

        List<GetScheduleResponse> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            dtos.add(new GetScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getDetail(),
                    schedule.getName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
                    )
            );
        }
        return dtos;
    }

    @Transactional
    public UpdateScheduleResponse update(Long id, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () ->new IllegalAccessError("없는 일정입니다.")
        );

        schedule.updateSchedule(
                request.getTitle(),
                request.getName()
        );

        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getDetail(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long id) {
        boolean existence = scheduleRepository.existsById(id);

        if (!existence) {
            throw new IllegalStateException("없는 멤버입니다.");
        }

        scheduleRepository.deleteById(id);
    }

}