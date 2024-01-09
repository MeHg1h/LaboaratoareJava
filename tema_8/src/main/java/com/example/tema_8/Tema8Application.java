package com.example.tema_8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Tema8Application {

	public static void main(String[] args) {
		SpringApplication.run(Tema8Application.class, args);
	}
}

@RestController
@RequestMapping("/api")
class MyController {

	private static List<MyData> dataList = new ArrayList<>();

	// Endpoint pentru cerere GET
	@GetMapping("/get-data")
	public MyData getData(@RequestParam String columnName, @RequestParam String value) {
		return dataList.stream()
				.filter(data -> data.matches(columnName, value))
				.findFirst()
				.orElse(null);
	}

	// Endpoint pentru cerere POST
	@PostMapping("/add-data")
	public String addData(@RequestBody List<MyData> newDataList) {
		dataList.addAll(newDataList);
		return "Data added successfully!";
	}

	// Endpoint pentru cerere DELETE
	@DeleteMapping("/delete-data")
	public String deleteData(@RequestParam String columnName, @RequestParam String value) {
		dataList = dataList.stream()
				.filter(data -> !data.matches(columnName, value))
				.collect(Collectors.toList());
		return "Data deleted successfully!";
	}

	// Endpoint pentru cerere PUT
	@PutMapping("/update-data")
	public String updateData(@RequestParam String columnName, @RequestParam String searchValue,
							 @RequestParam String updateColumnName, @RequestParam String updateValue) {
		dataList.forEach(data -> {
			if (data.matches(columnName, searchValue)) {
				data.setValue(updateColumnName, updateValue);
			}
		});
		return "Data updated successfully!";
	}

	// Clasă simplă pentru reprezentarea datelor
	private static class MyData {
		private String name;
		private String age;

		public MyData(String name, String age) {
			this.name = name;
			this.age = age;
		}

		public boolean matches(String columnName, String value) {
			switch (columnName.toLowerCase()) {
				case "name":
					return name.equals(value);
				case "age":
					return age.equals(value);
				default:
					return false;
			}
		}

		public void setValue(String columnName, String value) {
			switch (columnName.toLowerCase()) {
				case "name":
					this.name = value;
					break;
				case "age":
					this.age = value;
					break;
			}
		}
	}
}
