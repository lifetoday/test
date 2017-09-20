package com.ait.interview.services;

import com.ait.interview.domain.User;
import com.ait.interview.domain.UserLocation;
import java.util.List;

public interface UserService {
	public List<User> getUsersByLocation(Long locationId);

	public List<UserLocation> getUsersInLocation(Long locationId);

	public User getById(Long id);
}
