package pukhtaweb.api.models;

public class ListDataResponse {
    private Integer id;
    private String user;
    private String book;
    private String accept;

    public ListDataResponse(Integer id, String user, String book,String accept) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.accept = accept;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
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