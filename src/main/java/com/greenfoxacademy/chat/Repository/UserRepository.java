package com.greenfoxacademy.chat.Repository;

import com.greenfoxacademy.chat.Models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
