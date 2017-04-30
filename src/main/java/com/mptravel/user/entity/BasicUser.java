package com.mptravel.user.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("basic_user")
public class BasicUser extends User {
}
