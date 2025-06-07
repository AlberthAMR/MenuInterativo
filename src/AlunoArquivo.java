import java.util.ArrayList;
import java.io.*;

public class AlunoArquivo {
    // Salva a lista de alunos no arquivo
    public static void salvarAlunos(ArrayList<Aluno> alunos, String nomeArquivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
        for (Aluno aluno : alunos) {
            // Campos separados por ";"
            writer.write(aluno.getNome() + ";" +
                         aluno.getDataNascimento() + ";" +
                         aluno.getPosicao() + ";" +
                         aluno.getTelefone() + ";" +
                         aluno.getCpf() + ";" +
                         aluno.getEmail() + ";" +
                         aluno.getNomeResponsavel());
            writer.newLine();
        }
        writer.close();
    }

    // Carrega a lista de alunos do arquivo
    public static ArrayList<Aluno> carregarAlunos(String nomeArquivo) throws IOException {
        ArrayList<Aluno> alunos = new ArrayList<>();
        File file = new File(nomeArquivo);
        if (!file.exists()) {
            return alunos; // Retorna lista vazia se não existir
        }
        BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] partes = linha.split(";", -1);
            if (partes.length == 7) {
                Aluno aluno = new Aluno(
                    partes[0], // nome
                    partes[1], // dataNascimento
                    partes[2], // posicao
                    partes[3], // telefone
                    partes[4], // cpf
                    partes[5], // email
                    partes[6]  // nomeResponsavel
                );
                alunos.add(aluno);
            }
        }
        reader.close();
        return alunos;
    }
}