package scenario;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class methodFactory {

	static final Logger logger=Logger.getLogger(methodFactory.class);
	public static void methods(String[] SelectAction) throws Exception {
		PropertyConfigurator.configure("log4j.properties");

		String Action=SelectAction[1].toLowerCase();
		String pagelement=SelectAction[0];
		String value=SelectAction[2];
		
		switch (Action) {
		case "click":
			SetMethod.click(ReadProerties.propsObjectsSplit(pagelement));
			logger.info("click method has called");
			break;
			
		case "sendkey":
			SetMethod.sendkey(ReadProerties.propsObjectsSplit(pagelement),value);
			logger.info("sendkey method has called");
			break;
			
		case "enter":
			SetMethod.enter(ReadProerties.propsObjectsSplit(pagelement));
			logger.info("enter method has called");
			break;
			
		case "gettext":
			SetMethod.gettext(ReadProerties.propsObjectsSplit(pagelement));
			logger.info("gettext method has called");
			break;
			
		case "select":
			SetMethod.select(ReadProerties.propsObjectsSplit(pagelement));
			logger.info("select method has called");
			break;
			
		case "tooltip":
			SetMethod.tooltip(ReadProerties.propsObjectsSplit(pagelement));
			logger.info("tooltip method has called");
			break;
			
		case "takescreenshot":
			ScreenShot.takesanp();
			logger.info("takescreenshot method has called");
			break;
		
		case "scrolltoview":
			ScrollToView.Scrolling(ReadProerties.propsObjectsSplit(pagelement));
			logger.info("scrolltoview method has called");
			break;

		case "uploadfile":
			UploadFile.FileUpload(ReadProerties.propsObjectsSplit(pagelement));
			logger.info("uploadfile method has called");
			break;
		case "sleep":
			System.out.println(value);
			wait_time.sleep(value);
			logger.info("sleep has called");
			break;
			
			default:
				ScreenShot.takesanp();
				System.out.println(Action+"  sorry No method");
		}

	}
}
