package br.com.dantas.projeto.configuration;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import br.com.dantas.projeto.model.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository  categoriaRepository;

    @Override
    public void run(String... args) throws Exception {

        CategoriaEntity categoria1 = new CategoriaEntity(null, "Informática");
        CategoriaEntity categoria2 = new CategoriaEntity(null, "Escritório");
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

    }
}
