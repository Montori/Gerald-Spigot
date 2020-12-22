package test.java.de.voidtech.geraldspigot.database;


import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.j256.ormlite.dao.Dao;

import junit.framework.TestCase;
import main.java.de.voidtech.geraldspigot.database.DatabaseService;
import main.java.de.voidtech.geraldspigot.material.MinecraftUser;

public class DatabaseTest extends TestCase
{
	private DatabaseService dbService;
	
	@Before
	public void setUp()
	{
		this.dbService = DatabaseService.getDatabaseService();
		this.dbService.initDatabaseForTest();
	}
	
	@Test
	public void testCreate() throws Exception
	{
		//Get a Data Access Object to save the User
		Dao<MinecraftUser, Long> userDao = dbService.getDAO(MinecraftUser.class);
		//Create a new User
		MinecraftUser mcUser = new MinecraftUser("kekLmaoVollDieGuteUUIDMan42069");
		//Save it to the Database
		userDao.create(mcUser);
		//Query the Database to get the MinecraftUser Object we saved earlier
		MinecraftUser mcUserFromDB = userDao.queryBuilder().where().eq("minecraftuuid", "kekLmaoVollDieGuteUUIDMan42069").queryForFirst();
		//Comparing the UUID of the MinecraftUser we created against the MinecraftUser we saved into the Database
		assertEquals(mcUser.getMinecraftUUID(), mcUserFromDB.getMinecraftUUID());
	}
	
	@Test
	public void testDelete() throws Exception 
	{
		Dao<MinecraftUser, Long> userDao = dbService.getDAO(MinecraftUser.class);
		//Databse is empty
		assertNull(userDao.queryBuilder().queryForFirst());
		
		MinecraftUser mcUser = new MinecraftUser("ichGehMichLöschenBrudi");
		userDao.create(mcUser);
		
		//Just checking if our Database has an entry because we created a MinecraftUser
		assertNotNull(userDao.queryBuilder().queryForFirst());
		
		//Deleting the MineraftUser from the Database
		userDao.delete(mcUser);
				
		//Query the Database to get the MinecraftUser we deleted
		MinecraftUser mcUserFromDBWhichIsDeleted = userDao.queryBuilder().queryForFirst();
				
		//The MinecraftUser is Null obviously since we deleted it beforehand
		assertEquals(mcUserFromDBWhichIsDeleted, null);
	}
	
	@Test
	public void testUpdate() throws Exception 
	{
		Dao<MinecraftUser, Long> userDao = dbService.getDAO(MinecraftUser.class);
		
		MinecraftUser mcUser = new MinecraftUser("Update mich Daddy");
		userDao.create(mcUser);
		
		mcUser.setMinecraftUUID("uwu");
		userDao.update(mcUser);
		
		//Checking if the user in the database has been updated
		assertTrue(mcUser.getMinecraftUUID() == userDao.queryBuilder().queryForFirst().getMinecraftUUID());
	}
	
	@Test
	public void testMultipleResults() throws Exception 
	{
		Dao<MinecraftUser, Long> userDao = dbService.getDAO(MinecraftUser.class);
		
		MinecraftUser mcUser1 = new MinecraftUser("Ich bin 1");
		MinecraftUser mcUser2 = new MinecraftUser("Ich bin 2");
		
		//Creating 2 Users at once
		userDao.create(Arrays.asList(mcUser1, mcUser2));
		
		List<MinecraftUser> resultList = userDao.queryBuilder().query();
		
		//Checking if the resultList contains the 2 users we just created
		assertEquals(resultList.size(), 2);
	}
}
