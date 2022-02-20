package com.example.Khatera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository mUserRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    public List<UserClass> getUsers() {
        return mUserRepository.findAll();
    }

    public void addUser(UserClass user) {
        Optional<UserClass> userByUsername =
                mUserRepository.findUserByUsername(user.getUsername());
        if(userByUsername.isPresent()) {
            throw new IllegalStateException(user.getUsername()
                    + ": this user name already exists");
        }
        mUserRepository.save(user);
    }

    @Transactional
    public void updateUser(Long userId,
                           String name,
                           String password,
                           String username) {

        UserClass  user = mUserRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        username + ": this user name does not exist"
                ));

        if(name != null
        && name.length() > 0
        && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        if(password != null
        && password.length() > 0
        && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }

        if(username != null
        && username.length() > 0
        && !Objects.equals(user.getUsername(), username)) {
            user.setUsername(username);
        }
    }

    public void deleteUser(Long userId) {
        boolean userExists = mUserRepository.existsById(userId);

        UserClass user = mUserRepository.findById(userId).get();

        if(!userExists) {
            throw new IllegalStateException(
                    user.getUsername() + ": this user name does not exist");
        }

        mUserRepository.deleteById(userId);
    }
}
