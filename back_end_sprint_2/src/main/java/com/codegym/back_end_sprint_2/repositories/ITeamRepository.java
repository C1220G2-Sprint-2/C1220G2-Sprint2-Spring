package com.codegym.back_end_sprint_2.repositories;


import com.codegym.back_end_sprint_2.model.entities.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "select *from team",nativeQuery = true)
    Page<Team> findAllTeam(Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = "delete from team where id =?1",nativeQuery = true)
    void deleteTeamById(Long id);


    @Query(value = "select student.email from team right join student on team.id = student.group_id where team.id =?1",nativeQuery = true)
    String[] findStudentGroupById(Long id);
}
