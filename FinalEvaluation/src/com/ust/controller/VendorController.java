package com.ust.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.VendorDao;
import com.ust.model.Login;
import com.ust.model.VendorDetails;

@RestController
public class VendorController {
	@Autowired
	VendorDao dao;
	

	// view vendors list
	@RequestMapping(value = "/api/vendor/{vendorName}", method = RequestMethod.GET)
	@ResponseBody
	public List getStaff(Model m, @PathVariable("vendorName") String name) {
		List list;
		if (name.equals("null")) {
			list = dao.getVendor();
		} else {
			list = dao.getVendorByName(name);
		}

		return list;
	}
	// view vendor list by id
	@RequestMapping(value = "/api/vendors/{vendor_id}", method = RequestMethod.GET)
	@ResponseBody
	public VendorDetails getvendors(Model m, @PathVariable("vendor_id") int vendor_id) {
		
		
		return dao.getVendorById(vendor_id);
	}


			@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
			@ResponseBody
			public Login selectUser(@PathVariable("username") String username,
					@PathVariable("password") String password) {
				return dao.selectRole(username,password);
			}

	

			// Add Vendor
			@ResponseBody
			@RequestMapping(value = "/api/insertvendor", method = RequestMethod.POST)
			public void insertDoctor(@RequestBody VendorDetails vc)  throws ParseException {
				dao.saveVendor(vc);
			}
			
			
			
			
			// update Vendor
			@ResponseBody
			@RequestMapping(value = "/api/updatevendor", method = RequestMethod.PUT)
			public void updateDoctor(@RequestBody VendorDetails vd) throws ParseException {
				int vendor_id = vd.getVendorId();
				dao.updateVendor(vendor_id, vd);
			}

			
			// to disable a vendor

			@RequestMapping(value = "/api/disablevendor/{vId}", method = RequestMethod.PUT)
			@ResponseBody
			public void disableStaff(@PathVariable("vId") int vId) {
			dao.disableVendor(vId);
			}
			
			// view contactdetails by vendor id

			@RequestMapping(value = "/api/contactDetails/{vId}", method = RequestMethod.GET)
			@ResponseBody
			public List getContactDetails(Model m,@PathVariable("vId") int vId) {
				List list;
			list=dao.getContactDetailsByVId(vId);
			return list;

			}



}
	
	


