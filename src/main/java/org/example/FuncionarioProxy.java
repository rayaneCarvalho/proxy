package org.example;

import java.util.List;

public class FuncionarioProxy implements IFuncionario {
    private static FuncionarioProxy instance;
    private Funcionario funcionario;
    private Integer id;

    private FuncionarioProxy(Integer id) {
        this.id = id;
    }

    public static synchronized FuncionarioProxy getInstance(Integer id) {
        if (instance == null) {
            instance = new FuncionarioProxy(id);
        } else {
            instance.id = id;
        }
        return instance;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.funcionario == null) {
            this.funcionario = FuncionarioData.getFuncionario(this.id);
        }
        return this.funcionario.obterDadosPessoais();
    }

    @Override
    public Double obterSalario(Acesso acesso) {
        if (!acesso.temPermissao()) {
            throw new IllegalArgumentException("java.org.example.Acesso não autorizado");
        }
        if (this.funcionario == null) {
            this.funcionario = FuncionarioData.getFuncionario(this.id);
        }
        return this.funcionario.obterSalario(acesso);
    }
}
