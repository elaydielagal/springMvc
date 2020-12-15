package org.sid.springmvc;

import org.sid.springmvc.dao.PatientRepository;
import org.sid.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringmvcApplication implements CommandLineRunner {
	@Autowired
	PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"ELAydi",new Date(),false,45));
		patientRepository.save(new Patient(null,"Meryem",new Date(),false,42));
		patientRepository.save(new Patient(null,"Adam",new Date(),false,15));
		patientRepository.save(new Patient(null,"Israe",new Date(),false,12));

		patientRepository.findAll().forEach(pt->{
			System.out.println(pt.getName());
		});
	}
}
