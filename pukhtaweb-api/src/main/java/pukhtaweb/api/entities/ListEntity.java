package pukhtaweb.api.entities;

public class ListEntity {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Boolean accept;

    public ListEntity() {
    }

    public ListEntity(Integer id, Integer userId, Integer bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    public Boolean getAccept() {
        return accept;
    }

    @Override
    public String toString() {
        return "ListdEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                '}';
    }


}