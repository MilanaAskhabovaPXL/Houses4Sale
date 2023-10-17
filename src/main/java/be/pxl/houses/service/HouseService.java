package be.pxl.houses.service;

import be.pxl.houses.api.CreateHouseRequest;
import be.pxl.houses.api.UpdateHouseRequest;
import be.pxl.houses.domain.House;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseService {
	private final Map<String, House> houseMap = new HashMap<>();

	public void addHouse(CreateHouseRequest house) {
		// TODO: Throw your own DuplicateHouseException (unchecked exception) when there is already a house with the given code.
		House newHouse = new House(house.getCode(), house.getDescription(), house.getArea(), house.getEpcScore());
		houseMap.put(house.getCode(), newHouse);
	}

	public void updateHouse(String code, UpdateHouseRequest house) {
		// TODO: Throw an own HouseNotFoundException (custom unchecked exception) when there is no house with the given code
		House houseByCode = getHouseByCode(code);
		if (houseByCode != null) {
			houseByCode.setCity(house.getCity());
			houseByCode.setDescription(house.getDescription());
			houseByCode.setArea(house.getArea());
		}
	}

	public List<House> getHouses() {
		return new ArrayList<>(houseMap.values());
	}

	public void deleteHouse(String code) {
		// TODO: Throw an own HouseNotFoundException (custom unchecked exception) when there is no house with the given code
		houseMap.remove(code);
	}

	private House getHouseByCode(String code) {
		return houseMap.get(code);
	}

	public void markAsSold(String code) {
		// TODO: Throw an own HouseNotFoundException (custom unchecked exception) when there is no house with the given code
		getHouseByCode(code).markAsSold();
	}
}

