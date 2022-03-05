package br.com.dantas.projeto.configuration;

import br.com.dantas.projeto.model.entities.*;
import br.com.dantas.projeto.model.enums.EstadoPagamento;
import br.com.dantas.projeto.model.enums.TipoCliente;
import br.com.dantas.projeto.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Autowired
    private CategoriaRepository  categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    @Override
    public void run(String... args) throws Exception {

        // INSTÂNCIA CATEGORIA
        CategoriaEntity categoria1 = new CategoriaEntity(null, "Informática");
        CategoriaEntity categoria2 = new CategoriaEntity(null, "Escritório");
        // INSTÂNCIA PRODUTO
        ProdutoEntity produto1 = new ProdutoEntity(null, "Desktop", 2000.00);
        ProdutoEntity produto2 = new ProdutoEntity(null, "Impressora", 800.00);
        ProdutoEntity produto3 = new ProdutoEntity(null, "Mouse", 80.00);
        // RELACIONAMNTO CATEGORIA/PRODUTO
        categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
        categoria2.getProdutos().addAll(Arrays.asList(produto2));
        // RELACIONAMNTO PRODUTO/CATEGORIA
        produto1.getCategorias().addAll(Arrays.asList(categoria1));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria1));
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));


        // INSTÂNCIA ESTADO
        EstadoEntity estado1 = new EstadoEntity(null, "Minas Gerais");
        EstadoEntity estado2 = new EstadoEntity(null, "São Paulo");
        // INSTÂNCIA CIDADE
        CidadeEntity cidade1 = new CidadeEntity(null, "Uberlândia", estado1);
        CidadeEntity cidade2 = new CidadeEntity(null, "São Paulo", estado2);
        CidadeEntity cidade3 = new CidadeEntity(null, "Campinas", estado2);
        // RELACIONAMNTO ESTADO/CIDADE
        estado1.getCidades().addAll(Arrays.asList(cidade1));
        estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
        estadoRepository.saveAll(Arrays.asList(estado1, estado2));
        cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));


        // INSTÂNCIA CLIENTE
        ClienteEntity cliente1 = new ClienteEntity(null, "Maria Silva", "maria@gmail.com", "123.456.789-00", TipoCliente.PESSOAFISICA);
        cliente1.getTelefones().addAll(Arrays.asList("11956916792", "11930385794"));
        // INSTÂNCIA ENDEREÇO
        EnderecoEntity endereco1 = new EnderecoEntity(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cliente1, cidade1);
        EnderecoEntity endereco2 = new EnderecoEntity(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente1, cidade2);
        // RELACIONAMNTO CLIENTE/ENDEREÇO
        cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
        clienteRepository.saveAll(Arrays.asList(cliente1));
        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));


        // INSTÂNCIA PEDIDO
        PedidoEntity pedido1 = new PedidoEntity(null, format.parse("30/09/2017 10:32"), cliente1, endereco1);
        PedidoEntity pedido2 = new PedidoEntity(null, format.parse("10/10/2017 19:35"), cliente1, endereco2);
        // INSTÂNCIA PAGAMENTO
        PagamentoEntity pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
        PagamentoEntity pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, format.parse("20/10/2017 00:00"), null);
        // RELACIONAMNTO PEDIDO/PAGAMENTO
        pedido1.setPagamento(pagamento1);
        pedido2.setPagamento(pagamento2);
        // RELACIONAMNTO CLIENTE/PEDIDO
        cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
        pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));
        clienteRepository.saveAll(Arrays.asList(cliente1));

        // INSTÂNCIA ITEMPEDIDO
        ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 0.0, 1, 2000.00);
        ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 0.0, 2, 80.00);
        ItemPedido itemPedido3 = new ItemPedido(pedido2, produto2, 100.0, 1, 800.00);
        // RELACIONAMNTO PEDIDO/ITEMPEDIDO
        pedido1.getItemPedidos().addAll(Arrays.asList(itemPedido1, itemPedido3));
        pedido2.getItemPedidos().addAll(Arrays.asList(itemPedido2));
        // RELACIONAMNTO PRODUTO/ITEMPEDIDO
        produto1.getItemPedidos().addAll(Arrays.asList(itemPedido1));
        produto2.getItemPedidos().addAll(Arrays.asList(itemPedido3));
        produto3.getItemPedidos().addAll(Arrays.asList(itemPedido2));
        itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido2));

    }
}
