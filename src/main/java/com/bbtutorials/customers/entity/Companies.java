package com.bbtutorials.customers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
public class Companies {
	
	@Id
	@Column
    private long id;

    @Column
    @NotNull(message="{NotNull.User.name}")
    private String name;
    
    @Column
    @NotNull(message="{NotNull.User.phoneNumber}")
    private String phoneNumber;
    
}