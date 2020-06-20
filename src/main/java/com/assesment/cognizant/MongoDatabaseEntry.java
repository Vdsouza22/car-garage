package com.assesment.cognizant;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.assesment.cognizant.dao.jpa.GarageRepository;
import com.assesment.cognizant.domain.Cars;

/*
 * This is a sample class to insert collections into MongoDB 
 * used only for development purpose
 * @author Vinita 
 */

@Component
	public class MongoDatabaseEntry implements  CommandLineRunner {

		@Autowired
	    private GarageRepository garageRepository;

	    public MongoDatabaseEntry(GarageRepository garageRepository) {
	        this.garageRepository = garageRepository;
	    }

	    /**
	     *This is a method used to insert entries into the database.
	     */
	    @Override
	    public void run(String... args) throws Exception {

	    	Cars c1 = new Cars(1, "Volkswagen", "Jetta III", 1995, 12947.52, true, new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-18"),"Warehouse A","Bangalore");
	    	Cars c2 = new Cars(2, "Acura", "NSX", 2001, 23175.76, false, new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-28"),"Warehouse A","Bangalore");
	    	Cars c3 = new Cars(3, "Ford", "Econoline E250", 1994, 26605.54, true, new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-13"),"Warehouse A","Bangalore");
	    	
	    	Cars c4 = new Cars(4, "Lexus", "GX", 2005, 27395.26, false, new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-12"),"Warehouse B","Delhi");
	    	Cars c5 = new Cars(5, "Dodge", "Ram Van 3500", 1999, 6244.51, false, new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-28"),"Warehouse B","Delhi");
	    	Cars c6 = new Cars(6, "Dodge", "Caravan", 1995, 16145.27, true, new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-25"),"Warehouse B","Delhi");
	    	
	    	Cars c7 = new Cars(7, "Chevrolet", "Corvette", 2004, 20019.64, true, new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-27"),"Warehouse C","Chennai");
	    	Cars c8 = new Cars(8, "Ford", "Expedition EL", 2008, 27323.42, true, new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-03"),"Warehouse C","Chennai");
	        // drop all database first
	        this.garageRepository.deleteAll();

	        // save all 
	        List<Cars> product = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8);
	        this.garageRepository.saveAll(product);
	    }
}
