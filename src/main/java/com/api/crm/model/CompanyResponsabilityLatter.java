package com.api.crm.model;

public class CompanyResponsabilityLatter {
   private String razao;
   private String endereco;
   private String numero;
   private String bairro;
   private String codigoMunicipio;
   private String municipio;
   private String uf;
   private String cep;

   public CompanyResponsabilityLatter(String razao, String endereco, String numero, String bairro, String codigoMunicipio, String municipio, String uf, String cep) {
      this.razao = razao;
      this.endereco = endereco;
      this.numero = numero;
      this.bairro = bairro;
      this.codigoMunicipio = codigoMunicipio;
      this.municipio = municipio;
      this.uf = uf;
      this.cep = cep;
   }

   public String getRazao() {
      return this.razao;
   }

   public void setRazao(String razao) {
      this.razao = razao;
   }

   public String getEndereco() {
      return this.endereco;
   }

   public void setEndereco(String endereco) {
      this.endereco = endereco;
   }

   public String getNumero() {
      return this.numero;
   }

   public void setNumero(String numero) {
      this.numero = numero;
   }

   public String getBairro() {
      return this.bairro;
   }

   public void setBairro(String bairro) {
      this.bairro = bairro;
   }

   public String getCodigoMunicipio() {
      return this.codigoMunicipio;
   }

   public void setCodigoMunicipio(String codigoMunicipio) {
      this.codigoMunicipio = codigoMunicipio;
   }

   public String getMunicipio() {
      return this.municipio;
   }

   public void setMunicipio(String municipio) {
      this.municipio = municipio;
   }

   public String getUf() {
      return this.uf;
   }

   public void setUf(String uf) {
      this.uf = uf;
   }

   public String getCep() {
      return this.cep;
   }

   public void setCep(String cep) {
      this.cep = cep;
   }
}
