package com.apiclasswork.API.ClassWork.service.serviceimpl;

import com.apiclasswork.API.ClassWork.dto.LoginRequest;
import com.apiclasswork.API.ClassWork.dto.SignUpRequest;
import com.apiclasswork.API.ClassWork.entity.User;
import com.apiclasswork.API.ClassWork.repository.UserRepository;
import com.apiclasswork.API.ClassWork.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
   private ModelMapper modelMapper;

    public String registerUser(SignUpRequest signUpRequest){
if(userRepository.existsByUsername(signUpRequest.getUsername())){
    throw new RuntimeException("User Already Exist");
        }
User user = User.builder()
        .email(signUpRequest.getEmail())
        .fullName(signUpRequest.getFullName())
        .username(signUpRequest.getUsername())
        .password(signUpRequest.getPassword())
        .build();
    userRepository.save(user);
    return "User Register Successfully";
    }

    public LoginRequest login(LoginRequest loginRequest){
        User user = userRepository.findByUsernameAndPassword(
                loginRequest.getUsername(),loginRequest.getPassword());
        if(user == null){
            throw new EntityNotFoundException("Account Not Found!");
        }
        return mapToLoginRequest(user);
    }

    private LoginRequest mapToLoginRequest(User user) {
        return modelMapper.map(user,LoginRequest.class);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
