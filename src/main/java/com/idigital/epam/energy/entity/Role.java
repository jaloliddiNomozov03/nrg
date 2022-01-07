package com.idigital.epam.energy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    public String name;

    public Role(String name){
        this.name=name;
    }
    Role(String name,Long id){
        this.name=name;
        this.id=id;
    }

}

