package gov.ny.its.mentor_demo.entity.dot;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class InventoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private Float latitude;

	private Float longitude;

	private Long dept_id;
}
