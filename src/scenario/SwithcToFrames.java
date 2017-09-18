package scenario;

/**
 * @author Ankit.Mittal
 *
 */
public class SwithcToFrames {

	public static void SwitchToFrame(String[] FrameID) 
	{
		BrowserSet.drivreturn().switchTo().frame(FrameID[0]);
	}
	public static void SwitchToDefault() 
	{
		BrowserSet.drivreturn().switchTo().defaultContent();
	}
	public static void SwitchToParentFrame() 
	{
		BrowserSet.drivreturn().switchTo().parentFrame();
	}

}
