package test.java.de.pds.voidtech.geraldspigot.commands;

import org.junit.Test;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.expectLastCall;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import junit.framework.TestCase;
import main.java.de.voidtech.geraldspigot.commands.TestCommand;
public class TestCommandTest extends TestCase {
	
	@Test
	public void testDefault() throws Exception
	{
		TestCommand testCommand = new TestCommand();
		
		CommandSender sender = mock(CommandSender.class);
		Command command = mock(Command.class);
		
		sender.sendMessage("Test was successful!");
		expectLastCall();
		
		replay(sender, command);
		
		assertTrue(testCommand.onCommand(sender, command, null, null));
	
		verify(sender, command);
	}
}
