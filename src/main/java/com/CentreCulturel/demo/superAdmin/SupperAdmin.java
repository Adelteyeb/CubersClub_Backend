package com.CentreCulturel.demo.superAdmin;
import com.CentreCulturel.demo.user.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@DiscriminatorValue("SUPER")
public class SupperAdmin extends User {

}
