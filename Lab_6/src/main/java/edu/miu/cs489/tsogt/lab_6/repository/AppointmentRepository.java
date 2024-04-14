package edu.miu.cs489.tsogt.lab_6.repository;

import edu.miu.cs489.tsogt.lab_6.model.Appointment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Page<Appointment> findByAppointmentDate(LocalDate appointment_date, Pageable pageable);

    @Query(value = "select a.* from appointment a left outer join surgery s ON a.surgery_id = s.id left outer join address ad ON s.address_id = ad.id where ad.street_address = :street_address ", nativeQuery = true)
    List<Appointment> findByStreetAddress(@Param("street_address") String street);

    @Query("select a from Appointment a left outer join FETCH a.surgery s left outer join FETCH s.address ad where a.appointmentDate = :appointment_date")
    List<Appointment> findByApppointmentDateJPQL3(@Param("appointment_date") LocalDate appointment_date);

    @Query("select a from Appointment a left outer join FETCH a.surgery s where a.appointmentDate = :appointment_date")
    List<Appointment> findByApppointmentDateJPQL1(@Param("appointment_date") LocalDate appointment_date);

    @Query("select a from Appointment a where a.appointmentDate = :appointment_date")
    List<Appointment> findByApppointmentDateJPQL2(@Param("appointment_date") LocalDate appointment_date);

    @Query("select a from Appointment a left outer join a.surgery s where a.appointmentDate = :appointment_date")
    List<Appointment> findByApppointmentDateJPQL4(@Param("appointment_date") LocalDate appointment_date);
}
