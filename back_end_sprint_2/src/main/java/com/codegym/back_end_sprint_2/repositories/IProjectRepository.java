package com.codegym.back_end_sprint_2.repositories;
import com.codegym.back_end_sprint_2.model.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
public interface IProjectRepository extends JpaRepository<Project,Long> {
    @Query(value = "SELECT * FROM project WHERE (status = 1 ) and enable = true ", nativeQuery = true)
    List<Project> findAll();
    @Query(value = "SELECT * from project where id = ?1 ", nativeQuery = true)
    Optional<Project> findById(Long id);
    @Transactional
    @Modifying
    @Query(value = " UPDATE project SET enable = ?1 WHERE id = ?2 ", nativeQuery = true)
    void delete(Boolean enable, Long id);
    @Query(value = " SELECT * FROM project WHERE status = 0 and enable = 1 ", nativeQuery = true)
    Page<Project> findAllApprove(Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = " UPDATE project SET status = ?1 WHERE id = ?2 ", nativeQuery = true)
    void approveProject(Boolean status, Long id);
    @Transactional
    @Modifying
    @Query(value = " UPDATE project SET enable = ?1 WHERE id = ?2 ", nativeQuery = true)
    void notApproveProject(Boolean status, Long id);
    Project findByTeam_Id(Long id);
    @Query(value = " SELECT * FROM project WHERE status = 0 and enable = 1 ", nativeQuery = true)
    List<Project> findAllApprove();
    @Query(value= "select * from project inner join team on team.id = project.team_id " +
            "where project.status = 1 and project.enable = 1 and team.name like %?1% " +
            "or project.status = 1 and project.enable = 1 and project.name like %?1% ", nativeQuery = true)
    List<Project> searchProject(String keyword);
    @Query(value = "select student.email from team\n" +
            "right join student on team.id= student.team_id\n" +
            "where team.id = ?1;",nativeQuery = true)
    String[] getStudentMail(Long id);
}