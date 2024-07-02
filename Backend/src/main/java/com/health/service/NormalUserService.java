package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dto.NormalUserDto;
import com.health.dto.Role;
import com.health.entity.NormalUser;
import com.health.entity.User;
import com.health.entity.UserQuery;
import com.health.helper.UserNotFoundException;
import com.health.repository.NormalUserRepository;
import com.health.repository.UserQueryRepository;
import com.health.repository.UserRepository;

@Service
public class NormalUserService {
    
    @Autowired
    private NormalUserRepository normalUserRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserQueryRepository userQueryRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EmailSenderService emailService;

    public NormalUser saveNormalUser(NormalUser normalUser) {
        try {
            // Set role for the user associated with normal user
            normalUser.getUser().setRole(Role.NORMAL);

            // Save the user details and get the saved entity
            User savedUser = userService.saveUser(normalUser.getUser());

            // Set the saved user to the normal user entity
            normalUser.setUser(savedUser);

            // Send registration email
            sendRegistrationEmail(savedUser);

            // Save the normal user entity and return the saved instance
            return normalUserRepository.save(normalUser);
        } catch (Exception e) {
            System.err.println("Error saving normal user: " + e.getMessage());
            e.printStackTrace();            
            throw new RuntimeException("Failed to save normal user", e);
        }
    }

    
    private void sendRegistrationEmail(User user) {
        String registrationEmailBody = buildRegistrationEmailBody(user);
        emailService.sendEmail(user.getEmail(), "Registration Successful", registrationEmailBody);
    }
    
    private String buildRegistrationEmailBody(User user) {
        return "Dear " + user.getFirstName() + " " + user.getLastName() + ",\n\n" +
                "We are excited to welcome you to our healthcare system!\n\n" +
                "Your registration has been successfully completed. You can now access our services and manage your appointments with ease.\n\n" +
                "Here are your registration details:\n" +
                "Username: " + user.getUsername() + "\n" +
                "Email: " + user.getEmail() + "\n\n" +
                "If you have any questions or need assistance, please do not hesitate to contact our support team.\n\n" +
                "Thank you for joining us.\n\n" +
                "Best regards,\n" +
                "Health Care";
    }
    
    public NormalUser getUser(String email) {
        try {
            User user = userService.findUserByUsername(email);
            return normalUserRepository.findById(user.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("NormalUser not found for : " + email));
        } catch (Exception e) {
            e.printStackTrace(); 
            return null; 
        }
    }

    public NormalUser updateUser(String email, NormalUserDto dto) throws UserNotFoundException {
    	
        User user = userService.findUserByUsername(email);
        if (user == null) {
            throw new UserNotFoundException("User not found with username: " + email);
        }
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setRole(Role.NORMAL);
        
        NormalUser normalUser =   normalUserRepository.findById(user.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("NormalUser not found for : " + email));;
                
        normalUser.setUser(user);
        normalUser.setAddress(dto.getAddress());
        normalUser.setDateOfBirth(dto.getDateOfBirth());
        normalUser.setGender(dto.getGender());
        
        // Update the user details
        userRepository.save(user);
        
        // Save the normal user details
        normalUserRepository.save(normalUser);
        
        return normalUser;
    }
    
    public UserQuery addQuery(UserQuery userQuery) {
        // Save user query
        return userQueryRepository.save(userQuery);
    }
}
