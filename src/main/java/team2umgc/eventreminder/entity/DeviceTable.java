package team2umgc.eventreminder.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "device_table", schema = "event_reminder")
public class DeviceTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Integer deviceId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserAccount userAccount;

    @Column(name = "device_uuid", nullable = false, length = 200)
    private String deviceUuid;

    @Column(name = "push_token", nullable = false, unique = true, length = 100)
    private String pushToken;

    @Column(name = "status", nullable = false, length = 15)
    private String status;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

}
