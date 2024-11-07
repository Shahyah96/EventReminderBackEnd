package team2umgc.eventreminder.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_account", schema = "event_reminder")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", nullable = false, unique = true, length = 45)
    private String userName;

    @Column(name = "password", nullable = false, length = 250)
    private String password;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "mobile_number", length = 45)
    private String mobileNumber;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

}
