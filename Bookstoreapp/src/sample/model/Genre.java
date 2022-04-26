package sample.model;

public class Genre {
    private String subgenre;
    private String genrename;

    public Genre(String subgenre, String genrename) {
        this.subgenre = subgenre;
        this.genrename = genrename;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public String getGenrename() {
        return genrename;
    }

    public void setGenrename(String genrename) {
        this.genrename = genrename;
    }

    @Override
    public String toString() {
        return subgenre + " - " + genrename;
    }
}
