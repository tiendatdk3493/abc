package com.tma.gbst.service;

import com.tma.gbst.model.UserProfile;
import com.tma.gbst.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Huy Nghi on 4/30/2015.
 */
@Service
public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    public UserProfile save (UserProfile userProfile) {
        return userProfileRepository.saveAndFlush(userProfile);
    }

    public UserProfile findByID(int id) {
        return userProfileRepository.findOne(id);
    }

    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    public void delete(int id ) {
        userProfileRepository.delete(userProfileRepository.findOne(id));
    }

    public List<UserProfile> findByJoinDateStartingWith(String findByMonthAndYear) {
        return userProfileRepository.findByJoinDateStartingWith(findByMonthAndYear);
    }
}
