package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> {

}


