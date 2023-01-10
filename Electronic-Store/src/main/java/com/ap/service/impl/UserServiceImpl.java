package com.ap.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.dto.UserDto;
import com.ap.model.User;
import com.ap.repository.UserRepository;
import com.ap.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		String userid = UUID.randomUUID().toString();
		userDto.setUserId(userid);
		
		User user=dtoToEntity(userDto);
		userRepository.save(user);
		
		UserDto userDto1=EntityToDto(user);	
		log.info("user is created");
		return userDto1;
		
	}


	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		
		User user = userRepository.findById(userId).get();

		if (userDto.getName() != null) {
			user.setName(userDto.getName());
		}
		if (userDto.getEmail() != null) {
			user.setEmail(userDto.getEmail());
		}
		if (userDto.getPassword() != null) {
			user.setPassword(userDto.getPassword());
		}
		if (userDto.getGender() != null) {
			user.setGender(userDto.getGender());
		}
		
		userRepository.save(user);
		log.info("user is updated");
		
		UserDto dto = EntityToDto(user);
		
		return dto;
	}

	@Override
	public void deleteUser(String userId) {
		
		User user = userRepository.findById(userId).get();
		userRepository.delete(user);
		
		log.info("user Deleted"+user.getUserId());
		
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> userlist = userRepository.findAll();
		
		List<UserDto> c = userlist.stream().
				map(user->EntityToDto(user)).
				collect(Collectors.toList());
		
		return c;
	}

	@Override
	public UserDto getUser(String UserId) {
		
		User user = userRepository.findById(UserId).get();
		
		UserDto userDto = EntityToDto(user);
		
		return userDto;
	}

	@Override
	public UserDto getUserEmail(String email) {
		
		User findByEmail = userRepository.findByEmail(email);
		
		UserDto emailDto = EntityToDto(findByEmail);
		
		return emailDto;
	}
	
	
	
	
	private User dtoToEntity(UserDto userDto) {
		/*
		 * User user=User.builder() .userId(userDto.getUserId())
		 * .name(userDto.getName()) .email(userDto.getEmail())
		 * .password(userDto.getPassword()) .gender(userDto.getGender()). build();
		 */
		
		return	modelMapper.map(userDto, User.class);
		
		
	}
	
	
	private UserDto EntityToDto(User user) {
		/*
		 * UserDto userDto=UserDto.builder() .userId(user.getUserId())
		 * .name(user.getName()) .email(user.getEmail()) .password(user.getPassword())
		 * .gender(user.getGender()) .build();
		 */
		return modelMapper.map(user, UserDto.class);
	}

	

}
