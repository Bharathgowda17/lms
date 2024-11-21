package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Attendance;
import java.util.List;

public interface AttendanceService {
    void saveAttendance(Attendance attendance);
    List<Attendance> findAttendances();
    Attendance getAttendanceId(Long id);
    void deleteAttendance(Long id);
    void deleteAllAttendances(); // New method
}
