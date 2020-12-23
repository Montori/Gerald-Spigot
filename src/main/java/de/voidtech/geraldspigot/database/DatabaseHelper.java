package main.java.de.voidtech.geraldspigot.database;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import main.java.de.voidtech.geraldspigot.material.MinecraftUser;

public class DatabaseHelper {

	private static volatile DatabaseHelper instance;

	private SessionFactory rootSessionFactory;

	private DatabaseHelper() {
	}

	public static DatabaseHelper getInstance() {
		if (DatabaseHelper.instance == null) {
			DatabaseHelper.instance = new DatabaseHelper();
		}
		return DatabaseHelper.instance;
	}

	public SessionFactory getSessionFactory() {
		if (this.rootSessionFactory == null) {

			try {
				Properties properties = new Properties();
				properties.put(Environment.DRIVER, "org.h2.Driver");
				properties.put(Environment.URL, "jdbc:h2:mem:GeraldSpigot.db");
				properties.put(Environment.USER, "sa");
				properties.put(Environment.PASS, "");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				
				Configuration hibernateConfig = new Configuration();
				hibernateConfig.setProperties(properties);
				hibernateConfig.addAnnotatedClass(MinecraftUser.class);
				
				this.rootSessionFactory = hibernateConfig.buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return this.rootSessionFactory;
	}
	
	//THIS IS NOT FINAL THIS IS JUST TO TEST ALL THAT SHIT.
	public void initDB()
	{
		Session session = getSession();
		session.beginTransaction();
		System.out.println(session.createNativeQuery("CREATE TABLE minecraft_user (\r\n"
				+ "	userID IDENTITY,\r\n"
				+ "	minecraftUUID VARCHAR(55),\r\n"
				+ "	currency BIGINT,\r\n"
				+ "	\r\n"
				+ "	CONSTRAINT pk_minecraft_user_userID PRIMARY KEY (userID)\r\n"
				+ ");").executeUpdate());
	}

	public Session getSession() {
		return this.getSessionFactory().openSession();
	}
}
