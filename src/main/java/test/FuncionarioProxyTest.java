package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.Acesso;
import org.example.FuncionarioData;
import org.example.FuncionarioProxy;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioProxyTest {

    @BeforeEach
    void setUp() {
        FuncionarioData.getFuncionario(1);
        FuncionarioData.getFuncionario(2);
    }

    @Test
    void deveRetornarDadosPessoaisFuncionario() {
        FuncionarioProxy proxy = FuncionarioProxy.getInstance(1);

        Assertions.assertEquals(Arrays.asList("Maria", "Financeiro"), proxy.obterDadosPessoais());
    }

    @Test
    void deveRetornarSalarioFuncionario() {
        Acesso acessoAdmin = new Acesso("Administrador", true);
        FuncionarioProxy proxy = FuncionarioProxy.getInstance(2);

        Assertions.assertEquals(7000.0, proxy.obterSalario(acessoAdmin));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizadoConsultarSalarioFuncionario() {
        try {
            Acesso acessoNormal = new Acesso("Funcionário", false);
            FuncionarioProxy proxy = FuncionarioProxy.getInstance(2);

            proxy.obterSalario(acessoNormal);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("java.org.example.Acesso não autorizado", e.getMessage());
        }
    }
}
