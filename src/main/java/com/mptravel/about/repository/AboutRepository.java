package com.mptravel.about.repository;

import com.mptravel.about.entity.About;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AboutRepository extends CrudRepository<About, Long> {

    @Query("SELECT a FROM About AS a")
    List<About> findAbout();

    About findAboutById(@Param("id") long id);
}
