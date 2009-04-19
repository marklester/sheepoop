package sheep.view.util;

import sheep.model.gamemap.Direction;

public class DrawInfo{
	String id;
	Direction orientation;
	public DrawInfo(String id, Direction orientation)
	{
		this.id = id;
		this.orientation = orientation;
	}
	public String getId()
	{
		return id;
	}
	public Direction getOrientation()
	{
		return orientation;
	}
	@Override
	public String toString()
	{
		String result = "";
		result+=id;
		if(orientation!=null)
		{
			result+=orientation.toString();
		}
		return result;
	}
}
