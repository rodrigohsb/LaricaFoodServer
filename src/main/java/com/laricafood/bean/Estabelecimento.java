package com.laricafood.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public class Estabelecimento {

    private int id;

    private String nome;

    private String endereco;

    private int proprietario;

    private String bairro;

    private String cidade;

    private float latitude;

    private float longitude;

    private float pontuacao;

    private int qntVotos;

    private List<String> fotos;

    private Date createDate;

    private Date updateDate;

    public Estabelecimento() {
        super();
    }

    public Estabelecimento(String nome, String endereco, String bairro, String cidade, List<String> fotos,
                           int proprietario) {
        super();
        this.nome = nome;
        this.endereco = endereco;
        this.proprietario = proprietario;
        this.bairro = bairro;
        this.cidade = cidade;
        this.fotos = fotos;
    }

    public Estabelecimento(int id, String nome, String endereco, int proprietario, String bairro, String cidade,
                           float latitude, float longitude, float pontuacao, int qntVotos, List<String> fotos, Date createDate,
                           Date updateDate) {
        super();
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.proprietario = proprietario;
        this.bairro = bairro;
        this.cidade = cidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pontuacao = pontuacao;
        this.qntVotos = qntVotos;
        this.fotos = fotos;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(float pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getQntVotos() {
        return qntVotos;
    }

    public void setQntVotos(int qntVotos) {
        this.qntVotos = qntVotos;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Estabelecimento [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", proprietario="
                + proprietario + ", bairro=" + bairro + ", cidade=" + cidade + ", latitude=" + latitude
                + ", longitude=" + longitude + ", pontuacao=" + pontuacao + ", qntVotos=" + qntVotos + ", fotos="
                + fotos + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
    }

}
