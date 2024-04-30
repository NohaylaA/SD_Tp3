package org.example.anoada_nohayla_tp3_1.security.service;

import org.example.anoada_nohayla_tp3_1.security.entities.AppRole;
import org.example.anoada_nohayla_tp3_1.security.entities.AppUser;

public interface AccountService
{
    AppUser addNewUser(String username,String password,String email, String confirmPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);
    AppUser loadUserByUsername(String username);
}
