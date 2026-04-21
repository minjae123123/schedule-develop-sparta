package com.scheduledevelop.service;

import com.scheduledevelop.dtos.*;
import com.scheduledevelop.entity.User;
import com.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public CreateUserResponse create(CreateUserRequest request) {
        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        User savedUser = userRepository.save(user);

        return new CreateUserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public GetUserResponse findOne(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );

        return new GetUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetUserResponse> findAll() {
        List<User> users = userRepository.findAll();

        List<GetUserResponse> dtos = new ArrayList<>();

        for (User user : users) {
            dtos.add(new GetUserResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
                    )
            );
        }
        return dtos;
    }

    @Transactional
    public UpdateUserResponse update(UpdateUserRequest request, Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );

        user.updateUser(
                request.getName(),
                request.getEmail()
        );

        return new UpdateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long id) {
        boolean existence = userRepository.existsById(id);

        if(!existence) {
            throw new IllegalAccessError("없는 멤버입니다.");
        }

        userRepository.deleteById(id);
    }
}
