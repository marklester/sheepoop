package sheep.model.entities.npc.ai;

import java.io.Serializable;

import sheep.model.Time;
import sheep.model.TimeObserver;
import sheep.model.entities.npc.NPC;

public class SleepState implements TimeObserver, Serializable
{
	private static final long serialVersionUID = 6705895317084405268L;
	private AI sleeper;
	private int ticks;
	public SleepState(int ticks, NPC n)
	{
		sleeper = n.getActiveAi();
		this.ticks = ticks;
		Time.getInstance().removeObserver(sleeper);
		Time.getInstance().registerObserver(this);
	}
	@Override
	public void tick()
	{
		if(ticks >= 0)
		{
			ticks--;
		}
		else
		{
			Time.getInstance().registerObserver(sleeper);
			Time.getInstance().removeObserver(this);
		}
	}

}
