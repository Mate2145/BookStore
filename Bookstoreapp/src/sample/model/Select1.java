package sample.model;

public class Select1
{
    String genreName;
    int counter;

    public Select1(String genreName, int counter) {
        this.genreName = genreName;
        this.counter = counter;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
