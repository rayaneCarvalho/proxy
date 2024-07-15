package java;

import java.Funcionario;
import java.util.HashMap;
import java.util.Map;

public class FuncionarioData {
    private static Map<Integer, Funcionario> funcionarios = new HashMap<>();

    static {
        // Adicionando funcionários ao "banco de dados"
        funcionarios.put(1, new Funcionario(1, "João", "TI", 5000.0));
        funcionarios.put(2, new Funcionario(2, "Maria", "Financeiro", 7000.0));
    }

    public static Funcionario getFuncionario(Integer id) {
        return funcionarios.get(id);
    }
}
