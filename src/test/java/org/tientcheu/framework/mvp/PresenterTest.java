package org.tientcheu.framework.mvp;

import org.apache.log4j.Logger;
import org.tientcheu.framework.mvp.api.IPresenter;
import org.tientcheu.framework.mvp.api.IPresenterCommand;
import org.tientcheu.framework.mvp.api.Identifiable;

import junit.framework.TestCase;

public class PresenterTest extends TestCase {
	
	private static Logger logger = Logger.getLogger(PresenterTest.class);

	private Presenter<Object, Object> presenter = new Presenter<Object, Object>();
	
	public PresenterTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddIPresenterAttribute() {
		fail("Not yet implemented");
	}

	public void testAddIPresenterCommand() {
		
		presenter.add(newCommand("Create"));
		presenter.add(newCommand("Save"));
		presenter.add(newCommand("Insert"));
		presenter.add(newCommand("Update"));
		presenter.add(newCommand("Cancel"));
		assertTrue(presenter.getPresenterCommands().size() == 5);
	}

	private IPresenterCommand newCommand(String commandName) {
		Identifiable commandIdentifier = newIdentifiable(commandName);
		IPresenterCommand command = newPresenterCommand(commandIdentifier);		
		return command;
	}

	private Identifiable newIdentifiable(final String name) {
		return new Identifiable(){
			public String getIdentifier() {
				return name;
			}
			
		};
	}

	private IPresenterCommand newPresenterCommand(final Identifiable commandIdentifier) {

		return new IPresenterCommand() {
			
			private IPresenter presenter;

			public void execute() throws Exception {
				logger.debug(String.format("Invoke received, but method not yet implemented invoke [method=%s, identifier=%s]", "execute", commandIdentifier.getIdentifier()));				
			}
			
			public void setPresenter(IPresenter presenter) {
				this.presenter = presenter;				
			}
			
			public Identifiable getIdentifier() {
				return commandIdentifier;
			}
		};
		
	}

	public void testRegisterComponent() {
		fail("Not yet implemented");
	}

	public void testRegisterLabel() {
		fail("Not yet implemented");
	}

	public void testUnregisterComponent() {
		fail("Not yet implemented");
	}

	public void testUnregisterLabel() {
		fail("Not yet implemented");
	}

	public void testGetValue() {
		fail("Not yet implemented");
	}

	public void testSetValue() {
		fail("Not yet implemented");
	}

	public void testGetPresenterAttributeFor() {
		fail("Not yet implemented");
	}

	public void testGetPresenterCommandFor() {
		fail("Not yet implemented");
	}

	public void testGetComponentVisitor() {
		fail("Not yet implemented");
	}

	public void testGetLabelVisitor() {
		fail("Not yet implemented");
	}

	public void testGetRegisteredComponents() {
		fail("Not yet implemented");
	}

	public void testGetRegisteredLabels() {
		fail("Not yet implemented");
	}

	public void testGetPresenterAttributes() {
		fail("Not yet implemented");
	}

	public void testGetPresenterCommands() {
		fail("Not yet implemented");
	}

	public void testExecute() {
		IPresenterCommand cancelCommand = newCommand("Cancel");
		presenter.add(cancelCommand);
		presenter.execute(cancelCommand.getIdentifier().getIdentifier());
	}

	public void testIsAttributeManaged() {
		fail("Not yet implemented");
	}

	public void testIsCommandManaged() {
		presenter.add(newCommand("Create"));
		presenter.add(newCommand("Save"));
		presenter.add(newCommand("Insert"));
		presenter.add(newCommand("Update"));
		presenter.add(newCommand("Cancel"));
		assertTrue(presenter.isCommandManaged("Cancel"));
		assertTrue(presenter.isCommandManaged("Create"));
		assertTrue(presenter.isCommandManaged("Update"));
		assertFalse(presenter.isCommandManaged("RoundTrip"));
	}

	public void testGetMaskTrigger() {
		fail("Not yet implemented");
	}

	public void testGetModel() {
		fail("Not yet implemented");
	}

	public void testSetModel() {
		fail("Not yet implemented");
	}

}
