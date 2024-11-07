package team2umgc.eventreminder.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notification_history", schema = "event_reminder")
public class NotificationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private ActivityTable activityTable;

    @Column(name = "notification_type", nullable = false, length = 45)
    private String notificationType;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "descrption", nullable = false, length = 256)
    private String description;

    @Column(name = "sent_date", nullable = false)
    private LocalDateTime sentDate;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdatedDate;

    // Getters and setters
}

