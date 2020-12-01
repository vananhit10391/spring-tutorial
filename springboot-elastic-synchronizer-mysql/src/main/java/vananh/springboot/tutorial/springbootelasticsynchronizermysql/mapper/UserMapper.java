package vananh.springboot.tutorial.springbootelasticsynchronizermysql.mapper;

import org.mapstruct.Mapper;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.User;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.UserES;

@Mapper()
public interface UserMapper {
    UserES toUserES(User user);
}
