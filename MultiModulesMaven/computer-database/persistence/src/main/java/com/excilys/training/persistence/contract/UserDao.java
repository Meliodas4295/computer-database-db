package com.excilys.training.persistence.contract;

import com.excilys.training.core.User;

public interface UserDao {

	User findByUserName(String username);
}
