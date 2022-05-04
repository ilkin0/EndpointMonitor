package com.ilkinmehdiyev.msmonitor.service.impl;

import com.ilkinmehdiyev.msmonitor.model.user.User;
import com.ilkinmehdiyev.msmonitor.repo.UserRepo;
import com.ilkinmehdiyev.msmonitor.service.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public record UserServiceImpl(UserRepo userRepo) implements UserService {

    @Override
    public User getByAccessToken(UUID accessToken) {
        return userRepo.findByAccessToken(accessToken)
                .orElseThrow(
                        () -> {
                            log.error("Cannot find User with {} access token", accessToken);
                            throw new IllegalArgumentException("Cannot find User with " + accessToken + " access token");
                        }
                );
    }
}
