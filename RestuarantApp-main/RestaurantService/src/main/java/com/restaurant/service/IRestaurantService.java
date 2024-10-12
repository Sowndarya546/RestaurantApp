package com.restaurant.service;

import java.time.LocalDate;
import java.util.List;

import com.restaurant.exception.BookTableInvalidException;
import com.restaurant.model.BookTable;

public interface IRestaurantService {
	public BookTable bookATable(BookTable obj) throws BookTableInvalidException;
	public BookTable calculateBill(String bookingId);
	public List<BookTable> viewBookingOnAParticularDate(LocalDate dateRequired) throws BookTableInvalidException;
	public List<String> findStarRatedCustomer();
}
