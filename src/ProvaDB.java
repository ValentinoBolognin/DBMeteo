import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProvaDB {

	public static void main(String[] args) {

		String jdbcURL = "jdbc:mysql://localhost/meteo?user=root&password=root" ;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL) ;
		
			Statement st = conn.createStatement() ;
			
			String sql = "SELECT Localita, COUNT(*) AS NUM " +
						"FROM situazione " +
						"GROUP BY Localita" ;
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				
				String localita = res.getString("localita") ;
				int num = res.getInt("num") ;
						
				System.out.format("Localita %s, numero %d\n", 
						localita, num) ;
				
			}
			
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
