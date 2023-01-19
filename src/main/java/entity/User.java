package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Users")

public class User {
	private static final long serialersionUID=1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(nullable=false)
	private String name;
    
    @Column(nullable=false,unique=true)
	private String email;
    
    @Column(nullable=false)
    private String pasword;

    public void setRole(List<User> asList) {
    }

    // @ManyToMany(fetch =FetchType.EAGER,cascade =CascadeType.ALL)
    
	//@JoinTable(name = "users_roles" ,
	//joinColumn= {@JoinColumn(name="USER_ID",referencecolumnName="ID")},
	//inverseJoinColumns= {@Joincolumn(name="ROLE_ID",referencecolumnName="ID")})
    
   // private List<Role> roles =new ArrayList<>();
}
