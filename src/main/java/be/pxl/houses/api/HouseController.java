package be.pxl.houses.api;

import be.pxl.houses.domain.House;
import be.pxl.houses.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("houses")
public class HouseController {

	private final HouseService houseService;

	@Autowired
	public HouseController(HouseService houseService) {
		this.houseService = houseService;
	}

	@PostMapping
	public void createHouse(@RequestBody CreateHouseRequest house) {
		houseService.addHouse(house);
	}

	@PutMapping("{code}")
	public void updateHouse(@PathVariable String code, @RequestBody UpdateHouseRequest house) {
		houseService.updateHouse(code, house);
	}

	@PutMapping("{code}/mark-as-sold")
	public void updateHouseMarkAsSold(@PathVariable String code) {
		houseService.markAsSold(code);
	}

	@GetMapping
	public List<House> getAllHouses() {
		return houseService.getHouses();
	}

	@DeleteMapping("{code}")
	public void deleteHouse(@PathVariable String code) {
		houseService.deleteHouse(code);
	}
}
