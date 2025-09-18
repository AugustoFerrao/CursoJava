package aplicacao;

import java.io.*;
import java.util.*;

import entidades.*;

public class Programa {
    static final String PRODUTOS_FILE = "produtos.txt";
    static final String USUARIOS_FILE = "usuarios.txt";
    static final String VENDAS_FILE = "vendas.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = carregarProdutos();
        List<Usuario> usuarios = carregarUsuarios();

        menu(scanner, produtos, usuarios);
    }

    // Função que exibe o menu e chama as opções recursivamente
    public static void menu(Scanner scanner, List<Produto> produtos, List<Usuario> usuarios) throws IOException {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Efetuar Venda");
        System.out.println("2 - Visualizar Compras");
        System.out.println("3 - Cadastrar Cliente");
        System.out.println("4 - Remover Cliente");
        System.out.println("5 - Controle de Estoque");
        System.out.println("0 - Fechar Programa");
       
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                efetuarVenda(scanner, produtos, usuarios);
                break;
            case 2:
                visualizarVendas(scanner);
                break;
            case 3:
                cadastrarCliente(scanner, usuarios);
                break;
            case 4:
                removerCliente(scanner, usuarios);
                break;
            case 5:
                controleEstoque(scanner, produtos);
                break;
            case 0:
                System.out.println("Fechando o programa...");
                salvarProdutos(produtos);
                salvarUsuarios(usuarios);
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }

        menu(scanner, produtos, usuarios);
    }
    
    // Função para controlar o estoque
    public static void controleEstoque(Scanner scanner, List<Produto> produtos) throws IOException {
        System.out.println("\nControle de Estoque:");
        System.out.println("1 - Visualizar Estoque");
        System.out.println("2 - Repor Estoque");
        System.out.println("3 - Cadastrar Novo Produto");
        System.out.println("4 - Remover Produto");
        System.out.println("0 - Voltar Menu Principal");

        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                visualizarEstoque(produtos);
                break;
            case 2:
                reporEstoque(scanner, produtos);
                break;
            case 3:
                cadastrarNovoProduto(scanner, produtos);
                break;
            case 4:
            	removerProduto(scanner, produtos);
            case 0:
                return;  // Volta ao menu principal
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }

        salvarProdutos(produtos);
        controleEstoque(scanner, produtos);
    }

    // Função para visualizar todas as vendas ou procurar por CPF
    public static void visualizarVendas(Scanner scanner) throws IOException {
        System.out.println("\n1 - Visualizar todas as compras");
        System.out.println("2 - Procurar compra por CPF");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir o '\n' do buffer

        switch (opcao) {
            case 1:
                exibirTodasVendas();
                break;
            case 2:
                procurarVendaPorCpf(scanner);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
    
    // Função para efetuar a venda
    public static void efetuarVenda(Scanner scanner, List<Produto> produtos, List<Usuario> usuarios) throws IOException {
        Usuario usuario = buscarOuCadastrarUsuario(scanner, usuarios);
        Venda venda = new Venda(usuario);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nProdutos disponíveis:");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i+1) + " - " + produtos.get(i));
            }

            System.out.print("Escolha o índice do produto: ");
            int indice = (scanner.nextInt()-1);
            System.out.print("Quantidade: ");
            int qtd = scanner.nextInt();

            if (indice >= 0 && indice < produtos.size()) {
                venda.adicionarItem(produtos.get(indice), qtd);
            }

            System.out.print("Deseja adicionar mais produtos? (s/n): ");
            scanner.nextLine();
            String resposta = scanner.nextLine();
            continuar = resposta.equalsIgnoreCase("s");
        }

        venda.exibirResumo();
        System.out.println("Venda concluída e dados salvos.");
        salvarVenda(venda);
    }

    // Função para cadastrar um novo cliente
    public static void cadastrarCliente(Scanner scanner, List<Usuario> usuarios) throws IOException {
        System.out.println("\nCadastro de novo usuário:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Usuario usuario = new Usuario(nome, cpf, email, endereco);
        usuarios.add(usuario);
        salvarUsuarios(usuarios);

        System.out.println("Usuário cadastrado com sucesso!");
    }
    
    // Função para remover um cliente
    public static void removerCliente(Scanner scanner, List<Usuario> usuarios) throws IOException {
        System.out.println("\nRemover Cliente:");
        System.out.print("Digite o CPF do cliente a ser removido: ");
        String cpfRemover = scanner.nextLine();

        Usuario usuarioRemover = null;
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpfRemover)) {
                usuarioRemover = u;
                break;
            }
        }

        if (usuarioRemover != null) {
            usuarios.remove(usuarioRemover);
            salvarUsuarios(usuarios);
            System.out.println("Cliente " + usuarioRemover.getNome() + " removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Função para buscar um cliente existente ou cadastrar um novo
    public static Usuario buscarOuCadastrarUsuario(Scanner scanner, List<Usuario> usuarios) throws IOException {
        Usuario usuario = null;

        System.out.print("Usuário já está cadastrado? (s/n): ");
        String jaCadastrado = scanner.nextLine();

        if (jaCadastrado.equalsIgnoreCase("s")) {
            System.out.print("Digite o CPF do usuário: ");
            String cpfBusca = scanner.nextLine();

            for (Usuario u : usuarios) {
                if (u.getCpf().equals(cpfBusca)) {
                    usuario = u;
                    System.out.println("Usuário encontrado: " + u.getNome());
                    break;
                }
            }

            if (usuario == null) {
                System.out.println("Usuário não encontrado. Cadastre agora:");
            }
        }

        if (usuario == null) {
            cadastrarCliente(scanner, usuarios);
            usuario = usuarios.get(usuarios.size() - 1);
        }

        return usuario;
    }

    // Função para visualizar o estoque
    public static void visualizarEstoque(List<Produto> produtos) {
        System.out.println("\nEstoque Atual:");
        for (Produto p : produtos) {
            System.out.println(p.getNome() + " - R$" + p.getPreco() + " - Quantidade: " + p.getQuantidade());
        }
    }

    // Função para repor estoque
    public static void reporEstoque(Scanner scanner, List<Produto> produtos) {
        System.out.println("\nRepor Estoque:");
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        Produto produto = null;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                produto = p;
                break;
            }
        }

        if (produto != null) {
            System.out.print("Digite a quantidade a ser reposta: ");
            int quantidade = scanner.nextInt();
            produto.setQuantidade(produto.getQuantidade() + quantidade);
            System.out.println("Estoque de " + produto.getNome() + " atualizado. Nova quantidade: " + produto.getQuantidade());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Função para cadastrar um novo produto
    public static void cadastrarNovoProduto(Scanner scanner, List<Produto> produtos) {
        System.out.println("\nCadastro de Novo Produto:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(nome, preco, quantidade);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }
    
    // Função para remover um produto
    public static void removerProduto(Scanner scanner, List<Produto> produtos) throws IOException {
        System.out.println("\nRemover Produto:");
        System.out.print("Digite o nome do produto a ser removido: ");
        String nomeProdutoRemover = scanner.nextLine();

        Produto produtoRemover = null;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nomeProdutoRemover)) {
                produtoRemover = p;
                break;
            }
        }

        if (produtoRemover != null) {
            produtos.remove(produtoRemover);
            salvarProdutos(produtos);
            System.out.println("Produto " + produtoRemover.getNome() + " removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
    
    // Carregar e salvar produtos
    static List<Produto> carregarProdutos() throws IOException {
        List<Produto> lista = new ArrayList<>();
        File arquivo = new File(PRODUTOS_FILE);
        if (arquivo.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Produto.fromString(linha));
            }
            br.close();
        }
        return lista;
    }

    static void salvarProdutos(List<Produto> produtos) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(PRODUTOS_FILE));
        for (Produto p : produtos) {
            bw.write(p.toString());
            bw.newLine();
        }
        bw.close();
    }

    // Carregar e salvar usuários
    static List<Usuario> carregarUsuarios() throws IOException {
        List<Usuario> lista = new ArrayList<>();
        File arquivo = new File(USUARIOS_FILE);
        if (arquivo.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Usuario.fromString(linha));
            }
            br.close();
        }
        return lista;
    }

    static void salvarUsuarios(List<Usuario> usuarios) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(USUARIOS_FILE));
        for (Usuario u : usuarios) {
            bw.write(u.toString());
            bw.newLine();
        }
        bw.close();
    }
    
    // Salva os dados da venda
    public static void salvarVenda(Venda venda) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(VENDAS_FILE, true));
        bw.write("CPF: " + venda.getUsuario().getCpf() + "\n");
        bw.write("Compra realizada por: " + venda.getUsuario().getNome() + "\n");
        bw.write("Data da compra: " + venda.getDataVenda() + "\n");
        bw.write("Itens comprados:\n");
        for (ItemVenda item : venda.getItens()) {
            bw.write(item.toString() + "\n");
        }
        bw.write("Total: R$" + venda.getTotal() + "\n");
        bw.write("====================================\n");
        bw.close();
    }
    
 // Função para exibir todas as vendas
    public static void exibirTodasVendas() throws IOException {
        File arquivo = new File(VENDAS_FILE);
        if (arquivo.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha;
            System.out.println("\nVendas Registradas:");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);  // Exibe cada venda registrada
            }
            br.close();
        } else {
            System.out.println("Nenhuma venda registrada.");
        }
    }

    // Função para procurar venda por CPF
    public static void procurarVendaPorCpf(Scanner scanner) throws IOException {
        System.out.print("\nDigite o CPF do cliente para procurar a compra: ");
        String cpfDigitado = scanner.nextLine().trim();

        File arquivo = new File(VENDAS_FILE);
        if (arquivo.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha;
            boolean encontrouVendas = false;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.startsWith("CPF: ")) {
                    String cpfCliente = linha.substring("CPF: ".length()).trim();
                    if (cpfCliente.equals(cpfDigitado)) {
                        encontrouVendas = true;
                        System.out.println("\nCompra encontrada para o CPF: " + cpfDigitado);
                        while ((linha = br.readLine()) != null && !linha.startsWith("CPF: ")) {
                            System.out.println(linha);
                        }
                        System.out.println("====================================");
                    }
                }
            }
            br.close();

            if (!encontrouVendas) {
                System.out.println("Nenhuma compra encontrada para o CPF: " + cpfDigitado);
            }
        } else {
            System.out.println("Nenhuma compra registrada.");
        }
    }
}
