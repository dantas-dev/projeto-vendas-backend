package br.com.dantas.projeto.configuration;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import br.com.dantas.projeto.model.entities.CidadeEntity;
import br.com.dantas.projeto.model.entities.EstadoEntity;
import br.com.dantas.projeto.model.entities.ProdutoEntity;
import br.com.dantas.projeto.model.repositories.CategoriaRepository;
import br.com.dantas.projeto.model.repositories.CidadeRepository;
import br.com.dantas.projeto.model.repositories.EstadoRepository;
import br.com.dantas.projeto.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository  categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    @Override
    public void run(String... args) throws Exception {

        CategoriaEntity categoria1 = new CategoriaEntity(null, "Informática");
        CategoriaEntity categoria2 = new CategoriaEntity(null, "Escritório");
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

        ProdutoEntity produto1 = new ProdutoEntity(null, "Desktop", 2000.00);
        ProdutoEntity produto2 = new ProdutoEntity(null, "Impressora", 800.00);
        ProdutoEntity produto3 = new ProdutoEntity(null, "Mouse", 80.00);
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

        categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
        categoria2.getProdutos().addAll(Arrays.asList(produto2));
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

        produto1.getCategorias().addAll(Arrays.asList(categoria1));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria1));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

        EstadoEntity estado1 = new EstadoEntity(null, "Minas Gerais");
        EstadoEntity estado2 = new EstadoEntity(null, "São Paulo");
        estadoRepository.saveAll(Arrays.asList(estado1, estado2));

        CidadeEntity cidade1 = new CidadeEntity(null, "Uberlândia", estado1);
        CidadeEntity cidade2 = new CidadeEntity(null, "São Paulo", estado2);
        CidadeEntity cidade3 = new CidadeEntity(null, "Campinas", estado2);
        cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

        estado1.getCidades().addAll(Arrays.asList(cidade1));
        estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
        estadoRepository.saveAll(Arrays.asList(estado1, estado2));

    }
}
