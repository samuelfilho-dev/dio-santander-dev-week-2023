package me.dio.domain.service.impl;


import jakarta.transaction.Transactional;
import me.dio.domain.models.User;
import me.dio.domain.repository.UserRepository;
import me.dio.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(UUID id) {
        return this.userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public User createUser(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exists");
        }

        return this.userRepository.save(userToCreate);
    }
}
