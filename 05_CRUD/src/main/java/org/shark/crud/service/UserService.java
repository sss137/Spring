package org.shark.crud.service;

import org.shark.crud.model.dto.UserDTO;

public interface UserService {

  UserDTO login(UserDTO user);
  UserDTO findUserByNickname(String nickname);
  UserDTO findUserByEmail(String email);
  boolean signup(UserDTO user);
  
}
