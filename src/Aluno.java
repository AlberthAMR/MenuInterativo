public class Aluno {
    private String nome;
    private String dataNascimento;
    private String posicao;
    private String telefone;
    private String cpf;
    private String email;
    private String nomeResponsavel;

    public Aluno(String nome, String dataNascimento, String posicao, String telefone, String cpf, String email, String nomeResponsavel) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.posicao = posicao;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getPosicao() { return posicao; }
    public void setPosicao(String posicao) { this.posicao = posicao; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNomeResponsavel() { return nomeResponsavel; }
    public void setNomeResponsavel(String nomeResponsavel) { this.nomeResponsavel = nomeResponsavel; }
}