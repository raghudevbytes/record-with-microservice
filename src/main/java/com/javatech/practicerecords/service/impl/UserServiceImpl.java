package com.javatech.practicerecords.service.impl;

import com.javatech.practicerecords.UserRepository;
import com.javatech.practicerecords.model.User;
import com.javatech.practicerecords.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    public static final String BASEURI = "http://localhost:8081/api/v1";

    @Override
    public List<User> getAllUsers() {
        RestClient restClient = RestClient.create();
       return restClient.get()
                .uri(BASEURI+"/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus( HttpStatusCode::is4xxClientError,((request, response) -> {
                    logger.info(response.getStatusText());
                }))
                .body(new ParameterizedTypeReference<List<User>>() {});
       // return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(String.valueOf(id));
    }

    @Override
    public User addUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        boolean existingUser = userRepository.existsById(user.id());
        if (existingUser) {
            userRepository.save(user);
        }else{
            throw new RuntimeException("user not found");
        }

    }
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(String.valueOf(id));
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
}
