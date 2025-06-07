import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

// Classe principal do sistema de cadastro de alunos da escolinha de futebol.
// Permite criar, listar, buscar, editar e excluir registros de alunos, armazenando os dados em um arquivo de texto.

public class Menu {
    public static void main(String[] args) {
        int opcao;
        String nomeAluno, dataNascimento, posicao, telefone, cpf, email, nomeResponsavel;
        ArrayList<Aluno> alunos;

        // Carrega os alunos do arquivo ao iniciar o programa
        try {
            alunos = AlunoArquivo.carregarAlunos("alunos.txt");
        } catch (IOException e) {
            System.out.println("Erro ao carregar alunos: " + e.getMessage());
            alunos = new ArrayList<>();
        }
       
        // Scanner que vai receber e ler as informações do usuário.
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("MENU INICIAL");
            System.out.println("1 - Criar novo registro de aluno:");
            System.out.println("2 - Listar alunos cadastrados:");
            System.out.println("3 - Buscar aluno por nome:");
            System.out.println("4 - Editar aluno:");
            System.out.println("5 - Excluir aluno:");
            System.out.println("6 - Sair do programa:");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("Por favor, insira os dados do aluno.");
                System.out.print("Nome do aluno: ");
                nomeAluno = scanner.nextLine();
                System.out.print("Data de nascimento (dd/mm/aaaa): ");
                dataNascimento = scanner.nextLine();
                System.out.print("Posição no time: ");
                posicao = scanner.nextLine();
                System.out.print("Telefone: ");
                telefone = scanner.nextLine();
                System.out.print("CPF (123.456.789-10): ");
                cpf = scanner.nextLine();
                while (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                    System.out.println("CPF inválido! Digite no formato 123.456.789-10:");
                    cpf = scanner.nextLine();
                }
                System.out.print("Email: ");
                email = scanner.nextLine();
                System.out.print("Nome do responsável: ");
                nomeResponsavel = scanner.nextLine();

                Aluno novoAluno = new Aluno(nomeAluno, dataNascimento, posicao, telefone, cpf, email, nomeResponsavel);
                alunos.add(novoAluno);

                try {
                    AlunoArquivo.salvarAlunos(alunos, "alunos.txt");
                } catch (IOException e) {
                    System.out.println("Erro ao salvar alunos: " + e.getMessage());
                }

                System.out.println("Registro do aluno " + nomeAluno + " criado com sucesso!");

            } else if (opcao == 2) {
                if (alunos.isEmpty()) {
                    System.out.println("Nenhum aluno cadastrado.");
                } else {
                    for (Aluno aluno : alunos) {
                        System.out.println("Nome: " + aluno.getNome());
                        System.out.println("Data de nascimento: " + aluno.getDataNascimento());
                        System.out.println("Posição: " + aluno.getPosicao());
                        System.out.println("Telefone: " + aluno.getTelefone());
                        System.out.println("CPF: " + aluno.getCpf());
                        System.out.println("Email: " + aluno.getEmail());
                        System.out.println("Responsável: " + aluno.getNomeResponsavel());
                        System.out.println("-----------------------------");
                    }
                }
            } else if (opcao == 3) {
                System.out.print("Digite o nome do aluno que deseja buscar: ");
                String nomeBusca = scanner.nextLine();
                boolean encontrado = false;
                for (Aluno aluno : alunos) {
                    if (aluno.getNome().equalsIgnoreCase(nomeBusca)) {
                        System.out.println("Aluno encontrado:");
                        System.out.println("Nome: " + aluno.getNome());
                        System.out.println("Data de nascimento: " + aluno.getDataNascimento());
                        System.out.println("Posição: " + aluno.getPosicao());
                        System.out.println("Telefone: " + aluno.getTelefone());
                        System.out.println("CPF: " + aluno.getCpf());
                        System.out.println("Email: " + aluno.getEmail());
                        System.out.println("Responsável: " + aluno.getNomeResponsavel());
                        System.out.println("-----------------------------");
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Aluno não encontrado.");
                }
            } else if (opcao == 4) {
                System.out.print("Digite o nome do aluno que deseja editar: ");
                String nomeEditar = scanner.nextLine();
                boolean encontrado = false;
                for (Aluno aluno : alunos) {
                    if (aluno.getNome().equalsIgnoreCase(nomeEditar)) {
                        encontrado = true;
                        System.out.println("Aluno encontrado. Insira os novos dados:");
                        System.out.print("Novo nome: ");
                        aluno.setNome(scanner.nextLine());
                        System.out.print("Nova data de nascimento (dd/mm/aaaa): ");
                        aluno.setDataNascimento(scanner.nextLine());
                        System.out.print("Nova posição no time: ");
                        aluno.setPosicao(scanner.nextLine());
                        System.out.print("Novo telefone: ");
                        aluno.setTelefone(scanner.nextLine());
                        System.out.print("Novo CPF (123.456.789-10): ");
                        String novoCpf = scanner.nextLine();
                        while (!novoCpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                            System.out.println("CPF inválido! Digite no formato 123.456.789-10:");
                            novoCpf = scanner.nextLine();
                        }
                        aluno.setCpf(novoCpf);
                        System.out.print("Novo email: ");
                        aluno.setEmail(scanner.nextLine());
                        System.out.print("Novo nome do responsável: ");
                        aluno.setNomeResponsavel(scanner.nextLine());
                        System.out.println("Dados do aluno atualizados com sucesso!");
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Aluno não encontrado.");
                } else {
                    try {
                        AlunoArquivo.salvarAlunos(alunos, "alunos.txt");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar alunos: " + e.getMessage());
                    }
                }
            } else if (opcao == 5) {
                System.out.print("Digite o nome do aluno que deseja excluir: ");
                String nomeExcluir = scanner.nextLine();
                boolean removido = false;
                for (int i = 0; i < alunos.size(); i++) {
                    if (alunos.get(i).getNome().equalsIgnoreCase(nomeExcluir)) {
                        alunos.remove(i);
                        removido = true;
                        System.out.println("Aluno removido com sucesso!");
                        break;
                    }
                }
                if (!removido) {
                    System.out.println("Aluno não encontrado.");
                } else {
                    try {
                        AlunoArquivo.salvarAlunos(alunos, "alunos.txt");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar alunos: " + e.getMessage());
                    }
                }
            } else if (opcao == 6) {
                System.out.println("Saindo do programa...");
            } else {
                System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 6.");
            }
            System.out.println();
        } while (opcao != 6);

        scanner.close();
    }
}