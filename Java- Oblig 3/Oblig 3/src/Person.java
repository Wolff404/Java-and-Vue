public class Person {
    private String fornavn;
    private String etternavn;
    private int alder;

    public Person(String fornavn, String etternavn, int alder) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
    }

    public String gatherFullName(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        return fornavn + " " + etternavn;

    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }


    @Override
    public String toString() {
        return gatherFullName(getFornavn(),getEtternavn());
    }

}


