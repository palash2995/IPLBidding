package main;

public class PlayerDetailsObject {
	String name;
	String country;
	String userId;
	String password;

	PlayerDetailsObject(String puserId,String ppass,String pname,String pcountry)
	{
		name = pname;
		country = pcountry;
		userId = puserId;
		password = ppass;
		
	}
}
