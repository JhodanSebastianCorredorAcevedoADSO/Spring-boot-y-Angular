package ProyectoEjecutable.ProyectoEjecutable;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProyectoEjecutableApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEjecutableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
			for (int i = 0; i < 5; i++) {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String passwordEncrypt = passwordEncoder.encode(password);
				System.out.println(passwordEncrypt);

		}
	}
}
