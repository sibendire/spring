package entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Roles")

public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
	@Column(nullable=false,unique=true)
private String name;
	//@ManyToMany(MappedBy="roles")
	//private List<User> users
}
