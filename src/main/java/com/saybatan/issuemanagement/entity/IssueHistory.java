package com.saybatan.issuemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "issue_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "issue_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Issue issue;
    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User assignee;

}
