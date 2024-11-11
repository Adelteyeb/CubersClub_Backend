package com.CentreCulturel.demo.user;

import java.util.List;

public interface UserService {
UserResponse loadUserByEmailAndPassword(String email,String password);
UserResponse findById(Integer id);
UserResponse findUserByMessagesId(Integer id);
void deleteUser(Integer id);


}
