package org.odds.learn.mentor_demo.entity.dot;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "dept_name", unique = true)
	private String deptName;

	@Column(name = "dept_code", unique = true)
	private String deptCode;
}
