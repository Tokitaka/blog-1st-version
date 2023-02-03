package shop.mtcoding.blog.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardRepository {

    public int insert(@Param("title") String title, @Param("content") String content, @Param("userId") int userId);

}
