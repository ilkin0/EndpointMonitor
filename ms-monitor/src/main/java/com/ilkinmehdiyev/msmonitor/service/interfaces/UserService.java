package com.ilkinmehdiyev.msmonitor.service.interfaces;

import com.ilkinmehdiyev.msmonitor.model.user.User;

import java.util.UUID;

public interface UserService {
    User getByAccessToken(UUID accessToken);
}
