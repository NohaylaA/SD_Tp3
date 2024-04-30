package org.example.anoada_nohayla_tp3_1.security.repo;

import org.example.anoada_nohayla_tp3_1.security.entities.AppRole;
import org.example.anoada_nohayla_tp3_1.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String>
{
    AppUser findByUsername(String username);
}
