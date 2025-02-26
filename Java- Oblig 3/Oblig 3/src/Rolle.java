public class Rolle {
    private Person skuespiller;
    private String rolleFornavn;
    private String rolleEtternavn;


    public Rolle(Person skuespiller, String rolleFornavn, String rolleEtternavn) {
        this.skuespiller = skuespiller;
        this.rolleFornavn = rolleFornavn;
        this.rolleEtternavn = rolleEtternavn;
    }

    public Person getSkuespiller() {
        return skuespiller;
    }

    public void setSkuespiller(Person skuespiller) {
        this.skuespiller = skuespiller;
    }

    public String getRolleFornavn() {
        return rolleFornavn;
    }

    public void setRolleFornavn(String rolleFornavn) {
        this.rolleFornavn = rolleFornavn;
    }

    public String getRolleEtternavn() {
        return rolleEtternavn;
    }

    public void setRolleEtternavn(String rolleEtternavn) {
        this.rolleEtternavn = rolleEtternavn;
    }

    @Override
    public String toString() {
        return  " skuespiller: " + skuespiller + " med rolle fornavn: " + rolleFornavn +
                " og rolle etternavn: " + rolleEtternavn;
    }

}

