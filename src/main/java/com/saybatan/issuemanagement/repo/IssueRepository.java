package com.saybatan.issuemanagement.repo;

import com.saybatan.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {


}
