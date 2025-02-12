package me.dio.domain.service;

import me.dio.domain.models.User;

import java.util.UUID;

public interface UserService {

    User findUserById(UUID id);

    User createUser(User userToCreate);

}
