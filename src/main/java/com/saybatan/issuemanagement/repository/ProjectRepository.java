package com.saybatan.issuemanagement.repository;

import com.saybatan.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project getByProjectCode(String code);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);

    Project getByProjectCodeAndIdNot(String code, Long id);

}
