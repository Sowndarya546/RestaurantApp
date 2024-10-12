package com.restaurant.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.restaurant.exception.BookTableInvalidException;
import com.restaurant.model.BookTable;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestaurantServiceImpl implements IRestaurantService {

	private static List<BookTable> bookList = new ArrayList<BookTable>();

	public static List<BookTable> getBookList() {
		return bookList;
	}

	public static void setBookList(List<BookTable> bookList) {
		RestaurantServiceImpl.bookList = bookList;
	}

	public RestaurantServiceImpl() {

	}

	@Override
	public BookTable bookATable(BookTable obj) throws BookTableInvalidException {
		Pattern pattern = Pattern.compile("[6789]\\d{9}");
		Matcher matcher = pattern.matcher(obj.getMobileNumber());
		if (matcher.matches()) {
			List<BookTable> addTable = getBookList();
			addTable.add(obj);
			setBookList(addTable);
			//log.info("Customer with id : {} booked successfully", obj.getBookingId());
			return obj;
		} else {
			//log.error("Enter valid mobile number");
			throw new BookTableInvalidException("Enter valid mobile number");
		}

	}

	@Override
	public BookTable calculateBill(String bookingId) {
		BookTable bookTable = getBookList().stream().filter(bt -> bt.getBookingId().equalsIgnoreCase(bookingId))
				.findFirst().orElse(null);
		Integer totalAdultNonVeg = bookTable.getTotalAdultNonVegCount() * 699;
		Integer totalKidNonVeg = bookTable.getTotalKidsNonVegCount() * 349;
		Integer totalAdultVeg = bookTable.getTotalAdultVegCount() * 599;
		Integer totalKidVeg = bookTable.getTotalKidsVegCount() * 249;
		Double grandTotal = (double) (totalAdultNonVeg + totalAdultVeg + totalKidNonVeg + totalKidVeg);
		bookTable.setTotalBillAmount(grandTotal);
		//log.info("Transaction completed successfully");
		return bookTable;
	}

	@Override
	public List<BookTable> viewBookingOnAParticularDate(LocalDate dateRequired) throws BookTableInvalidException {
		List<BookTable> bookTables = getBookList().stream().filter(bt -> bt.getBookingDate().equals(dateRequired))
				.collect(Collectors.toList());
		if (CollectionUtils.isEmpty(bookTables)) {
			//log.error("No bookings available on the given date");
			throw new BookTableInvalidException("No bookings available on the given date");
		}
		//log.info("“View booking on a particular date is successfully done");
		return bookTables;
	}

	@Override
	public List<String> findStarRatedCustomer() {
		List<String> list = null;
		Map<String, Long> count = getBookList().stream()
				.collect(Collectors.groupingBy(BookTable::getMobileNumber, Collectors.counting()));
		for (Map.Entry<String, Long> entry : count.entrySet()) {
			list = new ArrayList<String>();
			if (entry.getValue() > 2) {
				list.add(entry.getKey());
			}
		}
		//log.info("“Find star rated customer is successful");
		return list;
	}

}
