package jp.co.fostone.springwebsys.jpa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {
	@Id
    private String id;

	@NotEmpty
	@Size(max = 40)
	private String name;

	@NotNull
	@Min(value = 18)
	@Max(value = 60)
	private Integer age;

	@NotEmpty
	@Size(max = 100)
	private String team;

	@NotEmpty
	@Size(max = 20)
	private String position;

}
