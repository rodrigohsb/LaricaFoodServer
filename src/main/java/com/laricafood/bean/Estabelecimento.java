package com.laricafood.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public class Estabelecimento {

    private int id;
    private String name;
    private User user_id;
    private String address;
    private String neighborhood;
    private String city;
    private Float latitude;
    private Float longitude;
    private Float pontuacao;
    private int votos;
    private String foto1;
    private String foto2;
    private String foto3;
    private String foto4;
    private Date createDate;
    private Date updateDate;
    private List<Comida> comidas;

    public Estabelecimento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Float pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public String getFoto4() {
        return foto4;
    }

    public void setFoto4(String foto4) {
        this.foto4 = foto4;
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

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                ", address='" + address + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", pontuacao=" + pontuacao +
                ", votos=" + votos +
                ", foto1='" + foto1 + '\'' +
                ", foto2='" + foto2 + '\'' +
                ", foto3='" + foto3 + '\'' +
                ", foto4='" + foto4 + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", comidas=" + comidas +
                '}';
    }
}