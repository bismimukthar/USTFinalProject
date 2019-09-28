package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;







import com.ust.model.Login;
import com.ust.model.Vendor;
import com.ust.model.VendorDetails;

public class VendorDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
//	//to select the role
//	public Login selectRole(String username, String password) {
//		String sql = "select user_id from login where username='"
//				+ username
//				+ "' and password='" + password + "'";
//		return template.queryForObject(sql, new Object[] {},
//				new BeanPropertyRowMapper<Login>(Login.class));
//	}

    //to view all the vendors
	public List<Vendor> getVendor() {
		return template
				.query("select vendor_id,vendor_name,address,location,service,pincode,isActive from vendor where isActive=0",
						new RowMapper<Vendor>() {
							public Vendor mapRow(ResultSet rs, int row)
									throws SQLException {
								Vendor v = new Vendor();
								v.setVendorId(rs.getInt(1));
								v.setVendorName(rs.getString(2));
								v.setAddress(rs.getString(3));
								v.setLocation(rs.getString(4));
								v.setService(rs.getString(5));
								v.setPincode(rs.getInt(6));
								v.setIsActive(rs.getInt(7));
								
								return v;
							}
						});
	}
	
					
	

//validation
	public Login selectRole(String username, String password) {
		String sql = "select user_id from login where username='"
				+ username
				+ "' and password='" + password + "'";
		return template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Login>(Login.class));
	}

		//to insert vendor
		public int saveVendor(VendorDetails vc) {

			String sql1 = "insert into vendor(vendor_name,address,location,service,pincode,isActive) values "
					+ "('"
					+ vc.getVendorName()
					+ "','"
					+ vc.getAddress()
					+ "','"
					+ vc.getLocation()
					+ "','"
					+ vc.getService()
					+ "','"
					+ vc.getPincode()
					+ "',"
					+ 0
					+ ")";

			 template.update(sql1);
			 
			 Integer maxId = getSequence();
			 String sql2="insert into contactdetails(vendor_id,name,dept,email,phone) values ("
					 + maxId
						+ ",'"
						+ vc.getName()
						+ "','"
						+ vc.getDept()
						+ "','"
						+ vc.getEmail()
						+ "','" + vc.getPhone() + "')";
			 return template.update(sql2);

					 
			 
		}
		
		
		//------get vendor by name
		
			public List<VendorDetails> getVendorByName(String vendor_name) {
				return template
						.query("select vendor_id,vendor_name,address,location,service,pincode from vendor where isActive=0 and vendor_name='"+ vendor_name + "'",
								new RowMapper<VendorDetails>() {
									public VendorDetails mapRow(ResultSet rs, int row)
											throws SQLException {
										VendorDetails vc = new VendorDetails();
										vc.setVendorId(rs.getInt(1));
										vc.setVendorName(rs.getString(2));
										vc.setAddress(rs.getString(3));
										vc.setLocation(rs.getString(4));
										vc.setService(rs.getString(5));
										vc.setPincode(rs.getInt(6));
										return vc;
									}
								});
			}
			
		
			//------------get vendor details by id
			public VendorDetails getVendorById(int vendor_id) {
				
			String	sql= "select vc.vendor_id,vc.vendor_name,vc.address,vc.location,vc.service,vc.pincode,cd.name,cd.dept,cd.email,cd.phone,cd.contact_id from vendor vc join contactdetails cd on vc.vendor_id=cd.vendor_id where vc.isActive=0 and vc.vendor_id='"+ vendor_id + "'";
			return template.queryForObject(sql, new Object[] {},
					new BeanPropertyRowMapper<VendorDetails>(VendorDetails.class));
				
//				return template
//						.query("select vc.vendor_id,vc.vendor_name,vc.address,vc.location,vc.service,vc.pincode,cd.name,cd.department,cd.email,cd.phone,cd.contact_id from vendor vc join contactdetails cd on vc.vendor_id=cd.vendor_id where vc.isActive=0 and vc.vendor_id='"+ vendor_id + "'",
//								new RowMapper<VendorDetails>() {
//									public VendorDetails mapRow(ResultSet rs, int row)
//											throws SQLException {
//										VendorDetails vc = new VendorDetails();
//										vc.setVendor_id(rs.getInt(1));
//										vc.setVendor_name(rs.getString(2));
//										vc.setAddress(rs.getString(3));
//										vc.setLocation(rs.getString(4));
//										vc.setService(rs.getString(5));
//										vc.setPincode(rs.getInt(6));
//										vc.setName(rs.getString(7));
//										vc.setDepartment(rs.getString(8));
//										vc.setEmail(rs.getString(9));
//										vc.setPhone(rs.getString(10));
//										vc.setContact_id(rs.getInt(11));
//										return vc;
//									}
//								});
			}



		
		
		
		//---------- to get vendor id
		private Integer getSequence() {
			Integer seq;
			String sql = "select MAX(vendor_id)from vendor";
			seq = template.queryForObject(sql, new Object[] {}, Integer.class);
			return seq;
		}
		
		//-------------- update vendor
		public int updateVendor(int vendor_id, VendorDetails vc) {

			String sql = "update vendor set vendor_name='" + vc.getVendorName()
					+ "' ,address='" + vc.getAddress() + "' ,location='"
					+ vc.getLocation() + "',service='" + vc.getService() + "',pincode='" + vc.getPincode() + "',isActive=" + vc.getIsActive() + " "
					+ "where vendor_id =" + vendor_id;
			template.update(sql);

			// Integer maxId = getSequence();

			String sql1 = "update contactdetails set vendor_id=" + vendor_id + ",name='"
					+ vc.getName() + "',dept='"
					+ vc.getDept() + "',email='"
					+ vc.getEmail() + "',phone='" + vc.getPhone() + "'where contact_id = " + vc.getContactid();

			return template.update(sql1);
		}
		
		//-------------- get contactdetails by id

		public List<VendorDetails> getContactDetailsByVId(int vid) {
		return template.query("select contact_id,name,dept,vendor_id,email,phone from contactdetails where vendor_id="+vid+"", new RowMapper<VendorDetails>() {
			public VendorDetails mapRow(ResultSet rs, int row)
					throws SQLException {
				VendorDetails vc = new VendorDetails();
				vc.setContactid(rs.getInt(1));
				vc.setName(rs.getString(2));
				vc.setDept(rs.getString(3));
				vc.setVendorId(rs.getInt(4));
				vc.setEmail(rs.getString(5));
				vc.setPhone(rs.getString(6));
				return vc;
			}
		});
		}
		//--------------- to disable a vendor
		public int disableVendor(int vId) {

		String sql = "update vendor set isActive='1' where vendor_id=" + vId
		+ "";

		return template.update(sql);
		}
		
	}

	
