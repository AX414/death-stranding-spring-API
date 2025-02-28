package br.com.death.strandingAPI.main;

import br.com.death.strandingAPI.enums.Empresa;
import br.com.death.strandingAPI.enums.StatusEntrega;
import br.com.death.strandingAPI.models.Abrigo;
import br.com.death.strandingAPI.models.Entrega;
import br.com.death.strandingAPI.models.Entregador;
import br.com.death.strandingAPI.models.Pessoa;
import br.com.death.strandingAPI.repositories.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
    private Optional<Entregador> entregadorLogado = Optional.of(new Entregador());

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
                    entregadorLogado = Optional.empty();
                    break;
                default:
                    System.out.println("\nOpção inválida.");
                    break;
            }

        } while (op != 0);
    }

    public void menu() {
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
                    apresentarPerfil();
                    break;
                case 2:
                    apresentarUltimasEntregas();
                    break;
                case 3:
                    selecionarAbrigo();
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
            entregadorLogado = entregadorOptional;
            System.out.println("\nBem-vindo, " + entregadorLogado.get().getNome() + "!\n\n\n");
            menu();
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

    public void selecionarAbrigo() {
        try {
            List<Abrigo> abrigos = abrigoRepository.findAll();

            if (abrigos.isEmpty()) {
                System.out.println("\nNenhum abrigo encontrado.");
                return;
            }

            Optional<Abrigo> abrigo;
            do {
                imprimirAbrigos(abrigos);

                System.out.print("\n\nInsira o nome do abrigo para verificar as entregas disponíveis:\nR.: ");
                var nomeAbrigo = lerString.nextLine();

                abrigo = abrigoRepository.findByNome(nomeAbrigo);

                if (abrigo.isPresent()) {
                    System.out.println("\nAbrigo selecionado. Verificando entregas disponíveis...\n");
                    apresentarEntregasAbrigo(abrigo.get());
                } else {
                    System.out.println("\nAbrigo não encontrado, insira um nome válido.");
                }
            } while (abrigo != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apresentarEntregasAbrigo(Abrigo abrigo){
        imprimirEntregas(abrigo.getHistoricoEntregas());

        int op = 10000;

        do{
            System.out.print("\nDeseja selecionar alguma entrega? (1 - Sim | 0 - Não)\nR.: ");
            op = lerInt.nextInt();

            switch (op){
                case 1:
                    selecionarEntregas(abrigo.getHistoricoEntregas());
                    break;
                case 0:
                    System.out.println("\nEncerrando consulta.");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
                    break;
            }

        }while(op!=0);
    }

    public void selecionarEntregas(List<Entrega> entregasHistorico) {
        // Filtra apenas as entregas sem entregador
        List<Entrega> entregasDisponiveis = entregasHistorico.stream()
                .filter(entrega -> entrega.getEntregador() == null)
                .collect(Collectors.toList());

        if (entregasDisponiveis.isEmpty()) {
            System.out.println("\nNão há entregas disponíveis neste abrigo.");
            return;
        }

        imprimirEntregas(entregasDisponiveis);

        System.out.print("\n\nInsira o identificador da entrega para aceitar o contrato de entrega:\nR.: ");
        var entregaId = lerString.nextLine();

        Optional<Entrega> entregaOptional = entregasDisponiveis.stream()
                .filter(e -> e.getId().equals(entregaId))
                .findFirst();

        if (entregaOptional.isPresent()) {
            Entrega entrega = entregaOptional.get();

            // Adiciona o peso da entrega ao entregador logado
            entregadorLogado.get().adicionarPeso(entrega.getPeso());

            // Adiciona a entrega à lista de entregas do entregador
            entregadorLogado.get().getEntregas().add(entrega);
            entregadorRepository.save(entregadorLogado.get());

            // Atualiza a entrega associando o entregador e inserindo a data de início
            entrega.setEntregador(entregadorLogado.get());
            entrega.setDataInicio(LocalDate.from(LocalDateTime.now()));
            entregaRepository.save(entrega);

            // Remove a entrega da lista de entregas disponíveis do abrigo de origem
            Abrigo abrigoOrigem = entrega.getAbrigoOrigem();
            abrigoOrigem.getHistoricoEntregas().remove(entrega);
            abrigoRepository.save(abrigoOrigem);

            System.out.println("\nEntrega selecionada com sucesso!");
        } else {
            System.out.println("\nEntrega não encontrada ou já atribuída.");
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
            entrega.setDificuldade(random.nextInt() * 5);
            entrega.setExperiencia(random.nextInt() * 350);

            entregaRepository.save(entrega);

            System.out.println("|Nova entrega em " + pessoa.getAbrigo().getNome() + "|");
        }

    }

    public void apresentarPerfil() {
        System.out.println("\n======================================================");
        System.out.printf("%-20s: %s%n", "Identificação", entregadorLogado.get().getId());
        System.out.printf("%-20s: %s%n", "Nome", entregadorLogado.get().getNome());
        System.out.printf("%-20s: %s%n", "Empresa", entregadorLogado.get().getEmpresa());
        System.out.println("===================| PROGRESSO |======================");
        System.out.printf("%-20s: %d%n", "Nível", entregadorLogado.get().getNivel());
        System.out.printf("%-20s: %dxp%n", "Experiência", entregadorLogado.get().getExperiencia());
        System.out.println("======================================================");
    }

    public void apresentarUltimasEntregas() {
        try {
            System.out.println("\n|Últimas 20 entregas de " + entregadorLogado.get().getNome() + " |\n");
            List<Entrega> listaDeEntregas = entregaRepository.findByEntregadorId(entregadorLogado.get().getId());
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
        System.out.println("\n\nApresentando Entregas:");
        for (Entrega e : lista) {
            System.out.println(e);
        }
    }

    public void imprimirAbrigos(List<Abrigo> lista) {
        System.out.println("\n\nApresentando Abrigos:");
        for (Abrigo a : lista) {
            System.out.println(a);
        }
    }
}
