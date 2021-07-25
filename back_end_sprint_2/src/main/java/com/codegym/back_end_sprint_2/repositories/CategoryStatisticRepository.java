package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Category;
import com.codegym.back_end_sprint_2.model.entities.ICategoryStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryStatisticRepository extends JpaRepository<Category, Long> {

    @Query(value="select c.`name` as category_name, count(p.category_id) as number_of_registers\n" +
            "from project p\n" +
            "inner join category c on (p.category_id = c.id)\n" +
            "group by p.category_id\n" +
            "order by p.category_id;",
            nativeQuery = true)
    List<ICategoryStatistic> getCategoryStatistic();

    @Query(value="select count(*) from project\n" +
            "where `enable`=1;",
            nativeQuery = true)
    int getNumberOfPassedProjects();

    @Query(value="select count(*) from project\n" +
            "where `enable`=0;",
            nativeQuery = true)
    int getNumberOfPendingProjects();

}
