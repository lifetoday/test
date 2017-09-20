package com.ait.interview.services;

import java.util.List;

import com.ait.interview.domain.Location;

public interface LocationService {
	public Location getById(Long id);

	public List<Location> getAll();

	public List<Location> getAllLocationByArea(int area);

	public List<Location> getListArea();

	public List<Location> getListAllIgnoreRootArea();
}
