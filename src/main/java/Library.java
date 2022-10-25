import java.util.List;

public class Library {
    public String name;
    public String address;
    public String email;
    public String phone;
    public List<Book> books;

    public Library(String name, String address, String email, String phone, List<Book> books) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Book> getBooks() {
        return books;
    }



    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", books=" + books +
                '}';
    }
}
