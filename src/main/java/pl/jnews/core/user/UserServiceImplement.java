package pl.jnews.core.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jnews.core.role.Role;
import pl.jnews.core.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto userDto) {

        User user = new User();

        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEnabled(1);
        if(roleRepository.findByName("ROLE_USER") == null){
            createRole();
        }
        Role userRole = roleRepository.findByName("USER_ROLE");
        user.setRoles(new HashSet<Role>(List.of(userRole)));
        userRepository.save(user);
        log.info("User with email {} created",user.getEmail());
    }

    public void createRole(){

        Role role = new Role();
        role.setName("ROLE_USER");
        log.info("Role USER created");
        roleRepository.save(role);
    }
}
