package br.com.death.strandingAPI.main;

import br.com.death.strandingAPI.enums.Empresa;
import br.com.death.strandingAPI.enums.StatusEntrega;
import br.com.death.strandingAPI.models.Abrigo;
import br.com.death.strandingAPI.models.Entrega;
import br.com.death.strandingAPI.models.Entregador;
import br.com.death.strandingAPI.models.Pessoa;
import br.com.death.strandingAPI.repositories.*;
import org.springframework.stereotype.Component;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.time.LocalDate;
import java.util.*;

@Component
public class Main {

    private final EntregadorRepository entregadorRepository;
    private final EntregaRepository entregaRepository;
    private final AbrigoRepository abrigoRepository;
    private final PessoaRepository pessoaRepository;
    private final AfinidadeRepository afinidadeRepository;

    private Scanner lerString = new Scanner(System.in);
    private Scanner lerDouble = new Scanner(System.in);
    private Scanner lerInt = new Scanner(System.in);

    public Main(EntregadorRepository entregadorRepository,
                EntregaRepository entregaRepository,
                AbrigoRepository abrigoRepository,
                PessoaRepository pessoaRepository,
                AfinidadeRepository afinidadeRepository) {

        this.entregadorRepository = entregadorRepository;
        this.entregaRepository = entregaRepository;
        this.abrigoRepository = abrigoRepository;
        this.pessoaRepository = pessoaRepository;
        this.afinidadeRepository = afinidadeRepository;
    }

    public void consultarAPI() {
        int op = 100000;

        do {
            System.out.println("\n<MENU>");
            System.out.println("1 - Iniciar sessão.");
            System.out.println("2 - Cadastrar novo entregador.");
            System.out.println("0 - Encerrar sessão.");

            System.out.print("\n\nSelecione uma opção:\nR.: ");
            op = lerInt.nextInt();

            switch (op) {
                case 1:
                    login();
                    break;
                case 2:
                    cadastrarNovoEntregador();
                    break;
                case 0:
                    System.out.println("\nEncerrando sessão. Mantenha o ótimo trabalho 👍");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
                    break;
            }

        } while (op != 0);
    }

    public void menu(Entregador e) {
        int op = 0;

        do {
            System.out.println("<Menu>");
            System.out.println("1 - Apresentar perfil de entregador.");
            System.out.println("2 - Apresentar histórico de entregas.");
            System.out.println("3 - Selecionar abrigo.");
            System.out.println("4 - Novas entregas.");
            System.out.println("0 - Encerrar consulta.");
            System.out.print("\n\nSelecione uma opção:\nR.: ");
            op = lerInt.nextInt();

            switch (op) {
                case 1:
                    apresentarPerfil(e);
                    break;
                case 2:
                    apresentarUltimasEntregas(e);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("\n");
                    notificacoesDeEntrega();
                    break;
                case 0:
                    System.out.println("\nEncerrando consulta.");
                    consultarAPI();
                    break;
                default:
                    System.out.println("\nOpção inválida.");
                    break;
            }
        } while (op != 0);
    }


    public void login() {
        System.out.print("\nInforme o email:\nR.: ");
        var email = lerString.nextLine();
        System.out.print("\nInforme a senha:\nR.: ");
        var senha = lerString.nextLine();

        Optional<Entregador> entregadorOptional = entregadorRepository.findByEmailAndSenha(email, senha);

        if (entregadorOptional.isPresent()) {
            System.out.println("\nBem-vindo, " + entregadorOptional.get().getNome() + "!\n\n\n");
            menu(entregadorOptional.get());
        } else {
            System.out.println("\n<!>Credenciais inválidas<!>\n");
        }
    }

    public void cadastrarNovoEntregador() {
        Entregador novoEntregador = new Entregador();
        boolean correto = false;
        String nome, email, senha1, senha2, foto;
        int empresa = 0;

        try {
            System.out.print("\n<Cadastro de Entregador>\n\n");
            System.out.print("\nNome completo:\nR.:");
            nome = lerString.nextLine();
            System.out.print("\nEmail:\nR.:");
            email = lerString.nextLine();

            do {
                System.out.print("\nSenha:\nR.:");
                senha1 = lerString.nextLine();
                System.out.print("\nDigita a senha novamente:\nR.:");
                senha2 = lerString.nextLine();

                if (!senha1.equals(senha2)) {
                    System.out.print("\nSenhas inválidas, digite novamente.");
                } else {
                    correto = true;
                }
            } while (!correto);

            correto = false;

            do {
                System.out.print("\nSelecione a empresa:\n\n1 - Bridges\n2 - Fragile Express\n3 - Autônomo\n\nR.:");
                empresa = lerInt.nextInt();
                if (empresa == 1 || empresa == 2 || empresa == 3) {
                    correto = true;
                    System.out.println("\nOpção inválida.");
                }
            } while (!correto);
            System.out.print("\n(Opcional) Link de foto:\nR.:");
            foto = lerString.nextLine();


            novoEntregador.setNome(nome);
            novoEntregador.setEmail(email);
            novoEntregador.setSenha(senha1);
            novoEntregador.setNivel(0);
            novoEntregador.setExperiencia(0);
            novoEntregador.setPesoAtual(0.0);
            novoEntregador.setFotoUrl(foto);

            switch (empresa) {
                case 1:
                    novoEntregador.setEmpresa(Empresa.BRIDGES);
                    break;
                case 2:
                    novoEntregador.setEmpresa(Empresa.FRAGILE_EXPRESS);
                    break;
                case 3:
                    novoEntregador.setEmpresa(Empresa.AUTONOMO);
            }

            novoEntregador.setEntregas(null);
            novoEntregador.setAtivo(1);
            entregadorRepository.save(novoEntregador);
            System.out.println("\n<!>Cadastro efetuado com sucesso<!>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notificacoesDeEntrega() {
        try {
            instanciarNovasEntregas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nNovas entregas foram solicitadas! Mantenha o bom trabalho 👍!\n");
    }

    public void instanciarNovasEntregas() {
        List<Abrigo> abrigos = abrigoRepository.findAll();
        List<Pessoa> pessoas = pessoaRepository.findAll(); // Pegando todas as pessoas do banco

        if (abrigos.isEmpty() || pessoas.isEmpty()) {
            System.out.println("\nNão há abrigos ou pessoas disponíveis para criar novas entregas.\n");
            return;
        }

        Random random = new Random();
        int quantidadeEntregas = random.nextInt(3) + 3; // De 3 a 5 entregas

        List<String> descricoes = List.of(
                "Entrega urgente de suprimentos médicos",
                "Pacote de ferramentas especializadas",
                "Encomenda confidencial — manuseie com cuidado",
                "Suprimento alimentar para longas viagens",
                "Entrega de peças de reposição para veículos",
                "Correspondência oficial da BRIDGES",
                "Remessa de roupas térmicas",
                "Material de construção leve",
                "Documentos importantes",
                "Pacote de dispositivos eletrônicos",
                "Entrega de kits de primeiros socorros",
                "Encomenda de medicamentos",
                "Recursos de fabricação para abrigos",
                "Pacote de baterias de longa duração",
                "Caixa de materiais recicláveis"
        );

        List<Entrega> novasEntregas = new ArrayList<>();
        for (int i = 0; i < quantidadeEntregas; i++) {
            Abrigo abrigoOrigem = abrigos.get(random.nextInt(abrigos.size()));
            Abrigo abrigoDestino;
            do {
                abrigoDestino = abrigos.get(random.nextInt(abrigos.size()));
            } while (abrigoDestino.equals(abrigoOrigem));

            Pessoa pessoa = pessoas.get(random.nextInt(pessoas.size())); // Pessoa aleatória

            Entrega entrega = new Entrega();
            entrega.setAbrigoOrigem(abrigoOrigem);
            entrega.setPessoa(pessoa);
            entrega.setDescricao(descricoes.get(random.nextInt(descricoes.size())));
            entrega.setPeso(random.nextDouble() * 100); // Peso entre 0 e 100kg
            entrega.setStatus(StatusEntrega.PENDENTE);
            entrega.setDataPedido(LocalDate.now());

            entregaRepository.save(entrega);

            System.out.println("|Nova entrega em " + pessoa.getAbrigo().getNome() + "|");
        }

    }

    public void apresentarPerfil(Entregador entregador) {
        System.out.println("\n======================================================");
        System.out.printf("%-20s: %s%n", "Identificação", entregador.getId());
        System.out.printf("%-20s: %s%n", "Nome", entregador.getNome());
        System.out.printf("%-20s: %s%n", "Empresa", entregador.getEmpresa());
        System.out.println("===================| PROGRESSO |======================");
        System.out.printf("%-20s: %d%n", "Nível", entregador.getNivel());
        System.out.printf("%-20s: %dxp%n", "Experiência", entregador.getExperiencia());
        System.out.println("======================================================");
    }

    public void apresentarUltimasEntregas(Entregador entregador) {
        try {
            System.out.println("\n|Últimas 20 entregas de " + entregador.getNome() + " |\n");
            List<Entrega> listaDeEntregas = entregaRepository.findByEntregadorId(entregador.getId());
            if (!listaDeEntregas.isEmpty()) {
                imprimirEntregas(listaDeEntregas);
            } else {
                System.out.println("\nNenhuma entrega encontrada.\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void imprimirEntregas(List<Entrega> lista) {
        // Ordena pela data de pedido, da mais recente para a mais antiga
        lista.sort(Comparator.comparing(Entrega::getDataPedido).reversed());

        // Pega as últimas 20 entregas (ou menos, se não tiver 20)
        List<Entrega> ultimasEntregas = lista.stream()
                .limit(20)
                .toList();

        // Cria colunas
        StringColumn idColumn = StringColumn.create("ID", ultimasEntregas.stream()
                .map(entrega -> entrega.getId().toString())
                .toArray(String[]::new));

        StringColumn descricaoColumn = StringColumn.create("Descrição", ultimasEntregas.stream()
                .map(Entrega::getDescricao)
                .toArray(String[]::new));

        StringColumn pessoaColumn = StringColumn.create("Para", ultimasEntregas.stream()
                .map(entrega -> entrega.getPessoa().getNome())
                .toArray(String[]::new));

        StringColumn localColumn = StringColumn.create("Local", ultimasEntregas.stream()
                .map(entrega -> entrega.getAbrigoOrigem().getNome())
                .toArray(String[]::new));

        StringColumn dificuldadeColumn = StringColumn.create("Dificuldade", ultimasEntregas.stream()
                .map(entrega -> entrega.getDificuldade())
                .toArray(String[]::new));

        StringColumn dataPedidoColumn = StringColumn.create("Data Pedido", ultimasEntregas.stream()
                .map(entrega -> entrega.getDataPedido().toString())
                .toArray(String[]::new));

        StringColumn dataInicioColumn = StringColumn.create("Data Início", ultimasEntregas.stream()
                .map(entrega -> entrega.getDataInicio().toString())
                .toArray(String[]::new));

        StringColumn dataConclusaoColumn = StringColumn.create("Data Conclusão", ultimasEntregas.stream()
                .map(entrega -> entrega.getDataConclusao().toString())
                .toArray(String[]::new));

        StringColumn statusColumn = StringColumn.create("Status", ultimasEntregas.stream()
                .map(entrega -> entrega.getStatus().toString())
                .toArray(String[]::new));


        // Cria tabela
        Table table = Table.create("Últimas 20 Entregas").addColumns(
                idColumn,
                descricaoColumn,
                pessoaColumn,
                localColumn,
                dificuldadeColumn,
                dataPedidoColumn,
                dataInicioColumn,
                dataConclusaoColumn,
                statusColumn
        );

        // Imprime tabela
        System.out.println(table);
    }

}
