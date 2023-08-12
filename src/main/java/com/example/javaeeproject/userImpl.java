package com.example.javaeeproject;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList; 
public class userImpl  implements UserIn{

	@Override
	public List<user> getuserParMotCle(String mc) {
		// TODO Auto-generated method stub
		List<user> users= new ArrayList<user>(); 
		Connection conn=UserConnection.getConnection(); 
		try { 
		PreparedStatement ps= conn.prepareStatement("select * from users where username LIKE ?");
		ps.setString(1, "%"+mc+"%"); 
		ResultSet rs = ps.executeQuery(); 
		while (rs.next()) { 
		user newuser = new user();
			newuser.setIduser(rs.getLong("id"));
			newuser.setUsername(rs.getString("username"));
			newuser.setEmail(rs.getString("useremail"));
			newuser.setPassword(rs.getString("userpsw"));
			newuser.setNumber(rs.getInt("number"));

		users.add(newuser);
		}
		} catch (SQLException e) { 
		e.printStackTrace(); 
		}
		return users; 
		}

	

	@Override
	public  user adduser(user p) {
		// TODO Auto-generated method stub
		 Connection conn=UserConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO users "+
					"(username, userpsw, useremail, number) VALUES"+
							"(?, ?, ?, ?)");
			ps.setString(1, p.getUsername());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getEmail());
			
			ps.setInt(4, p.getNumber());

			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(id) as MAX_ID FROM users");
			ResultSet rs =ps2.executeQuery();
			if (rs.next()) {
				p.setIduser(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();

					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}



	@Override
	public user getuser(long id) {
		// TODO Auto-generated method stub
		Connection conn=UserConnection.getConnection();
	    user p = new user();
       try {
		PreparedStatement ps= conn.prepareStatement("select * from users where id = ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if  (rs.next()) {
			
			p.setIduser( rs.getLong("id"));
			p.setUsername(rs.getString("username"));
			p.setPassword(rs.getString("userpsw"));
			p.setEmail(rs.getString("useremail"));	
			p.setNumber(rs.getInt("number"));
			
			
		}
			
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		return p;
}
	

	@Override
	public user updateuser(user p) {
		// TODO Auto-generated method stub
		Connection conn=UserConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE users  SET username=?,userpsw=?,useremail=?,number=? WHERE id=?");
			ps.setString(1, p.getUsername());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getEmail());
			
			ps.setInt(4, p.getNumber());
			ps.setLong(5, p.getIduser());

			ps.executeUpdate();
		
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	

	@Override
	public void deleteuser(long id) {
		// TODO Auto-generated method stub
		 Connection conn=UserConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM users WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}



	@Override
	public List<user> selectALLUsers() {
		// TODO Auto-generated method stub
		List<user> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		Connection connection = UserConnection.getConnection();

				try{// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				user p = new user(); 
				p.setIduser(rs.getLong("id"));
				p.setUsername(rs.getString("username"));
				p.setEmail(rs.getString("useremail"));
				p.setPassword(rs.getString("userpsw"));
				p.setNumber(rs.getInt("number"));

				users.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public user insertUser(user p) {
		Connection conn=UserConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, userpsw, useremail, number) VALUES (?, ?, ?, ?)");
			ps.setString(1, p.getUsername());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getEmail());
			ps.setInt(4, p.getNumber());

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return p;
	}

	@Override
	public user getuser(String email, String password) {
		Connection conn=UserConnection.getConnection();
		user c = new user ( password,email);
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE useremail = ? AND userpsw = ?");
			ps.setString(1, email);
			ps.setString(2,password);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				c.setIduser( rs.getLong("id"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("userpsw"));
				c.setEmail(rs.getString("useremail"));
				c.setNumber(rs.getInt("number"));
			}

			conn.close();

		}catch(Exception e) {
			System.out.println(e);
		}
		return c;
	}

}


	
	


