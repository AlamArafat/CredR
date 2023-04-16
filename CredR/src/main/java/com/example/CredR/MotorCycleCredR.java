package com.example.CredR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotorCycleCredR {
	
	@GetMapping("/hii")
	public String gotoMainWebPage() throws Exception {
		return "Hello";
	}
	@GetMapping("/api/article/{year}/{make}/{model}")
	public Map yearMakeModel(@PathVariable("year") String year,@PathVariable("make") String make,@PathVariable("model") String model) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");  // load Driver
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		PreparedStatement stmt = connect.prepareStatement("SELECT *, M.`YEAR` as `year`, A.MAKE as make , M.MODEL as model FROM specification_of_motorcycle S INNER JOIN MOTORCYCLE_MODEL M ON  S.Specs_articleID = M.articleID INNER JOIN API_MOTORCYCLE A ON M.MAKE_ID = A.ID WHERE `YEAR` = ? AND MAKE = ? AND MODEL = ? " );

		stmt.setString(1, year);
		stmt.setString(2, make);
		stmt.setString(3, model);
		
		ResultSet rs = stmt.executeQuery();
		
		List list = new ArrayList();

		while(rs.next()) {
			Map map = new HashMap();
        	map.put("specsID", rs.getString("specsID"));
        	map.put("make", rs.getString("make"));
        	map.put("model", rs.getString("model"));
        	map.put("year", rs.getString("year"));
        	map.put("CATEGORYNAME", rs.getString("CATEGORYNAME"));
        	map.put("maDISPLACEMENTNAMEke", rs.getString("DISPLACEMENTNAME"));
        	map.put("ENGINEDETAILSNAME", rs.getString("ENGINEDETAILSNAME"));
        	map.put("POWERNAME", rs.getString("POWERNAME"));
        	map.put("TORQUENAME", rs.getString("TORQUENAME"));
        	map.put("TOPSPEEDNAME", rs.getString("TOPSPEEDNAME"));
        	map.put("COMPRESSIONNAME", rs.getString("COMPRESSIONNAME"));
        	map.put("BOREXSTROKENAME", rs.getString("BOREXSTROKENAME"));
        	map.put("VALVESPERCYLINDERNAME", rs.getString("VALVESPERCYLINDERNAME"));
        	map.put("FUELSYSTEMNAME", rs.getString("FUELSYSTEMNAME"));
        	map.put("IGNITIONNAME", rs.getString("IGNITIONNAME"));
        	map.put("LUBRICATIONSYSTEMNAME", rs.getString("LUBRICATIONSYSTEMNAME"));
        	map.put("COOLINGSYSTEMNAME", rs.getString("COOLINGSYSTEMNAME"));
        	map.put("GEARBOXNAME", rs.getString("GEARBOXNAME"));
        	map.put("TRANSMISSIONTYPEFINALDRIVENAME", rs.getString("TRANSMISSIONTYPEFINALDRIVENAME"));
        	map.put("CLUTCHNAME", rs.getString("CLUTCHNAME"));
        	map.put("DRIVELINENAME", rs.getString("DRIVELINENAME"));
        	map.put("FUELCONSUMPTIONNAME", rs.getString("FUELCONSUMPTIONNAME"));
        	map.put("GREENHOUSEGASESNAME", rs.getString("GREENHOUSEGASESNAME"));
        	map.put("EMISSIONDETAILSNAME", rs.getString("EMISSIONDETAILSNAME"));
        	map.put("EXHAUSTSYSTEMNAME", rs.getString("EXHAUSTSYSTEMNAME"));
        	map.put("FRAMETYPENAME", rs.getString("FRAMETYPENAME"));
        	map.put("FRONTBRAKESNAME", rs.getString("FRONTBRAKESNAME"));
        	map.put("FRONTBRAKESDIAMETERNAME", rs.getString("FRONTBRAKESDIAMETERNAME"));
        	map.put("FRONTSUSPENSIONNAME", rs.getString("FRONTSUSPENSIONNAME"));
        	map.put("FRONTTYRENAME", rs.getString("FRONTTYRENAME"));
        	map.put("FRONTWHEELTRAVELNAME", rs.getString("FRONTWHEELTRAVELNAME"));
        	map.put("RAKENAME", rs.getString("RAKENAME"));
        	map.put("REARBRAKESNAME", rs.getString("REARBRAKESNAME"));
        	map.put("REARBRAKESDIAMETERNAME", rs.getString("REARBRAKESDIAMETERNAME"));
        	map.put("REARSUSPENSIONNAME", rs.getString("REARSUSPENSIONNAME"));
        	map.put("REARTYRENAME", rs.getString("REARTYRENAME"));
        	map.put("REARWHEELTRAVELNAME", rs.getString("REARWHEELTRAVELNAME"));
        	map.put("TRAILNAME", rs.getString("TRAILNAME"));
        	map.put("WHEELSNAME", rs.getString("WHEELSNAME"));
        	map.put("FUELCAPACITYNAME", rs.getString("FUELCAPACITYNAME"));
        	map.put("OVERALLHEIGHTNAME", rs.getString("OVERALLHEIGHTNAME"));
        	map.put("OVERALLLENGTHNAME", rs.getString("OVERALLLENGTHNAME"));
        	map.put("OVERALLWIDTHNAME", rs.getString("OVERALLWIDTHNAME"));
        	map.put("RESERVEFUELCAPACITYNAME", rs.getString("RESERVEFUELCAPACITYNAME"));
        	map.put("SEATHEIGHTNAME", rs.getString("SEATHEIGHTNAME"));
        	map.put("WEIGHTINCLOILGASETCNAME", rs.getString("WEIGHTINCLOILGASETCNAME"));
        	map.put("COLOROPTIONSNAME", rs.getString("COLOROPTIONSNAME"));
        	map.put("COMMENTSNAME", rs.getString("COMMENTSNAME"));
        	map.put("LIGHTNAME", rs.getString("LIGHTNAME"));
        	map.put("STARTERNAME", rs.getString("STARTERNAME"));
        	
        	list.add(map);
		}
		Map data = new HashMap();
		data.put("sessions", list);
		data.put("Status: ", "OK");
		return data;
		
	}
	
	@GetMapping("/api/article/makemodel/{make}/{model}")
	public Map makeModel(@PathVariable("make") String make,@PathVariable("model") String model) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  // load Driver
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		PreparedStatement stmt = connect.prepareStatement("SELECT *, M.`YEAR` AS `YEAR`, A.MAKE as make , M.MODEL as model FROM specification_of_motorcycle S INNER JOIN MOTORCYCLE_MODEL M ON  S.Specs_articleID = M.articleID INNER JOIN API_MOTORCYCLE A ON M.MAKE_ID = A.ID WHERE MAKE=? AND MODEL= ? ");

		stmt.setString(1, make);
		stmt.setString(2, model);
		
		ResultSet rs = stmt.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			Map map = new HashMap();
        	map.put("specsID", rs.getString("specsID"));
        	map.put("make", rs.getString("make"));
        	map.put("model", rs.getString("model"));
        	map.put("year", rs.getString("year"));
        	map.put("CATEGORYNAME", rs.getString("CATEGORYNAME"));
        	map.put("maDISPLACEMENTNAMEke", rs.getString("DISPLACEMENTNAME"));
        	map.put("ENGINEDETAILSNAME", rs.getString("ENGINEDETAILSNAME"));
        	map.put("POWERNAME", rs.getString("POWERNAME"));
        	map.put("TORQUENAME", rs.getString("TORQUENAME"));
        	map.put("TOPSPEEDNAME", rs.getString("TOPSPEEDNAME"));
        	map.put("COMPRESSIONNAME", rs.getString("COMPRESSIONNAME"));
        	map.put("BOREXSTROKENAME", rs.getString("BOREXSTROKENAME"));
        	map.put("VALVESPERCYLINDERNAME", rs.getString("VALVESPERCYLINDERNAME"));
        	map.put("FUELSYSTEMNAME", rs.getString("FUELSYSTEMNAME"));
        	map.put("IGNITIONNAME", rs.getString("IGNITIONNAME"));
        	map.put("LUBRICATIONSYSTEMNAME", rs.getString("LUBRICATIONSYSTEMNAME"));
        	map.put("COOLINGSYSTEMNAME", rs.getString("COOLINGSYSTEMNAME"));
        	map.put("GEARBOXNAME", rs.getString("GEARBOXNAME"));
        	map.put("TRANSMISSIONTYPEFINALDRIVENAME", rs.getString("TRANSMISSIONTYPEFINALDRIVENAME"));
        	map.put("CLUTCHNAME", rs.getString("CLUTCHNAME"));
        	map.put("DRIVELINENAME", rs.getString("DRIVELINENAME"));
        	map.put("FUELCONSUMPTIONNAME", rs.getString("FUELCONSUMPTIONNAME"));
        	map.put("GREENHOUSEGASESNAME", rs.getString("GREENHOUSEGASESNAME"));
        	map.put("EMISSIONDETAILSNAME", rs.getString("EMISSIONDETAILSNAME"));
        	map.put("EXHAUSTSYSTEMNAME", rs.getString("EXHAUSTSYSTEMNAME"));
        	map.put("FRAMETYPENAME", rs.getString("FRAMETYPENAME"));
        	map.put("FRONTBRAKESNAME", rs.getString("FRONTBRAKESNAME"));
        	map.put("FRONTBRAKESDIAMETERNAME", rs.getString("FRONTBRAKESDIAMETERNAME"));
        	map.put("FRONTSUSPENSIONNAME", rs.getString("FRONTSUSPENSIONNAME"));
        	map.put("FRONTTYRENAME", rs.getString("FRONTTYRENAME"));
        	map.put("FRONTWHEELTRAVELNAME", rs.getString("FRONTWHEELTRAVELNAME"));
        	map.put("RAKENAME", rs.getString("RAKENAME"));
        	map.put("REARBRAKESNAME", rs.getString("REARBRAKESNAME"));
        	map.put("REARBRAKESDIAMETERNAME", rs.getString("REARBRAKESDIAMETERNAME"));
        	map.put("REARSUSPENSIONNAME", rs.getString("REARSUSPENSIONNAME"));
        	map.put("REARTYRENAME", rs.getString("REARTYRENAME"));
        	map.put("REARWHEELTRAVELNAME", rs.getString("REARWHEELTRAVELNAME"));
        	map.put("TRAILNAME", rs.getString("TRAILNAME"));
        	map.put("WHEELSNAME", rs.getString("WHEELSNAME"));
        	map.put("FUELCAPACITYNAME", rs.getString("FUELCAPACITYNAME"));
        	map.put("OVERALLHEIGHTNAME", rs.getString("OVERALLHEIGHTNAME"));
        	map.put("OVERALLLENGTHNAME", rs.getString("OVERALLLENGTHNAME"));
        	map.put("OVERALLWIDTHNAME", rs.getString("OVERALLWIDTHNAME"));
        	map.put("RESERVEFUELCAPACITYNAME", rs.getString("RESERVEFUELCAPACITYNAME"));
        	map.put("SEATHEIGHTNAME", rs.getString("SEATHEIGHTNAME"));
        	map.put("WEIGHTINCLOILGASETCNAME", rs.getString("WEIGHTINCLOILGASETCNAME"));
        	map.put("COLOROPTIONSNAME", rs.getString("COLOROPTIONSNAME"));
        	map.put("COMMENTSNAME", rs.getString("COMMENTSNAME"));
        	map.put("LIGHTNAME", rs.getString("LIGHTNAME"));
        	map.put("STARTERNAME", rs.getString("STARTERNAME"));
        	
        	list.add(map);
		}
		Map data = new HashMap();
		data.put("sessions", list);
		data.put("Status: ", "OK");
		return data;
	}
	
	@GetMapping("/api/article/speceficationbyid/{id}")
	public Map speceficationById(@PathVariable("id") String id) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  // load Driver
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		PreparedStatement stmt = connect.prepareStatement("SELECT *, M.`YEAR` AS `YEAR`, A.MAKE , M.MODEL, M.articleID FROM specification_of_motorcycle S INNER JOIN MOTORCYCLE_MODEL M ON S.Specs_articleID = M.articleID INNER JOIN API_MOTORCYCLE A ON M.MAKE_ID = A.ID WHERE M.articleID = ? ");

		stmt.setString(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			Map map = new HashMap();
        	map.put("specsID", rs.getString("specsID"));
        	map.put("make", rs.getString("make"));
        	map.put("model", rs.getString("model"));
        	map.put("year", rs.getString("year"));
        	map.put("CATEGORYNAME", rs.getString("CATEGORYNAME"));
        	map.put("maDISPLACEMENTNAMEke", rs.getString("DISPLACEMENTNAME"));
        	map.put("ENGINEDETAILSNAME", rs.getString("ENGINEDETAILSNAME"));
        	map.put("POWERNAME", rs.getString("POWERNAME"));
        	map.put("TORQUENAME", rs.getString("TORQUENAME"));
        	map.put("TOPSPEEDNAME", rs.getString("TOPSPEEDNAME"));
        	map.put("COMPRESSIONNAME", rs.getString("COMPRESSIONNAME"));
        	map.put("BOREXSTROKENAME", rs.getString("BOREXSTROKENAME"));
        	map.put("VALVESPERCYLINDERNAME", rs.getString("VALVESPERCYLINDERNAME"));
        	map.put("FUELSYSTEMNAME", rs.getString("FUELSYSTEMNAME"));
        	map.put("IGNITIONNAME", rs.getString("IGNITIONNAME"));
        	map.put("LUBRICATIONSYSTEMNAME", rs.getString("LUBRICATIONSYSTEMNAME"));
        	map.put("COOLINGSYSTEMNAME", rs.getString("COOLINGSYSTEMNAME"));
        	map.put("GEARBOXNAME", rs.getString("GEARBOXNAME"));
        	map.put("TRANSMISSIONTYPEFINALDRIVENAME", rs.getString("TRANSMISSIONTYPEFINALDRIVENAME"));
        	map.put("CLUTCHNAME", rs.getString("CLUTCHNAME"));
        	map.put("DRIVELINENAME", rs.getString("DRIVELINENAME"));
        	map.put("FUELCONSUMPTIONNAME", rs.getString("FUELCONSUMPTIONNAME"));
        	map.put("GREENHOUSEGASESNAME", rs.getString("GREENHOUSEGASESNAME"));
        	map.put("EMISSIONDETAILSNAME", rs.getString("EMISSIONDETAILSNAME"));
        	map.put("EXHAUSTSYSTEMNAME", rs.getString("EXHAUSTSYSTEMNAME"));
        	map.put("FRAMETYPENAME", rs.getString("FRAMETYPENAME"));
        	map.put("FRONTBRAKESNAME", rs.getString("FRONTBRAKESNAME"));
        	map.put("FRONTBRAKESDIAMETERNAME", rs.getString("FRONTBRAKESDIAMETERNAME"));
        	map.put("FRONTSUSPENSIONNAME", rs.getString("FRONTSUSPENSIONNAME"));
        	map.put("FRONTTYRENAME", rs.getString("FRONTTYRENAME"));
        	map.put("FRONTWHEELTRAVELNAME", rs.getString("FRONTWHEELTRAVELNAME"));
        	map.put("RAKENAME", rs.getString("RAKENAME"));
        	map.put("REARBRAKESNAME", rs.getString("REARBRAKESNAME"));
        	map.put("REARBRAKESDIAMETERNAME", rs.getString("REARBRAKESDIAMETERNAME"));
        	map.put("REARSUSPENSIONNAME", rs.getString("REARSUSPENSIONNAME"));
        	map.put("REARTYRENAME", rs.getString("REARTYRENAME"));
        	map.put("REARWHEELTRAVELNAME", rs.getString("REARWHEELTRAVELNAME"));
        	map.put("TRAILNAME", rs.getString("TRAILNAME"));
        	map.put("WHEELSNAME", rs.getString("WHEELSNAME"));
        	map.put("FUELCAPACITYNAME", rs.getString("FUELCAPACITYNAME"));
        	map.put("OVERALLHEIGHTNAME", rs.getString("OVERALLHEIGHTNAME"));
        	map.put("OVERALLLENGTHNAME", rs.getString("OVERALLLENGTHNAME"));
        	map.put("OVERALLWIDTHNAME", rs.getString("OVERALLWIDTHNAME"));
        	map.put("RESERVEFUELCAPACITYNAME", rs.getString("RESERVEFUELCAPACITYNAME"));
        	map.put("SEATHEIGHTNAME", rs.getString("SEATHEIGHTNAME"));
        	map.put("WEIGHTINCLOILGASETCNAME", rs.getString("WEIGHTINCLOILGASETCNAME"));
        	map.put("COLOROPTIONSNAME", rs.getString("COLOROPTIONSNAME"));
        	map.put("COMMENTSNAME", rs.getString("COMMENTSNAME"));
        	map.put("LIGHTNAME", rs.getString("LIGHTNAME"));
        	map.put("STARTERNAME", rs.getString("STARTERNAME"));
        	
        	list.add(map);
		}
		Map data = new HashMap();
		data.put("sessions", list);
		data.put("Status: ", "OK");
		return data;
	}
	
	
	@GetMapping("/api/article/modelbymake/{make}")
	public Map modelByMake(@PathVariable("make") String make) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  // load Driver
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		PreparedStatement stmt = connect.prepareStatement("SELECT M.MODEL as model, M.ARTICLEID as articleid FROM MOTORCYCLE_MODEL M INNER JOIN API_MOTORCYCLE A ON M.MAKE_ID = A.ID WHERE MAKE = ?");
		stmt.setString(1, make);
		
		ResultSet rs = stmt.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			Map map = new HashMap();
        	map.put("model", rs.getString("model"));
        	map.put("articleid", rs.getString("articleid"));
        		
        	list.add(map);
		}
		Map data = new HashMap();
		data.put("sessions", list);
		data.put("Status: ", "OK");
		return data;
	}
	
	@GetMapping("/article/{articleid}/{year}")
	public Map modelByMake(@PathVariable("articleid") String articleid, @PathVariable("year") String year) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  // load Driver
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		PreparedStatement stmt = connect.prepareStatement("SELECT M.MODEL as model, M.ARTICLEID as articleid, M.`year` as `year`, A.make as make FROM MOTORCYCLE_MODEL M INNER JOIN API_MOTORCYCLE A ON M.MAKE_ID = A.ID WHERE articleid = ? and `year`= ? ");
		stmt.setString(1, articleid);
		stmt.setString(2, year);
		
		ResultSet rs = stmt.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			Map map = new HashMap();
        	map.put("articleid", rs.getString("articleid"));
        	map.put("model", rs.getString("model"));
        	map.put("year", rs.getString("year"));
        	map.put("make", rs.getString("make"));
        		
        	list.add(map);
		}
		Map data = new HashMap();
		data.put("sessions", list);
		data.put("Status: ", "OK");
		return data;
	}
	
	
	@GetMapping("/api/article/production/{productionid}")
	public Map PRODUCTION_YEAR(@PathVariable("productionid") String productionid) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  // load Driver
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		PreparedStatement stmt = connect.prepareStatement("SELECT production_id, makeName , modelName, `year` from PRODUCTION_YEAR where PRODUCTION_ID = ?");
		stmt.setString(1, productionid);
		
		ResultSet rs = stmt.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			Map map = new HashMap();
        	map.put("production_id", rs.getString("production_id"));
        	map.put("makeName", rs.getString("makeName"));
        	map.put("modelName", rs.getString("modelName"));
        	map.put("year", rs.getString("year"));
        		
        	list.add(map);
		}
		Map data = new HashMap();
		data.put("sessions", list);
		data.put("Status: ", "OK");
		return data;
	}
	
	
	
	@GetMapping("/api/article/allCategories")
	public Map allCategories(String modelId, String categoryname) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  // load Driver
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		PreparedStatement stmt = connect.prepareStatement("SELECT modelId,categoryName FROM CategoryOfMotorcycle");
		
		ResultSet rs = stmt.executeQuery();
		
		List list = new ArrayList();
		int index =1;
		while(rs.next()) {
			Map map = new HashMap(index);
        	map.put("categoryname", rs.getString("categoryname"));
        	map.put("modelId", rs.getString("modelId"));
        	
        	list.add(map);
		}
		Map data = new HashMap();
		data.put("sessions", list);
		data.put("Status: ", "OK");
		return data;
	}
	
	
	
	@GetMapping("/api/article/makeIdYearCategory/{MakeID}/{Year}/{Category}")
	public Map makeIdYearCategory(@PathVariable("MakeID") String MakeID,@PathVariable("Year") String Year,@PathVariable("Category") String Category) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  // load Driver
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		PreparedStatement stmt = connect.prepareStatement("SELECT M.articleId as articleId, M.MODEL as MODEL, M.`YEAR` as `year`, C.categoryName as categoryName, C.modelId as modelId  FROM CategoryOfMotorcycle C INNER JOIN MOTORCYCLE_MODEL M ON C.articleId = M.articleId WHERE modelId = ? AND `YEAR` = ? AND categoryName = ? ");
		stmt.setString(1, MakeID);
		stmt.setString(2, Year);
		stmt.setString(3, Category);
		
		ResultSet rs = stmt.executeQuery();
		
		List list = new ArrayList();
		int index =1;
		while(rs.next()) {
			Map map = new HashMap(index);
        	map.put("articleId", rs.getString("articleId"));
        	map.put("MODEL", rs.getString("MODEL"));
        	map.put("YEAR", rs.getString("YEAR"));
        	map.put("categoryName", rs.getString("categoryName"));
        	map.put("modelId", rs.getString("modelId"));
        	
        	list.add(map);
		}
		Map data = new HashMap();
		data.put("sessions", list);
		data.put("Status: ", "OK");
		return data;
	}
	
	
	
	@GetMapping("/api/article/modelcategoryname/{CategoryName}")
	public Map ModelByCategoryName(@PathVariable("CategoryName") String CategoryName) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  // load Driver
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		PreparedStatement stmt = connect.prepareStatement("SELECT M.articleId as articleId, M.MODEL as MODEL, M.`YEAR` as `year`, C.categoryName as categoryName, C.modelId as modelId  FROM CategoryOfMotorcycle C INNER JOIN MOTORCYCLE_MODEL M ON C.articleId = M.articleId WHERE categoryName = ? ");
		stmt.setString(1, CategoryName);
		
		ResultSet rs = stmt.executeQuery();
		
		List list = new ArrayList();
		int index =1;
		while(rs.next()) {
			Map map = new HashMap(index);
        	map.put("articleId", rs.getString("articleId"));
        	map.put("MODEL", rs.getString("MODEL"));
        	map.put("YEAR", rs.getString("YEAR"));
        	map.put("categoryName", rs.getString("categoryName"));
        	map.put("modelId", rs.getString("modelId"));
        	
        	list.add(map);
		}
		Map data = new HashMap();
		data.put("sessions", list);
		data.put("Status: ", "OK");
		return data;
	}
	
	@PutMapping("/api/article/uploadimage/{articleId}")
	public String uploadImageUrl(@PathVariable("articleId") String articleId, String imageurl) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "aalam");
		
		Statement statement = connect.createStatement();
		
		PreparedStatement stmt = connect.prepareStatement("SELECT * FROM motorcycle_model WHERE articleId = ? ");
		
		stmt.setString(1, articleId);

		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			String artId= rs.getString("articleId");  // SQL column name "PASSWORD";
			if(artId.equals(articleId)) {
				System.out.println("articleid"+ articleId);
				PreparedStatement stmt1 = connect.prepareStatement("UPDATE motorcycle_model set image= ( ? ) where articleId='"+artId+"'");
   				stmt1.setString(1, imageurl);
   				int i = stmt1.executeUpdate();
   				if (i>0) 
   				return "Your imageurl is set in DB at this articleId"+ artId;
			}
			
		}
		return "";
	}
}
