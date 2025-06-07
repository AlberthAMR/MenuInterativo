# 📚 Sistema de Cadastro de Alunos de Escolinha de Futebol

Este é um sistema simples de cadastro de alunos desenvolvido em Java. Ele permite criar, listar, buscar, editar e excluir registros de alunos, armazenando os dados em um arquivo de texto (alunos.txt).

## 🛠 Tecnologias Utilizadas

- Java
- Orientação a Objetos
- Manipulação de arquivos (FileReader, FileWriter)
- Estrutura de dados (ArrayList)

---

## ✅ Funcionalidades

1. *Criar novo registro de aluno:*  
   O usuário informa os dados de um aluno (nome, data de nascimento, posição, telefone, CPF e e-mail), que são salvos em memória e no arquivo alunos.txt.

2. *Listar alunos cadastrados:*  
   Mostra todos os alunos registrados.

3. *Buscar aluno por nome:*  
   Permite procurar um aluno digitando seu nome. A busca não diferencia maiúsculas de minúsculas.

4. *Editar aluno:*  
   Permite alterar os dados de um aluno já existente.

5. *Excluir aluno:*  
   Remove um aluno da lista e do arquivo com base no nome informado.

6. *Sair do programa:*  
   Encerra a execução.

---

## 📂 Estrutura Esperada

Para que o sistema funcione corretamente, usa-se das seguintes classes:

- Menu.java → classe principal com o menu interativo.
- Aluno.java → classe modelo representando o aluno.
- AlunoArquivo.java → classe utilitária para salvar e carregar os dados de/para alunos.txt.
