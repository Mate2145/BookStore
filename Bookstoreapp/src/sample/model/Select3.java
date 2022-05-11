package sample.model;

public class Select3 {

    private String name;
    private String genreName;
    private int count;

    public Select3(String name, String genreName, int count) {
        this.name = name;
        this.genreName = genreName;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
