package com.hb.platform.notemanager.services;

import com.hb.platform.notemanager.address.Address;
import com.hb.platform.notemanager.model.CreateUserModel;
import com.hb.platform.notemanager.model.UpdateUserModel;
import com.hb.platform.notemanager.repository.AddressRepository;
import com.hb.platform.notemanager.user.User;
import com.hb.platform.notemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final ModelValidator modelValidator;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, ModelValidator modelValidator) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.modelValidator = modelValidator;
    }


    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    //TODO Create CreateUserModel class for create user method.
    //TODO Make this method @Transactional
    @Transactional
    public User addNewUser(CreateUserModel model) {
        modelValidator.validate(model);
        Address address = addressRepository.save(model.getAddress().toEntity());
        User user = userRepository.save(model.toUser(address));
        return user;
    }

    //TODO Create UpdateUserModel class for update method.
    //TODO Create also updateAddress model class to update address
    //TODO make service methods as public
    @Transactional
    public User update(Long id, UpdateUserModel updateUserModel) {
        modelValidator.validate(updateUserModel);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("we dont have it"));
       Address address = updateUserModel.getAddress().toEntity();
       address.setId(user.getAddress().getId());
       address = addressRepository.save(address);
       userRepository.save(updateUserModel.toUserUpdate(user, address, id));
        return user;
    }

    @Transactional(readOnly = true)
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find user"));
    }
}