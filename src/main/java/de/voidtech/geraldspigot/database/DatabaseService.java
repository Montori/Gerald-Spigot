package main.java.de.voidtech.geraldspigot.database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


/**
 * Service for handling the initial use of the Database
 * 
 * @author Montori
 */
public class DatabaseService {
	private static volatile DatabaseService dbService;
	private static final Logger LOGGER = Logger.getLogger(DatabaseService.class.getName());

	public synchronized static DatabaseService getDatabaseService() {
		if (DatabaseService.dbService != null) {
			return DatabaseService.dbService;
		}
		DatabaseService.dbService = new DatabaseService();
		return dbService;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> Dao<T, Long> getDAO(Class<T> sourceClass) throws SQLException {
		ConnectionSource connectionSource = new JdbcPooledConnectionSource("jdbc:h2:mem:geraldSpigotDBForTest");
		Dao dao = DaoManager.createDao(connectionSource, sourceClass);
		return dao;
	}

	/**
	 * Used to initialize all Entities in the Database. This method will also create
	 * all the neccessary tables in the Database if they don't exist. All Object
	 * that are to be persisted must be registered in @see RegisteredDatabaseEntities.
	 */
	public void initDatabase() {
		try {
			ConnectionSource connectionSource = new JdbcPooledConnectionSource("jdbc:h2:mem:geraldSpigotDB");
			for(RegisteredDatabaseEntities entity : RegisteredDatabaseEntities.values())
			{
				TableUtils.createTableIfNotExists(connectionSource, entity.getEntityClass());
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "An Error has occurred during Database initilization: " + e.getMessage());
		}
	}

	/**
	 * same as initDatabase but for TEST USE ONLY
	 */
	public void initDatabaseForTest() {
		try {
			ConnectionSource connectionSource = new JdbcPooledConnectionSource("jdbc:h2:mem:geraldSpigotDBForTest");
			// Drop existing Tables and init all Entities
			for (RegisteredDatabaseEntities entity : RegisteredDatabaseEntities.values()) {
				TableUtils.dropTable(connectionSource, entity.getEntityClass(), true);
				TableUtils.createTableIfNotExists(connectionSource, entity.getEntityClass());
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "An Error has occurred during Database initilization: " + e.getMessage());
		}
	}

}
