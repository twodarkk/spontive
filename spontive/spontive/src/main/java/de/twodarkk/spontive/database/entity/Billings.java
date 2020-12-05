package de.twodarkk.spontive.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "billings")
public class Billings extends BaseEntity{

    private Date date;

    private float amount;

    private float lastAmount;

    private boolean paid;

    @ManyToOne
    private Accounts accounts;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "billings")
    private Set<History> history;
}
