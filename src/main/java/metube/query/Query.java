package metube.query;

public class Query {

    //INSERT
    public static final String INSERT_TUBE = "INSERT INTO tubes (title,author, description, youtube_id, views,user_id) VALUES (?,?, ?, ?, ?, ?)";
    public static final String INSERT_USER = "INSERT INTO users (username, password,email) VALUES (?, ?, ?)";


    //SELECT
    public static final String SELECT_ALL_TUBES = "select * from tubes";
    public static final String SELECT_TUBE_BY_ID = "select * from tubes where id=?";

    public static final String SELECT_USER_BY_USERNAME = "select * from users where username=?";
    public static final String SELECT_ALL_USERS = "select * from users";
    public static final String SELECT_USER_BY_ID = "select * from users where id=?";
    public static final String SELECT_ALL_TUBES_BY_USER_USERNAME = "select e.title,e.author,e.id from tubes as e\n" +
            "join users as u \n" +
            "on e.user_id =u.id\n" +
            " where u.username=?";

    //COUNT
    public static final String SELECT_COUNT_OF_ALL_TUBES = "select count(*) from tubes";
    public static final String SELECT_COUNT_OF_ALL_USERS = "select count(*) from users";

}
