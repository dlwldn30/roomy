package com.example.demo.user.repository;

import com.example.demo.user.domain.Gender;
import com.example.demo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
        select u
        from User u
        where u.id <> :userId
          and u.gender = :gender
    """)
    List<User> findCandidatesByGender(
            @Param("userId") Long userId,
            @Param("gender") Gender gender
    );
}