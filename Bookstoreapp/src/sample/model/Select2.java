package sample.model;

public class Select2
{
    private String productname;
    private String when;
    private String genreName;

    public Select2(String productname, String when, String genreName) {
        this.productname = productname;
        this.when = when;
        this.genreName = genreName;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
