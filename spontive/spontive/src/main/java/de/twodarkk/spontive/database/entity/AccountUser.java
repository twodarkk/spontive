package de.twodarkk.spontive.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accountUser")
public class AccountUser extends BaseEntity{

    private boolean admin;

    @ManyToOne
    private User user;

    @ManyToOne
    private Accounts accounts;

    @OneToMany(mappedBy = "accountUser")
    private Set<AccountUser> accountUser;
}
