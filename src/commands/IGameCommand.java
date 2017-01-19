package commands;

public interface IGameCommand {

	public boolean execute();
	public void undo();
}
