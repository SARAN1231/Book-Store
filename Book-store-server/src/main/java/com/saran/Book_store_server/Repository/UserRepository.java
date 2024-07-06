package com.saran.Book_store_server.Repository;

import com.saran.Book_store_server.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findUserByEmail(String email);
}
