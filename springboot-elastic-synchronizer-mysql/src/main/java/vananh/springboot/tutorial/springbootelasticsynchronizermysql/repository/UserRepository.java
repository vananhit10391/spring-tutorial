package vananh.springboot.tutorial.springbootelasticsynchronizermysql.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
    List<User> findAll();

    Optional<User> findById(Long id);

    @Modifying
    @Query("update User u set u.status = :status, u.modificationDate = :modificationDate where u.id = :id")
    int updateUserSetStatusForId(@Param("id") Long id,
                                 @Param("status") Boolean status,
                                 @Param("modificationDate") Date modificationDate);
}
