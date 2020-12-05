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
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime changedDate;

    private String oldData;
    private String newData;
    private String description;

    @ManyToOne
    private Accounts accounts;

    @ManyToOne
    private User user;

    @ManyToOne
    private AccountUser accountUser;

    @ManyToOne
    private Billings billings;
}
