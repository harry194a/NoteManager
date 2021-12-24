package com.hb.platform.notemanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> getUser() {
        return userRepository.findAll();
    }

    void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void addNewUser(User user) {
        userRepository.save(user);

    }


    @Transactional
    User update(Long id, String fistName, String lastName, String email,
                int number, Role role, AdminAddress adminAddress) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("c"));
        user.setFistName(fistName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setNumber(number);
        user.setRole(role);
        user.setAdminAddress(adminAddress);

        userRepository.save(user);
        return user;
    }
}
