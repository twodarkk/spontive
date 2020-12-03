package de.twodarkk.spontive.database.repository;

import de.twodarkk.spontive.database.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByeMail(String eMail);
}
