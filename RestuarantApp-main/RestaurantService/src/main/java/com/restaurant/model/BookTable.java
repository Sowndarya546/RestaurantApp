package com.restaurant.model;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BookTable {
	private String bookingId;

	@NotNull(message = "Provide value for customer name")
	private String customerName;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getTotalGuestCount() {
		return totalGuestCount;
	}

	public void setTotalGuestCount(Integer totalGuestCount) {
		this.totalGuestCount = totalGuestCount;
	}

	public Integer getTotalAdultVegCount() {
		return totalAdultVegCount;
	}

	public void setTotalAdultVegCount(Integer totalAdultVegCount) {
		this.totalAdultVegCount = totalAdultVegCount;
	}

	public Integer getTotalAdultNonVegCount() {
		return totalAdultNonVegCount;
	}

	public void setTotalAdultNonVegCount(Integer totalAdultNonVegCount) {
		this.totalAdultNonVegCount = totalAdultNonVegCount;
	}

	public Integer getTotalKidsVegCount() {
		return totalKidsVegCount;
	}

	public void setTotalKidsVegCount(Integer totalKidsVegCount) {
		this.totalKidsVegCount = totalKidsVegCount;
	}

	public Integer getTotalKidsNonVegCount() {
		return totalKidsNonVegCount;
	}

	public void setTotalKidsNonVegCount(Integer totalKidsNonVegCount) {
		this.totalKidsNonVegCount = totalKidsNonVegCount;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	private String mobileNumber;

	private Integer totalGuestCount;

	@DecimalMin(value = "0", inclusive = true, message = "Provide value greater than or equal to zero")
	private Integer totalAdultVegCount;

	@DecimalMin(value = "0", inclusive = true, message = "Provide value greater than or equal to zero")
	private Integer totalAdultNonVegCount;

	@DecimalMin(value = "0", inclusive = true, message = "Provide value greater than or equal to zero")
	private Integer totalKidsVegCount;

	@DecimalMin(value = "0", inclusive = true, message = "Provide value greater than or equal to zero")
	private Integer totalKidsNonVegCount;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate bookingDate;
	private Double totalBillAmount;

	public BookTable(String bookingId, String customerName, String mobileNumber, Integer totalGuestCount,
			Integer totalAdultVegCount, Integer totalAdultNonVegCount, Integer totalKidsVegCount,
			Integer totalKidsNonVegCount, LocalDate bookingDate, Double totalBillAmount) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.totalGuestCount = totalGuestCount;
		this.totalAdultVegCount = totalAdultVegCount;
		this.totalAdultNonVegCount = totalAdultNonVegCount;
		this.totalKidsVegCount = totalKidsVegCount;
		this.totalKidsNonVegCount = totalKidsNonVegCount;
		this.bookingDate = bookingDate;
		this.totalBillAmount = totalBillAmount;
	}

	public BookTable() {

	}

}
