package jp.co.fostone.springwebsys.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
	@Id
	private String id;

	@Column(nullable = false, unique = true)
	@NotEmpty
	private String name;
}
