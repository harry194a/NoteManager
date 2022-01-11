package com.hb.platform.notemanager.service.user;

import com.hb.platform.notemanager.domain.address.Address;
import com.hb.platform.notemanager.domain.user.CreateUserModel;
import com.hb.platform.notemanager.domain.user.UserModel;
import com.hb.platform.notemanager.domain.user.UpdateUserModel;
import com.hb.platform.notemanager.repository.AddressRepository;
import com.hb.platform.notemanager.domain.user.User;
import com.hb.platform.notemanager.repository.UserRepository;
import com.hb.platform.notemanager.service.common.ModelValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final ModelValidator modelValidator;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, ModelValidator modelValidator) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.modelValidator = modelValidator;
    }

    public List<UserModel> getUser() {
        logger.info("Retrieve all notes");
        List<User> userModels = userRepository.findAll();
        List<UserModel> returnUserModel = new ArrayList<>();
        for (User user : userModels) {
            returnUserModel.add(new UserModel(user.getFistName(), user.getLastName(), user.getPhoneNumber(),
                    user.getRole(), user.getAddress()));
        }
        logger.info("Successfully retrieved notes result - {}", returnUserModel);
        return returnUserModel;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


    @Transactional
    public UserModel addNewUser(CreateUserModel model) {
        logger.info("Retrieve all notes");
        modelValidator.validate(model);
        Address address = addressRepository.save(model.getAddress().toEntity());
        User user = userRepository.save(model.toUser(address));
        UserModel returnUserModel = new UserModel(user.getFistName(), user.getLastName(), user.getPhoneNumber(),
                user.getRole(), user.getAddress());
        logger.info("Successfully retrieved notes result - {}", returnUserModel);
        return returnUserModel;
    }


    @Transactional
    public UserModel update(Long id, UpdateUserModel updateUserModel) {
        modelValidator.validate(updateUserModel);
        logger.info("Retrieve all notes");
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("we dont have it"));
        Address address = updateUserModel.getAddress().toEntity();
        address.setId(user.getAddress().getId());
        address = addressRepository.save(address);
        userRepository.save(updateUserModel.toUserUpdate(user, address, id));
        UserModel returnUserModel = new UserModel(user.getFistName(), user.getLastName(), user.getPhoneNumber(),
                user.getRole(), user.getAddress());
        logger.info("Successfully retrieved notes result - {}", returnUserModel);
        return returnUserModel;
    }

    @Transactional(readOnly = true)
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find user"));
    }
}