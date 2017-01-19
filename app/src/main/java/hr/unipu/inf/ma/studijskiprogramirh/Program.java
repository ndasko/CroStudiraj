package hr.unipu.inf.ma.studijskiprogramirh;

/**
 * Created by Dijana on 1.12.2016..
 */

public class Program { //KLASA VEZANA ZA STUDIJSKI PROGRAM

    long id;
    String naziv;
    String name;
    double trajanje;
    int ects;
    String titula;
    String url;
    String studij;
    String polje;
    String znanost;
    String sastavnica;
    String uciliste;
    String grad;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(double trajanje) {
        this.trajanje = trajanje;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStudij() {
        return studij;
    }

    public void setStudij(String studij) {
        this.studij = studij;
    }

    public String getPolje() {
        return polje;
    }

    public void setPolje(String polje) {
        this.polje = polje;
    }

    public String getZnanost() {
        return znanost;
    }

    public void setZnanost(String znanost) {
        this.znanost = znanost;
    }

    public String getSastavnica() {
        return sastavnica;
    }

    public void setSastavnica(String sastavnica) {
        this.sastavnica = sastavnica;
    }

    public String getUciliste() {
        return uciliste;
    }

    public void setUciliste(String uciliste) {
        this.uciliste = uciliste;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Program(){
    }

    public Program (String naziv, String name, double trajanje, int ects, String titula, String url, String studij, String polje, String znanost, String sastavnica, String uciliste, String grad){
        this.naziv = naziv;
        this.name = name;
        this.trajanje = trajanje;
        this.ects = ects;
        this.titula = titula;
        this.url = url;
        this.studij = studij;
        this.polje = polje;
        this.znanost = znanost;
        this.sastavnica = sastavnica;
        this.uciliste = uciliste;
        this.grad = grad;
    }
}