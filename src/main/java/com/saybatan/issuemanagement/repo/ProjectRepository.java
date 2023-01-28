package com.saybatan.issuemanagement.repo;

import com.saybatan.issuemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {

}
