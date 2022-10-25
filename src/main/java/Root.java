import java.util.List;

public class Root {
    public List<Library> library;

    public void setLibrary(List<Library> library) {
        this.library = library;
    }

    public List<Library> getLibrary() {
        return library;
    }

    @Override
    public String toString() {
        return "Root{" +
                "library=" + library +
                '}';
    }
}
