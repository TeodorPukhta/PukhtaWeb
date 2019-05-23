package pukhtaweb.api.models;

public class ListDataResponse {
    private Integer id;
    private String user;
    private String book;

    public ListDataResponse(Integer id, String user, String book) {
        this.id = id;
        this.user = user;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

}