package dao;

public interface IUserDao {
    Integer queryUserAge(String uid);
    String queryUserName(String uid);
    String queryUserName();
}
