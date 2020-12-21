package hu.peteri.pacman;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PacmanApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PacmanApplication.class).headless(false).run(args);

    }

    public void run(String... args) throws Exception {
        Window win = new Window();

    }

}
