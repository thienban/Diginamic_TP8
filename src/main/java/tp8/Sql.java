package tp8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Sql {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:bqrcmsxia-mysql.services.clever-cloud.com\r\n" + 
				"bqrcmsxia","urwsgukveufl9sxo","GaPbqig83miYkOpkYdz");
		Statement stat = conn.createStatement();
		conn.setAutoCommit(false);
		
		for (int i=0; i<100; i++) {
			
		//ID, NOM
		
		String query = "INSERT into fournisseur VALUES ("+ (i+10) + ",'FOU_" + (i+10) + "')";
		//stat.executeUpdate(query);
		
			if (i%10 == 0) {
			//conn.commit();	
			}
		}
		
		for (int i=0; i<1000000; i++) {
			
			double prix = Math.random()*1000;
			int idFou = 10 + (int)(Math.random()*99);
			
			//ID, REF, DESIGNATION, PRIX, ID_FOU
			
			String query = "INSERT into article VALUES (" + (i+100) + ",'REF_" + (i+100)+"', 'DESIGNATION_" + (i+100) +"'" + ',' + prix + ',' + idFou +")" ;
			System.out.println(query);
			stat.executeUpdate(query);
			
			if (i%1000 == 0) {
				conn.commit();	
				}
			
		}
		
		
		conn.commit();
		conn.close();
		
	}
	

}
