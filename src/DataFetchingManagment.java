import java.sql.ResultSet;
import java.util.ArrayList;

public class DataFetchingManagment
{	
	public DataFetchingManagment(DBConnect db)
	{
		
	}
	
	public static ArrayList<Client> initializeClients()
	{
		ArrayList<Client> clients = new ArrayList<>();
		DBConnect db = new DBConnect();
		
		db.connect();
		
		try
		{
			String query = "SELECT id FROM client ORDER BY id";
			ResultSet rs = db.getStatement().executeQuery(query);
			
			while(rs.next())
				clients.add(new Client(rs.getString("id")));
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return clients;
	}
	
	public static ArrayList<Product> initializeProducts()
	{
		ArrayList<Product> products = new ArrayList<>();
		DBConnect db = new DBConnect();
		
		db.connect();
		
		try
		{
			String query = "SELECT id FROM product ORDER BY id";
			ResultSet rs = db.getStatement().executeQuery(query);
			
			while(rs.next())
				products.add(new Product(rs.getString("id")));
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return products;
	}
	
	public static ArrayList<Order> initializeRecord()
	{
		ArrayList<Order> ordersRecord = new ArrayList<>();
		DBConnect db = new DBConnect();
		
		db.connect();
		
		try
		{
			String query = "SELECT DISTINCT lastEdit, clientId, employeeUsername, closed FROM orders ORDER BY lastEdit";
			ResultSet rs = db.getStatement().executeQuery(query);
			
			while(rs.next())
				ordersRecord.add(new Order(rs.getString("lastEdit"), rs.getString("clientId"), rs.getString("employeeUsername"), rs.getString("closed")));
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return ordersRecord;
	}
}