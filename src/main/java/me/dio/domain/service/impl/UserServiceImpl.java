package me.dio.domain.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.domain.models.User;
import me.dio.domain.repository.UserRepository;
import me.dio.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUserById(UUID id) {
        return this.userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User createUser(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exists");
        }

        return this.userRepository.save(userToCreate);
    }
}
