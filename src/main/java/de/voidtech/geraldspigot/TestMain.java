package main.java.de.voidtech.geraldspigot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.de.voidtech.geraldspigot.database.DatabaseHelper;
import main.java.de.voidtech.geraldspigot.material.MinecraftUser;

public class TestMain {

	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatabaseHelper dbh = DatabaseHelper.getInstance();
		
		dbh.initDB();
		
		SessionFactory sf = dbh.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		MinecraftUser mcUser = new MinecraftUser("lolkek");
		session.save(mcUser);
		session.clear();
		
		MinecraftUser dbMcUser = (MinecraftUser) session.createQuery("from MinecraftUser").uniqueResult();
		
		System.out.println(dbMcUser.getMinecraftUUID());
	}

}
