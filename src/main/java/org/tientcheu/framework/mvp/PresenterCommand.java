package org.tientcheu.framework.mvp;

import org.apache.log4j.Logger;
import org.tientcheu.framework.mvp.api.IPresenter;
import org.tientcheu.framework.mvp.api.IPresenterCommand;

public class PresenterCommand<T extends IPresenter> implements IPresenterCommand {
	
	private final T presenter;
	private final String commandIdentifier;

	private static final Logger LOGGER = Logger.getLogger(PresenterCommand.class);
	
	@SuppressWarnings("rawtypes")
	public PresenterCommand(String commandIdentifier, T presenter){
		assert(commandIdentifier != null);
		assert(presenter != null);
		this.commandIdentifier = commandIdentifier;
		this.presenter = presenter;
		this.presenter.registerCommand(this);
	}
	
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		LOGGER.debug("Command not yet implement : " + commandIdentifier);
	}

	@Override
	public IPresenter getPresenter() {
		return presenter;
	}

	@Override
	public String getIdentifier() {
		return commandIdentifier;
	}

}
