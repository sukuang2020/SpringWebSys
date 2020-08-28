package jp.co.fostone.springwebsys.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {
	@Id
	@Column(nullable = false, unique = false)
	private String userId;

	@Column(nullable = false, unique = false)
	@NotEmpty
	private String roleId;
}
