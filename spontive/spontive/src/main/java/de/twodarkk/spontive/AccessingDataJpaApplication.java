package de.twodarkk.spontive;

import de.twodarkk.spontive.database.entity.User;
import de.twodarkk.spontive.database.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
@Slf4j
@SpringBootApplication
public class AccessingDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner startUp(UserRepository userRepository) {
        return (args) -> {
            userRepository.save(new User("Test", "Testero", "Tester007", "Test@test.de", "1234", "E-Mail", "1234"));
            userRepository.save(new User("Simon", "Lankes", "Tester007", "simon.lankes@gmx.de", "1234", "E-Mail", "1234"));

            // logging and fetch
            log.info("---->User findAll()<----");
            for (User user : userRepository.findAll()) {
                log.info(user.getFirstName());
            }
            log.info("----END.");

            log.info("---->User findByFN(SIMON)<----");
            User user1 = userRepository.findByeMail("Test@test.de");
            log.info(user1.getFirstName());
            log.info("----END.");

            log.info("---->User findAllById()<----");
            Optional<User> user = userRepository.findById(1L);
            log.info(user.get().getFirstName());
            log.info("----END.");
        };
    }
}
