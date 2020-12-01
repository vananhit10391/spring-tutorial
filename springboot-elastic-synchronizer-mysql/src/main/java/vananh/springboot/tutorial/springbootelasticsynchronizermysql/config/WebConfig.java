package vananh.springboot.tutorial.springbootelasticsynchronizermysql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.mapper.UserMapper;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.User;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.UserES;

@Configuration
public class WebConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapper() {
            @Override
            public UserES toUserES(User user) {
                UserES userES = new UserES();
                userES.setId(user.getId().toString());
                userES.setFirstName(user.getFirstName());
                userES.setLastName(user.getLastName());
                userES.setModificationDate(user.getModificationDate());
                userES.setStatus(user.getStatus());
                return userES;
            }
        };
    }
}
