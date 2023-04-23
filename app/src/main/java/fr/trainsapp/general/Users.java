package fr.trainsapp.general;

public class Users {
    private String sNom;
    private String sPrenom;
    private String sPseudo;
    private String sMail;
    private String sMdp;

    public Users(){

    }


    public Users(String sNom, String sPrenom, String sPseudo, String sMail, String sMdp) {
        this.sNom = sNom;
        this.sPrenom = sPrenom;
        this.sPseudo = sPseudo;
        this.sMail = sMail;
        this.sMdp = sMdp;
    }

    public String getsNom() {
        return sNom;
    }

    public void setsNom(String sNom) {
        this.sNom = sNom;
    }

    public String getsPrenom() {
        return sPrenom;
    }

    public void setsPrenom(String sPrenom) {
        this.sPrenom = sPrenom;
    }

    public String getsPseudo() {
        return sPseudo;
    }

    public void setsPseudo(String sPseudo) {
        this.sPseudo = sPseudo;
    }

    public String getsMail() {
        return sMail;
    }

    public void setsMail(String sMail) {
        this.sMail = sMail;
    }

    public String getsMdp() {
        return sMdp;
    }

    public void setsMdp(String sMdp) {
        this.sMdp = sMdp;
    }
}
