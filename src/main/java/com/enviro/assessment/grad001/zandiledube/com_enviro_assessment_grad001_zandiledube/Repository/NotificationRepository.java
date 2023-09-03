package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Repository;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.Notification;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Optional <Notification> findByNotificationId(Long notificationId);

}
