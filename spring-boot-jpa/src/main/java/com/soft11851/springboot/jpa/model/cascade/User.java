package com.soft11851.springboot.jpa.model.cascade;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author ke
 * @ClassName User
 * @Description TOOD
 * @Date 2020/5/12
 * @Version 1.0
 **/
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(length = 100)
    private String password;
    @ManyToMany
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorityList;
}
