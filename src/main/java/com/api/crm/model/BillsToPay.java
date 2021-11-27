package com.api.crm.model;

public class BillsToPay {
   private int CODI_FOR;
   private String qry_forn;
   private double NUME_ENT;
   private String qry_emissao;
   private String qry_entrada;
   private String qry_vencmto;
   private double VBRU;

   public BillsToPay(int cODI_FOR, String qry_forn, double nUME_ENT, String qry_emissao, String qry_entrada, String qry_vencmto, double vBRU) {
      this.CODI_FOR = cODI_FOR;
      this.qry_forn = qry_forn;
      this.NUME_ENT = nUME_ENT;
      this.qry_emissao = qry_emissao;
      this.qry_entrada = qry_entrada;
      this.qry_vencmto = qry_vencmto;
      this.VBRU = vBRU;
   }

   public int getCODI_FOR() {
      return this.CODI_FOR;
   }

   public void setCODI_FOR(int cODI_FOR) {
      this.CODI_FOR = cODI_FOR;
   }

   public String getQry_forn() {
      return this.qry_forn;
   }

   public void setQry_forn(String qry_forn) {
      this.qry_forn = qry_forn;
   }

   public double getNUME_ENT() {
      return this.NUME_ENT;
   }

   public void setNUME_ENT(double nUME_ENT) {
      this.NUME_ENT = nUME_ENT;
   }

   public String getQry_emissao() {
      return this.qry_emissao;
   }

   public void setQry_emissao(String qry_emissao) {
      this.qry_emissao = qry_emissao;
   }

   public String getQry_entrada() {
      return this.qry_entrada;
   }

   public void setQry_entrada(String qry_entrada) {
      this.qry_entrada = qry_entrada;
   }

   public String getQry_vencmto() {
      return this.qry_vencmto;
   }

   public void setQry_vencmto(String qry_vencmto) {
      this.qry_vencmto = qry_vencmto;
   }

   public double getVBRU() {
      return this.VBRU;
   }

   public void setVBRU(double vBRU) {
      this.VBRU = vBRU;
   }
}
