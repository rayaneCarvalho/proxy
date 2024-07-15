package java;

import java.util.Arrays;
import java.util.List;

public class Funcionario implements IFuncionario {
    private Integer id;
    private String nome;
    private String departamento;
    private Double salario;

    public Funcionario(Integer id, String nome, String departamento, Double salario) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.departamento);
    }

    @Override
    public Double obterSalario(Acesso acesso) {
        if (!acesso.temPermissao()) {
            throw new IllegalArgumentException("java.Acesso não autorizado");
        }
        return this.salario;
    }
}
