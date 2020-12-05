package de.twodarkk.spontive.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accounts")
public class Accounts extends BaseEntity {

    private String name;
    private int numPersons; // Num of Persons in a List
    private float price;
    private String currency;
    private LocalDateTime time;
    private String intervalType; // Which Type of next billing
    private int interval; // When is the next billing
    private int dayOfInterval; // every 10th day of month

    @OneToMany(mappedBy = "accounts")
    private Set<AccountUser> accountUser;

    @OneToMany(mappedBy = "accounts")
    private Set<Billings> billings;

    @OneToMany(mappedBy = "accounts")
    private Set<History> history;

    // for auto create
    public Accounts (String name, int numPersons, float price, String currency, LocalDateTime time,
                     String intervalType, int interval, int dayOfInterval) {
        this.setCreated(LocalDateTime.now());
        this.setUpdated(LocalDateTime.now());
        this.setActive(true);
        this.name = name;
        this.numPersons = numPersons;
        this.price = price;
        this.currency = currency;
        this.time = time;
        this.intervalType = intervalType;
        this.interval = interval;
        this.dayOfInterval = dayOfInterval;
    }
}
