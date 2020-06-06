package up.edu.br.crudfuncionario.model;

public class Funcionario {

    private Long guidFuncionario;
    private String nome;
    private String cpf;
    private String cargo;
    private String email;
    private String telefone;

    public Funcionario() {
    }

    public String toString() {
        return nome + " - " + cargo;
    }

    public Long getGuidFuncionario() {
        return guidFuncionario;
    }

    public void setGuidFuncionario(Long guidFuncionario) {
        this.guidFuncionario = guidFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
