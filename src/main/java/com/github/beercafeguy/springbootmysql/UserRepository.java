package com.github.beercafeguy.springbootmysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    /*@Query("select u from users u where u.name like '%:name%'")
    Stream<User> findByNameReturnStream(@Param("name") String email);*/
}
