package metube.query;

public class Query {

    //INSERT
    public static final String INSERT_TUBE = "INSERT INTO tubes (author, description, youtube_id, views,user_id) VALUES (?, ?, ?, ?, ?)";
    public static final String INSERT_USER = "INSERT INTO users (username, password,email) VALUES (?, ?, ?)";


    //SELECT
    public static final String SELECT_ALL_TUBES = "select * from tubes";
    public static final String SELECT_TUBE_BY_ID = "select * from tubes where id=?";

    public static final String SELECT_ALL_USERS= "select * from users";
    public static final String SELECT_USER_BY_ID = "select * from users where id=?";

    //COUNT
    public static final String SELECT_COUNT_OF_ALL_TUBES = "select count(*) from tubes";
    public static final String SELECT_COUNT_OF_ALL_USERS = "select count(*) from users";

}