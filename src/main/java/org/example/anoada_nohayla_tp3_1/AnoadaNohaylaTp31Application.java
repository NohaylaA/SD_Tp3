package org.example.anoada_nohayla_tp3_1;

import org.example.anoada_nohayla_tp3_1.entities.Patient;
import org.example.anoada_nohayla_tp3_1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class AnoadaNohaylaTp31Application implements CommandLineRunner
{
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args)
    {
        SpringApplication.run(AnoadaNohaylaTp31Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        /*
        patientRepository.save(new Patient(null,"Mohamed",new Date(),false,34));
        patientRepository.save(new Patient(null,"Hanane",new Date(),false,4321));
        patientRepository.save(new Patient(null,"Imane",new Date(),true,34));
        */
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
