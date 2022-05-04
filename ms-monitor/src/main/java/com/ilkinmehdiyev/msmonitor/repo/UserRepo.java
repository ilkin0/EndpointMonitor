package com.ilkinmehdiyev.msmonitor.repo;

import com.ilkinmehdiyev.msmonitor.model.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "monitoredEndpoints")
    Optional<User> findByAccessToken(UUID accessToken);
}
