/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.objects;

/**
 *
 * @author Neto
 */
public class Produto {
    
    private int id;
    private String nome;
    private int precoComp;
    private Double precoVend;
    private int Fornecedor ;
    private String estoque;
    private String unidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrecoComp() {
        return precoComp;
    }

    public void setPrecoComp(int precoComp) {
        this.precoComp = precoComp;
    }

    public Double getPrecoVend() {
        return precoVend;
    }

    public void setPrecoVend(Double precoVend) {
        this.precoVend = precoVend;
    }

    public int getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(int Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

}
