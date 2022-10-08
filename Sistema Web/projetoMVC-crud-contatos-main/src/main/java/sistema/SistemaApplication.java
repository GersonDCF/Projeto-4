package sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import sistema.model.Contato;

import java.util.List;

@SpringBootApplication
public class SistemaApplication implements CommandLineRunner {

        public static void main(String[] args) {
                SpringApplication.run(SistemaApplication.class, args);
        }

        @Autowired
        JdbcTemplate jdbcTemplate;

        @Override
        public void run(String... args) throws Exception {
                jdbcTemplate.execute(
                                "create table contatos(id serial, nome varchar(50));");
                jdbcTemplate.update("INSERT INTO contatos(nome) VALUES (?)", "Edson Angoti Júnior");
                jdbcTemplate.update("INSERT INTO contatos(nome) VALUES (?)", "José Joaquim");
                jdbcTemplate.update("INSERT INTO contatos(nome) VALUES (?)", "Maria Carolina");
        }

}
