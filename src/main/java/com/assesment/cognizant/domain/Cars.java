package com.assesment.cognizant.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("cars")
public class Cars {
	
	@Id
    private int id;
	private String carMake;
	private String carModel;
	private int carYearModel;
	private double carPrice;
	private boolean carLicensed;
	private Date date_added;
	private String warehouseName;
	private String warehouseLocation;
	private String url;
	
	
	
	public Cars(int id, String carMake, String carModel, int carYearModel, double carPrice, boolean carLicensed,
			Date date_added, String warehouseName, String warehouseLocation, String url) {
		super();
		this.id = id;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYearModel = carYearModel;
		this.carPrice = carPrice;
		this.carLicensed = carLicensed;
		this.date_added = date_added;
		this.warehouseName = warehouseName;
		this.warehouseLocation = warehouseLocation;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarMake() {
		return carMake;
	}
	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getCarYearModel() {
		return carYearModel;
	}
	public void setCarYearModel(int carYearModel) {
		this.carYearModel = carYearModel;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	public boolean isCarLicensed() {
		return carLicensed;
	}
	public void setCarLicensed(boolean carLicensed) {
		this.carLicensed = carLicensed;
	}
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWarehouseLocation() {
		return warehouseLocation;
	}
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

	

	
}
