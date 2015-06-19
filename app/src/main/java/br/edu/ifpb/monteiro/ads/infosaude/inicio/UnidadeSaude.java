package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import java.io.Serializable;

/**
 * Created by vanderlan on 17/06/15.
 */
public class UnidadeSaude implements Serializable {


    private static final Long serialVersionUID = 1L;

    private Long id;
    private Integer cnes;
    private String nome;
    private String logradouro;
    private Integer enderecoNumero;
    private String cep;
    private String bairro;
    private String cidade;
    private EnumEstados estado;
    private Integer numero;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getCnes() {
        return cnes;
    }
    public void setCnes(Integer cnes) {
        this.cnes = cnes;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public Integer getEnderecoNumero() {
        return enderecoNumero;
    }
    public void setEnderecoNumero(Integer enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public EnumEstados getEstado() {
        return estado;
    }
    public void setEstado(EnumEstados estado) {
        this.estado = estado;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = hash * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UnidadeSaude other = (UnidadeSaude) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}