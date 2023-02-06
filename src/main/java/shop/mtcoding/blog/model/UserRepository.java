package shop.mtcoding.blog.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    public int insert(@Param("username") String username, @Param("password") String password,
            @Param("email") String email);

    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    public User findByUsername(@Param("username") String username);

}
