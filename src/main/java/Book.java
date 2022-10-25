public class Book {
    public String name;
    public int cnt;

    public Book(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }

    public void setName(String book_name) {
        this.name = book_name;
    }

    public void setCnt(int book_cnt) {
        this.cnt = book_cnt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", cnt=" + cnt +
                '}';
    }
}
