package br.com.app.autostart;

import static br.com.app.model.db.fruta.PedidoItem.DIA_QUARTA;
import static br.com.app.model.db.fruta.PedidoItem.DIA_QUINTA;
import static br.com.app.model.db.fruta.PedidoItem.DIA_SEGUNDA;
import static br.com.app.model.db.fruta.PedidoItem.DIA_SEXTA;
import static br.com.app.model.db.fruta.PedidoItem.DIA_TERCA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import br.com.app.model.db.Usuario;
import br.com.app.model.db.fruta.Cliente;
import br.com.app.model.db.fruta.Empresa;
import br.com.app.model.db.fruta.Endereco;
import br.com.app.model.db.fruta.Pedido;
import br.com.app.model.db.fruta.PedidoItem;
import br.com.app.model.db.fruta.Produto;
import br.com.app.repository.AusenciaRepository;
import br.com.app.repository.ClienteRepository;
import br.com.app.repository.EmpresaRepository;
import br.com.app.repository.EnderecoRepository;
import br.com.app.repository.MovimentoRepository;
import br.com.app.repository.PedidoRepository;
import br.com.app.repository.ProdutoRepository;
import br.com.app.repository.UsuarioRepository;

@Configuration
public class AutoStart {
	
	private static final Logger log = LoggerFactory.getLogger(AutoStart.class);

	private final Environment environment;
	private final AusenciaRepository pastaRepository;
	private final ClienteRepository clienteRepository;
	private final EmpresaRepository empresaRepository;
	private final MovimentoRepository movimentoRepository;
	private final ProdutoRepository produtoRepository;
	private final PedidoRepository pedidoRepository;
	private final UsuarioRepository usuarioRepository;
	private final EnderecoRepository enderecoRepository;

	private Empresa mrv;

	private Empresa cemig;

	private Empresa avenue;

	private Empresa tangara;

	private Empresa itauAc;
	
	private Empresa itauJp;

	private Empresa bs2;

	private Produto frutaPicada;

	private Produto frutaInteira;

	private Produto saladaFruta;

	private Produto sucoDetox;

	private Produto carbo;

	private Empresa framework;

	private Empresa sicoob;

	private Empresa inter;

	private Empresa bcoBrasil;

	private Empresa mercantil;
	
	
	
	public AutoStart(Environment environment, AusenciaRepository pastaRepository,
			ClienteRepository clienteRepository, EmpresaRepository empresaRepository,
			MovimentoRepository movimentoRepository, ProdutoRepository produtoRepository,
			PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) {
		super();
		this.environment = environment;
		this.pastaRepository = pastaRepository;
		this.clienteRepository = clienteRepository;
		this.empresaRepository = empresaRepository;
		this.movimentoRepository = movimentoRepository;
		this.produtoRepository = produtoRepository;
		this.pedidoRepository = pedidoRepository;
		this.usuarioRepository = usuarioRepository;
		this.enderecoRepository = enderecoRepository;
	}


	@Bean
	@Order(1)
	public CommandLineRunner fakeData() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception { 
				initDB();
			}
		};
	}
	
	
	private void initDB(){
		Usuario marcia = new Usuario()
				.setNome("marcia")
				.setEmail("asdqwe")
				.setSenha("123");
		this.usuarioRepository.save(marcia);

		salvaFrutas();
		salvaEmpresas();
		salvaClientes();
		
		
		
		
		
		/*
		Cliente jose = new Cliente()
				.setNome("Jose")
				.setTelefone("3333-3333")
				.setEmpresa(mrv)
				.setEmail("jose@gmail.com");
		this.clienteRepository.save(jose);
		
		
		Cliente maria = new Cliente()
				.setNome("Maria")
				.setTelefone("3333-3333")
				.setEmpresa(cemig)
				.setEmail("maria@gmail.com");
		this.clienteRepository.save(maria);
		
		
		Pedido pedidoJose = new Pedido()
				.setCliente(jose);
				
		Set<PedidoItem> itensPedidoJose = new HashSet<>();
		itensPedidoJose.add(new PedidoItem()
				.setProduto(frutaPicada)
				.setDiaSemana(DIA_SEGUNDA)
				.setObservacao("S/ MAMAO")
				.setPreco(4.5D)
				.setPedido(pedidoJose));
		itensPedidoJose.add(new PedidoItem()
				.setProduto(sucoDetox)
				.setDiaSemana(DIA_SEGUNDA)
				.setPreco(4D)
				.setPedido(pedidoJose));
		
		pedidoJose.setItens(itensPedidoJose);
		this.pedidoRepository.save(pedidoJose);
		
		
		
		
		Pedido pedidoMaria = new Pedido()
				.setCliente(maria);
				
		Set<PedidoItem> itensPedidoMaria = new HashSet<>();
		itensPedidoMaria.add(new PedidoItem()
				.setProduto(frutaPicada)
				.setDiaSemana(DIA_SEGUNDA)
				.setObservacao("S/ MAMAO")
				.setPreco(4.5D)
				.setPedido(pedidoMaria));
		itensPedidoMaria.add(new PedidoItem()
				.setProduto(frutaPicada)
				.setDiaSemana(DIA_SEGUNDA)
				.setObservacao("S/ MAMAO")
				.setPreco(4.5D)
				.setPedido(pedidoMaria));
		itensPedidoMaria.add(new PedidoItem()
				.setProduto(saladaFruta)
				.setDiaSemana(DIA_SEGUNDA)
				.setObservacao("S/ IXIA")
				.setPreco(4D)
				.setPedido(pedidoMaria));
		
		pedidoMaria.setItens(itensPedidoMaria);
		this.pedidoRepository.save(pedidoMaria);
		*/
		
		/*
		for ( int x=0; x<=100; x++ ) {
			jose = new Cliente()
					.setNome("Maria " + x)
					.setTelefone("3333-3333")
					.setEmpresa(mrv)
					.setEmail("jose@gmail.com");
			this.clienteRepository.save(jose);
		}
		*/
				
		
	}
	
	private void salvaClientes() {
		Pedido cliente = salvaCliente("Amanda", this.bs2, "996067462", "amanda.machado@bs2.com");
		segSex(cliente, new PedidoItem(this.frutaPicada));
		
		cliente = salvaCliente("Ana Cristina", this.bs2, "994621467", "ana.rodrigues@bs2.com");
		segSex(cliente, new PedidoItem(this.frutaInteira, "S/ Banana, S/ Uva"));
		
		/*cliente = salvaCliente("Ana Leticia", this.tangara, "997373534", "anancpires@yahoo.com.br");
		segSex(cliente, new PedidoItem(this.frutaPicada, "Apenas banana"));*/
		
		cliente = salvaCliente("Andre Ventura", this.avenue, "993522328", "jamilasilva.costa@gmail.com");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Salada"));
		
		cliente = salvaCliente("Andrea", this.bs2, "992363338", "deiacrist@hotmail.com");
		salvaPedido(cliente, new PedidoItem(this.frutaPicada), DIA_TERCA, DIA_QUINTA);
		
		cliente = salvaCliente("Ayla", this.framework, "999501899", "aylaarcastro@gmail.com ");
		salvaPedido(cliente, new PedidoItem(this.frutaPicada, "S/ Salada"), DIA_SEGUNDA, DIA_TERCA);
		salvaPedido(cliente, new PedidoItem(this.frutaPicada, 2, "S/ Salada"), DIA_QUARTA, DIA_QUINTA, DIA_SEXTA);
		
		cliente = salvaCliente("Blenda", this.mrv, "988483372", "blenda.alves@mrv.com.br");
		segSex(cliente, new PedidoItem(this.frutaPicada, 2, "S/ Banana, S/ Mamao"));
		segSex(cliente, new PedidoItem(this.frutaInteira, 1, "S/ Banana, S/ Mamao"));
		
		cliente = salvaCliente("Breno Castilho", this.sicoob, null, "breno.castilho@outlook.com");
		salvaPedido(cliente, new PedidoItem(this.saladaFruta), DIA_QUARTA);
		salvaPedido(cliente, new PedidoItem(this.sucoDetox), DIA_SEXTA);
		
		cliente = salvaCliente("Bruna Baier", this.mrv, "986805339", "bruna.baier@mrv.com.br");
		//TODO ver esse caso
		
		cliente = salvaCliente("Catherine Nataja", this.itauAc, "994166187", "catherinenataja@gmail.com");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		cliente = salvaCliente("Douglas Henrique", this.bs2, "992228990", "dougbhdev@gmail.com");
		salvaPedido(cliente, new PedidoItem(this.frutaPicada), DIA_SEGUNDA, DIA_QUARTA, DIA_SEXTA);
		
		cliente = salvaCliente("Daniel", this.framework , "983775427", "danielulrik@frwk.com.br ");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Salada, S/ Uva"));
		
		cliente = salvaCliente("João Ribeiro", this.bs2, "988895942", "joao.ribeiro@bs2.com");
		salvaPedido(cliente, new PedidoItem(this.frutaPicada, 2, "S/ Manga, S/ Caqui"), DIA_TERCA);
		salvaPedido(cliente, new PedidoItem(this.saladaFruta, "S/ Manga, S/ Caqui"), DIA_QUINTA);
		
		cliente = salvaCliente("Diogo Leite", this.mrv, "989800007", "diogo.leite@mrv.com.br ");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		//cliente = salvaCliente("Danila", this.mrv, "993333632", "Danila.paula@mrv.com.br,vendas@daniladepaula.com.br");
		//salvaPedido(cliente, new PedidoItem(this.frutaPicada, "S/ Manga, S/ Caqui"), DIA_TERCA, DIA_QUARTA, DIA_QUINTA, DIA_SEXTA);
		//TODO Pegar com o jouberth
		
		cliente = salvaCliente("Eduardo Totte", this.tangara , "996413785", "edutotte@gmail.com,eduardo.totte@tangarafoods.com.br");
		segSex(cliente, new PedidoItem(this.frutaPicada));
		
		cliente = salvaCliente("Elaine Fonseca", this.framework , "993608436", "elaineborgesf@gmail.com");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Wiki, S/ Melao"));
		
		cliente = salvaCliente("Elvis Souza", this.mrv, null, "elvis.sousa@mrv.com.br");
		segSex(cliente, new PedidoItem(this.sucoDetox));
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		cliente = salvaCliente("Emily", this.framework , null, null);
		//segSex(cliente, new PedidoItem(this.saladaFruta));
		salvaPedido(cliente, new PedidoItem(this.frutaPicada), DIA_TERCA, DIA_QUINTA);
		salvaPedido(cliente, new PedidoItem(this.saladaFruta), DIA_TERCA, DIA_QUINTA);
		
		cliente = salvaCliente("Ericka Sanny", this.mrv, "982214667", "erickasanny@gmail.com");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Melancia, S/ Mamao"));
		
		cliente = salvaCliente("Evelyn Silva", this.mrv, "973400318", "evelyn.claire@mrv.com.br");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		cliente = salvaCliente("Everton Gomes", this.framework , null, "evertongomes@frameworksystem.com");
		segSex(cliente, new PedidoItem(this.saladaFruta, "S/ Roma"));
		
		cliente = salvaCliente("Fabiana", this.mrv, "994320504", "fabikarla@yahoo.com.br");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		cliente = salvaCliente("Fabio Pereira", this.inter, "984710682", "fabio.pereira@bancointer.com.br");
		salvaPedido(cliente, new PedidoItem(this.saladaFruta), DIA_TERCA, DIA_QUINTA);
		
		cliente = salvaCliente("Fabiola Menezes", this.bs2, "984826655", "fabiola.menezes@bs2.com");
		segSex(cliente, new PedidoItem(this.frutaPicada));
		
		cliente = salvaCliente("Fernanda Faria", this.bs2, "991063032", "Fernanda.faria@bs2.com");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		cliente = salvaCliente("Fernanda Furtado", this.bs2, "973493647", "fernanda.furtado@bs2.com");
		salvaPedido(cliente, new PedidoItem(this.sucoDetox), DIA_SEGUNDA, DIA_SEXTA);
		
		cliente = salvaCliente("Fernanda Pacheco", this.bs2, "975562378", "fernanda.lanca@bs2.com");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		segSex(cliente, new PedidoItem(this.frutaPicada));
		
		cliente = salvaCliente("Francisco", this.bs2, "991091926", "maria.magalhaes@bs2.com");
		segSex(cliente, new PedidoItem(this.saladaFruta, "S/ Doce"));
		
		cliente = salvaCliente("Frederico Minucci", this.bcoBrasil, "987913139", "fminucci@bb.com.br");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		cliente = salvaCliente("Gabriela", this.framework , "991105107", "gabrielaarcastro@gmail.com");
		salvaPedido(cliente, new PedidoItem(this.saladaFruta, 2), DIA_TERCA, DIA_QUINTA);
		
		cliente = salvaCliente("Geraldo Neto", this.framework , null, "geraldoneto@frameworksystem.com");
		segSex(cliente, new PedidoItem(this.saladaFruta, "S/ Roma"));
		
		cliente = salvaCliente("Grazielle Caetano", this.tangara , "982047370", "grazielle_caetano@yahoo.com.br");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Salada"));
		
		cliente = salvaCliente("Grazielle Cristina", this.mrv, "988626070", "grazielle.alves@grupolpj.com ");
		salvaPedido(cliente, new PedidoItem(this.saladaFruta, "S/ Roma"), DIA_SEGUNDA, DIA_QUARTA, DIA_QUINTA);
		
		cliente = salvaCliente("Iuly", this.tangara , "998536685", "iulymacari@gmail.com");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Melao, S/ Kiwi, S/ Pessego, S/ Caldo"));
		
		cliente = salvaCliente("Izabelle Cangussu", this.bs2, "994104441", "izabellecangussu@hotmail.com");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Melao, S/ Melancia, S/ Pinha, S/ Maca, S/ Morango"));
		
		cliente = salvaCliente("Jailton", this.mrv, "993965172", "jailtong2009@gmail.com");
		segSex(cliente, new PedidoItem(this.saladaFruta, "S/ Abacaxi"));
		
		cliente = salvaCliente("Jamila", this.framework , "975734509", "jamilasilva.costa@gmail.com");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Salada, S/ Abacaxi, S/ Uva"));
		
		cliente = salvaCliente("Jean Abraão", this.mrv, "987724911", "jean@bertholdo.com.br");
		salvaPedido(cliente, new PedidoItem(this.saladaFruta, "S/ Caldo, S/ Abacaxi"), DIA_SEGUNDA, DIA_TERCA, DIA_QUARTA);
		
		cliente = salvaCliente("João Carvalho", this.bs2, "993394550", "joao.carvalho@bs2.com");
		segSex(cliente, new PedidoItem(this.frutaPicada));
		
		cliente = salvaCliente("Kaique", this.mrv, "994632912", "kaique_depaula@outlook.com");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		cliente = salvaCliente("José Junior", this.tangara , "994034575", "adriana@tangarafoods.com.br");
		segSex(cliente, new PedidoItem(this.saladaFruta, "S/ Doce"));
		
		cliente = salvaCliente("Juliana Tavares", this.mrv, null, "juliana.tavares@mrv.com.br ");
		segSex(cliente, new PedidoItem(this.saladaFruta, "S/ Melancia"));
		
		cliente = salvaCliente("Klaiton Lima", this.mrv, "994399717", "klaiton.lima@mrv.com.br");
		salvaPedido(cliente, new PedidoItem(this.saladaFruta), DIA_SEGUNDA, DIA_QUARTA, DIA_SEXTA);
		
		cliente = salvaCliente("Kivia Gois", this.mrv, "996135425", "kiviaog@hotmail.com");
		segSex(cliente, new PedidoItem(this.frutaPicada));
		
		cliente = salvaCliente("Mario Olympio", this.mrv, "987788212", "mariooca@gmail.com");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		cliente = salvaCliente("Lamarck", this.tangara , "993714869", "lamarckmelo@outlook.com");
		segSex(cliente, new PedidoItem(this.saladaFruta));
		
		cliente = salvaCliente("Daiane Oliveira", this.tangara , "993396718", "dayoliveiramoc65@gmail.com");
		
		cliente = salvaCliente("Lucas Augusto", this.avenue, "991512926", "stilbocarpa@gmail.com");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Melancia"));
		
		cliente = salvaCliente("Luiz Alberto", this.mercantil, "987986299", "luiz.alberto@mercantil.com.br");
		segSex(cliente, new PedidoItem(this.saladaFruta, "S/ Talher, S/ Amora"));
		
		cliente = salvaCliente("Maíra Freitas", this.cemig, "986364879", "maira.freitas@cemig.com.br");
		salvaPedido(cliente, new PedidoItem(this.saladaFruta), DIA_SEGUNDA, DIA_QUARTA, DIA_SEXTA);
		salvaPedido(cliente, new PedidoItem(this.frutaPicada), DIA_SEGUNDA, DIA_QUARTA, DIA_SEXTA);
		
		cliente = salvaCliente("Marcia", this.bs2, "988802653", "marcia.cardoso@bs2.com");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Mamao"));
		salvaPedido(cliente, new PedidoItem(this.sucoDetox), DIA_SEGUNDA, DIA_QUARTA);
		
		cliente = salvaCliente("Mariana", this.itauJp, "987356080", "mariana.monterrey@hotmail.com");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Talher"));
		
		//
		cliente = salvaCliente("Lorrayne Nayara", this.tangara , "994607812", "lorrayne.nayara@tangarafoods.com.br");
		segSex(cliente, new PedidoItem(this.frutaPicada, "SO ABACAXI KIWI MORANGO PERA GOIABA"));
		
		cliente = salvaCliente("Mariana Alvin", this.mrv, "991198246", "mariana.alvim@mrv.com.br");
		segSex(cliente, new PedidoItem(this.frutaPicada, "S/ Mamao"));
		
		cliente = salvaCliente("Marilia", this.bs2, "986689570", "mariliaenunes@hotmail.com ");
		cliente = salvaCliente("Mariana  Silva", this.tangara , "973021788", "marianaverdevila@gmail.com");
		cliente = salvaCliente("Marllon", this.bs2, "987511404", "Marllon.andrade14@hotmail.com ");
		cliente = salvaCliente("Mirian Braga", this.mrv, null, "miriantbraga@yahoo.com.br");
		cliente = salvaCliente("Natália Ferreira", this.tangara , null, "natymf03@gmail.com");
		cliente = salvaCliente("Nathalia Dornelas", this.cemig, "998903645", "nathmelobh100@yahoo.com.br");
		cliente = salvaCliente("Nathane Oliveira", this.mrv, "987150053", "nathane.oliveira@mrv.com.br ");
		cliente = salvaCliente("Nayara Caiafa", this.mrv, "996760788", "nayara.caiafa@mrv.com.br ");
		cliente = salvaCliente("Nayara Oliveira", this.cemig, "999040156", "nayararsoliveira@gmail.com");
		cliente = salvaCliente("Paulinho", this.mercantil, "991544934", "paulo.oliveira@mercantil.com.br");
		cliente = salvaCliente("Rachel Lima", this.tangara , "987913138", "rachelpaulino@yahoo.com.br");
		cliente = salvaCliente("Rafael Araujo", this.mrv, "984672337", "rafael.frederico@mrv.com.br ");
		cliente = salvaCliente("Rafael Neves", this.tangara , "983033958", "rafael.neves@gmail.com");
		//cliente = salvaCliente("Raquel", this.Contorno, "993877896", "raquelucastro@gmail.com ");
		cliente = salvaCliente("Rodrigo Rezende", this.mrv, null, "rodrigo@mrv.com.br ");
		cliente = salvaCliente("Rudy", this.bs2, "992020303", "rudycordeiro@hotmail.com ");
		cliente = salvaCliente("Sandra", this.mrv, "998762020", "sandra@mrv.com.br ");
		cliente = salvaCliente("Sandro", this.bs2, "991091926", "maria.magalhaes@bs2.com");
		cliente = salvaCliente("Suelen Oliveira", this.framework , "983517340", "suelens.oliv@gmail.com");
		cliente = salvaCliente("Talita Lazarotti", this.tangara , "973078808", "talitalazarotti@gmail.com");
		cliente = salvaCliente("Tércia Moreira", this.cemig, "996144494", "terciamatheus@hotmail.com");
		cliente = salvaCliente("Thais Oliveira", this.tangara , "996340446", "thais.oliveira@tangarafoods.com.br");
		cliente = salvaCliente("Thais Rezende", this.bs2, "994734584", "thais_rezende1304@hotmail.com ");
		cliente = salvaCliente("Vania Oliveira", this.tangara , "975675951", "vania@tangarafoods.com.br");
		cliente = salvaCliente("Veronica Guimarães", this.bs2, "991991900", "veronica.guimaraes@bs2.com");
		cliente = salvaCliente("Virginia Paula", this.tangara , "991969964", "virginia@tangarafoods.com.br");
		cliente = salvaCliente("Wander", this.mrv, "992957174", "wander.oliveira@mrv.com.br ");
		cliente = salvaCliente("Wilberson", this.mrv, "998826951", "wilberson.rocha@mrv.com.br");


		
		
	}


	private Pedido salvaCliente(String nome, Empresa empresa, String telefone, String email) {
		Cliente cliente = new Cliente()
				.setNome(nome)
				.setEmpresa(empresa)
				.setTelefone(telefone)
				.setEmail(email);
		this.clienteRepository.save(cliente);
		
		Pedido pedido = new Pedido(cliente);
		this.pedidoRepository.save(pedido);
		
		return pedido;
	}
	
	private void segSex(Pedido pedido, PedidoItem item) {
		salvaPedido(pedido, item, DIA_SEGUNDA, DIA_TERCA, DIA_QUARTA, DIA_QUINTA, DIA_SEXTA);
	}

	private void salvaPedido(Pedido pedido, PedidoItem item, String... dias) {
		Set<PedidoItem> itens = new HashSet<>();
		for (String dia : dias) {
			PedidoItem i = new PedidoItem(item.getProduto(), dia, item.getPreco(), item.getObservacao(), item.getQuantidade());
			i.setPedido(pedido);
			itens.add(i);
		}
		
		pedido.setItens(itens);
		this.pedidoRepository.save(pedido);
	}


	private void salvaFrutas() {
		this.frutaPicada = new Produto()
				.setDescricao("Fruta Picada")
				.setPrecoBase(4.5D);
		this.frutaInteira = new Produto()
				.setDescricao("Fruta Inteira")
				.setPrecoBase(3.5D);
		this.saladaFruta = new Produto()
				.setDescricao("Salada de Fruta")
				.setPrecoBase(5D);
		this.sucoDetox = new Produto()
				.setDescricao("Suco Detox")
				.setPrecoBase(4D);
		this.carbo = new Produto()
				.setDescricao("Carboidrato")
				.setPrecoBase(2.5D);
		this.produtoRepository.save(Arrays.asList(frutaPicada, frutaInteira, saladaFruta, sucoDetox, carbo));
	}


	private void salvaEmpresas() {
		Endereco endMrv = new Endereco()
				.setLogradouro("Av Raja Gabaglia")
				.setNumero("123, SALA 201")
				.setBarro("Buritis");
		endMrv = this.enderecoRepository.save(endMrv);
		
		this.mrv = new Empresa()
				.setNome("MRV")
				.setEndereco(endMrv);
		this.empresaRepository.save(mrv);
		
		this.cemig = new Empresa()
				.setNome("CEMIG")
				.setEndereco(endMrv);
		this.empresaRepository.save(cemig);
		
		this.avenue = new Empresa()
				.setNome("AVENUE")
				.setEndereco(endMrv);
		this.empresaRepository.save(avenue);
		
		this.mercantil = new Empresa()
				.setNome("MERCANTIL")
				.setEndereco(endMrv);
		this.empresaRepository.save(mercantil);
		
		this.tangara = new Empresa()
				.setNome("TANGARA")
				.setEndereco(endMrv);
		this.empresaRepository.save(tangara);
		
		this.itauAc = new Empresa()
				.setNome("ITAU - AC")
				.setEndereco(endMrv);
		this.empresaRepository.save(itauAc);
		
		this.itauJp = new Empresa()
				.setNome("ITAU - JP")
				.setEndereco(endMrv);
		this.empresaRepository.save(itauJp);
		
		this.bs2 = new Empresa()
				.setNome("BS2")
				.setEndereco(endMrv);
		this.empresaRepository.save(bs2);
		
		this.framework = new Empresa()
				.setNome("FRAMEWORK")
				.setEndereco(endMrv);
		this.empresaRepository.save(framework);
		
		this.inter = new Empresa()
				.setNome("INTER")
				.setEndereco(endMrv);
		this.empresaRepository.save(inter);
		
		this.sicoob = new Empresa()
				.setNome("SICOOB")
				.setEndereco(endMrv);
		this.empresaRepository.save(sicoob);
		
		this.bcoBrasil = new Empresa()
				.setNome("BCO BRASIL")
				.setEndereco(endMrv);
		this.empresaRepository.save(bcoBrasil);
	}
	
}
