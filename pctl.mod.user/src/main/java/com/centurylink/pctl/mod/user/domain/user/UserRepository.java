package com.centurylink.pctl.mod.user.domain.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.centurylink.pctl.mod.core.model.user.LoggedUser;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for the User entity.
 */
public interface UserRepository extends MongoRepository<LoggedUser, String> {

    LoggedUser findOneByEmail(String email);

    Optional<LoggedUser> findOneByLogin(String login);

    LoggedUser findOneByFirstName(String name);

     @Override
    void delete(LoggedUser t);

}
