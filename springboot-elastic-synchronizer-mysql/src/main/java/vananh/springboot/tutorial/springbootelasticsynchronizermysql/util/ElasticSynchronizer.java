package vananh.springboot.tutorial.springbootelasticsynchronizermysql.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.mapper.UserMapper;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.User;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.repository.UserRepository;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.repository.UserESRepository;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ElasticSynchronizer {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserESRepository userESRepository;

    @Autowired
    UserMapper userMapper;

    @PostConstruct
    public void initSync() {
        log.info("Start Init Syncing - {}", LocalDateTime.now());
        this.syncUsers();
        log.info("End Init Syncing - {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 */3 * * * *")
    @Transactional
    public void sync() {
        log.info("Start Syncing - {}", LocalDateTime.now());
        this.syncUsers();
        log.info("End Syncing - {}", LocalDateTime.now());
    }

    private void syncUsers() {
        Specification<User> userSpecification = (root, criteriaQuery, criteriaBuilder) -> getModificationDatePredicate(criteriaBuilder, root);
        List<User> userList;
        if (userESRepository.count() == 0) {
            userList = userRepository.findAll();
        } else {
            userList = userRepository.findAll(userSpecification);
        }

        for(User user: userList) {
            log.info("Syncing User - {}", user.getId());
            userESRepository.save(this.userMapper.toUserES(user));
        }
    }

    private static Predicate getModificationDatePredicate(CriteriaBuilder criteriaBuilder, Root<?> root) {
        Expression<Timestamp> currentTime;
        currentTime = criteriaBuilder.currentTimestamp();
        Expression<Timestamp> currentTimeMinus = criteriaBuilder.literal(new Timestamp(System.currentTimeMillis() - (Constants.INTERVAL_IN_MILLISECONDE)));

         return criteriaBuilder.between(root.<Date>get(Constants.MODIFICATION_DATE),
                currentTimeMinus,
                currentTime
        );
    }
}
