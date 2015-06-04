package com.tma.gbst.repository;

import com.tma.gbst.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Huy Nghi on 4/30/2015.
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    List<UserProfile> findByJoinDateStartingWith(String findByMonthAndYear);
}
