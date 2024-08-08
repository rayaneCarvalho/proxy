package org.example;

import java.util.List;

public interface IFuncionario {
    List<String> obterDadosPessoais();
    Double obterSalario(Acesso acesso);
}

