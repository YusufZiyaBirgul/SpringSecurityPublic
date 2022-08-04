package yte.spring_security.spring_security.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;

    public Authority(String authority) {
        this.authority = authority;
    }

    @ManyToMany(mappedBy = "authorities")
    private List<Users> usersEntity;

    private String authority;

}
