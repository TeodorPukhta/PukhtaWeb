package pukhtaweb.api.entities;

public class CommentEntity {
    private Integer id;
    private String user;
    private String comment;
    private String accept;

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", comment='" + comment + '\'' +
                ", accept='" + accept + '\'' +
                '}';
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
