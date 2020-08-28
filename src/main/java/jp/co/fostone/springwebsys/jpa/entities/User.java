package jp.co.fostone.springwebsys.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String id;

	@Column(nullable = false)
	@NotEmpty()
	private String name;

	@Column(nullable = false, unique = true)
	@NotEmpty
	private String email;

	@Column(nullable = false)
	@NotEmpty
	@Size(min = 1)
	private String password;

}