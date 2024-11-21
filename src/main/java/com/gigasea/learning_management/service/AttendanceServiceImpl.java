package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Attendance;
import com.gigasea.learning_management.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public void saveAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> findAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceId(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public void deleteAllAttendances() {
        attendanceRepository.deleteAll(); // Clear all attendance records
    }
}
