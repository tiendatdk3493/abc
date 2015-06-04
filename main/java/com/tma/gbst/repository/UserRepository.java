package com.tma.gbst.repository;

import com.tma.gbst.model.Role;
import com.tma.gbst.model.User;

import java.util.List;

public interface UserRepository extends MyBaseRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findByRole(Role role);
}
