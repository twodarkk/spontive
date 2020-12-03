package de.twodarkk.spontive.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime created;
    private LocalDateTime updated;

    private boolean active;
    private LocalDate lastLogin;

    private String firstName;
    private String lastName;
    private String userName;
    private String eMail;
    private String mobile;
    private String notifications;
    private String password;

    public User(String firstName, String lastName, String userName,
                String eMail, String mobile, String notifications, String password) {
        this.setCreated(LocalDateTime.now());
        this.setUpdated(LocalDateTime.now());
        this.setActive(true);
        this.setLastLogin(LocalDate.now());
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.eMail = eMail;
        this.mobile = mobile;
        this.notifications = notifications;
        this.password = password;
    }
}
