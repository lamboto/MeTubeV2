package metube.domain.entities;

public class Tube {

    private int id;
    private String title;
    private String author;
    private String description;
    private String youtubeId;
    private long views;
    private int userId;

    public Tube() {
    }

    public Tube(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Tube(String title, String author, String description, String youtubeId, long views, int userId) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.youtubeId = youtubeId;
        this.views = views;
        this.userId = userId;
    }

    public Tube(String title, String author, String description, String youtubeId, long views) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.youtubeId = youtubeId;
        this.views = views;
    }

    public Tube(String title, String author, String description, String youtubeId, int userId) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.youtubeId = youtubeId;
        this.userId = userId;
    }

    public Tube(int id, String title, String author, String description, String youtubeId, long views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.youtubeId = youtubeId;
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
