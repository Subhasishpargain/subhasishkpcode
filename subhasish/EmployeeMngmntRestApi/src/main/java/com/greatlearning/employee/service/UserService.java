package com.greatlearning.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.employee.dto.RoleDTO;
import com.greatlearning.employee.dto.UserDTO;
import com.greatlearning.employee.model.Role;
import com.greatlearning.employee.model.User;
import com.greatlearning.employee.repository.RoleRepository;
import com.greatlearning.employee.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Transactional
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElse(null);
	}

	@Transactional
	public User addUser(UserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setRoles(getRolesFromDTO(userDTO.getRoles()));
		return userRepository.save(user);
	}

	@Transactional
	public User updateUser(Long id, UserDTO userDTO) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setUsername(userDTO.getUsername());
			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			user.setRoles(getRolesFromDTO(userDTO.getRoles()));
			return userRepository.save(user);
		}
		return null;
	}

	@Transactional
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Transactional
	public List<User> getUsersByRoleId(Long roleId) {
		Role role = roleRepository.findById(roleId).orElse(null);
		if (role != null) {
			return userRepository.findAllByRolesContaining(role);
		}
		return null;
	}

	private List<Role> getRolesFromDTO(List<RoleDTO> roleDTOs) {
		return roleDTOs.stream().map(roleDTO -> roleRepository.findById(roleDTO.getId()).orElse(null))
				.filter(role -> role != null).collect(Collectors.toList());
	}
}
