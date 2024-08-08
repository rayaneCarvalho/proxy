package org.example;

public class Acesso {
    private String nome;
    private boolean permissao;

    public Acesso(String nome, boolean permissao) {
        this.nome = nome;
        this.permissao = permissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean temPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }
}

