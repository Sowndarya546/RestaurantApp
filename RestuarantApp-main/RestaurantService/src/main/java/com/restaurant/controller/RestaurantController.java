package com.restaurant.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.exception.BookTableInvalidException;
import com.restaurant.model.BookTable;
import com.restaurant.service.IRestaurantService;
import com.restaurant.validation.RestaurantValidator;

@RestController
@RequestMapping("/restaurantapp")
public class RestaurantController {
	@Autowired
	RestaurantValidator validator;

	@Autowired
	IRestaurantService iRestaurantService;

	@PostMapping("/book")
	public BookTable bookATable(@RequestBody @Valid BookTable bookObj) throws BookTableInvalidException {
		//validator.validate(bookObj);
		return iRestaurantService.bookATable(bookObj);
	}

	@PutMapping("/calculate/{bookingId}")
	public BookTable calculateBill(@PathVariable String bookingId) {
		return iRestaurantService.calculateBill(bookingId);
	}

	@GetMapping("/viewBooking/{dateRequired}")
	public List<BookTable> viewBookingOnAParticularDate(@PathVariable String dateRequired)
			throws BookTableInvalidException {
		LocalDate localDate = LocalDate.parse(dateRequired);
		return iRestaurantService.viewBookingOnAParticularDate(localDate);
	}

	@GetMapping("/starRated")
	public List<String> findStarRatedCustomer() {
		return iRestaurantService.findStarRatedCustomer();
	}
}
