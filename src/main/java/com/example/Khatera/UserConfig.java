package com.example.Khatera;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner mCommandLineRunner (
            UserRepository repository
    ) {
        return args -> {
            UserClass mohammed = new UserClass(
                    "Mohammed Haddad",
                    "mhaddad",
                    "mohammedhaddad@gmail.com",
                    "I'm mohammed password",
                    LocalDate.of(1997, Month.OCTOBER, 30));

            UserClass ahmed = new UserClass(
                    "Ahmed Haddad",
                    "ahmed_14",
                    "ahmedhaddad@gmail.com",
                    "I'm ahmed password",
                    LocalDate.of(2000, Month.FEBRUARY, 20));

            UserClass roushdy = new UserClass(
                    "Roushdy Haddad",
                    "roushdy1985",
                    "roushdyhaddad@gmail.com",
                    "I'm roushdy password",
                    LocalDate.of(1985, Month.OCTOBER, 9));

            UserClass hemdan = new UserClass(
                    "Hemdan Haddad",
                    "hemdan1993",
                    "hemdan@gmail.com",
                    "I'm hemdan password",
                    LocalDate.of(1993, Month.JULY, 27));

            repository.saveAll(
                    List.of(mohammed, ahmed, roushdy, hemdan)
            );
        };

    }
}
