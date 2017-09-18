package amazon;

import scenario.BrowserSet;
import scenario.ReadProerties;
import scenario.ScrollToView;
import scenario.SetMethod;
import scenario.UploadFile;

public class naukari {

	public static void main(String[] args) throws Exception {
		BrowserSet.SelectBrowser();

		SetMethod.click(ReadProerties.propsObjectsSplit("Nakuri->LoginElemant"));
		
		SetMethod.sendkey(ReadProerties.propsObjectsSplit("Nakuri->emailElemant"), "mittal.ankit91@gmail.com");
		SetMethod.sendkey(ReadProerties.propsObjectsSplit("Nakuri->pwdelemant"), "Ankit@123");
		SetMethod.click(ReadProerties.propsObjectsSplit("Nakuri->lgnbtnelemant"));
		
		ScrollToView.Scrolling(ReadProerties.propsObjectsSplit("Nakuri->viewAndUpdateProfile"));
		SetMethod.click(ReadProerties.propsObjectsSplit("Nakuri->viewAndUpdateProfile"));
		
		ScrollToView.Scrolling(ReadProerties.propsObjectsSplit("Nakuri->UplaodLinkElement"));
		SetMethod.click(ReadProerties.propsObjectsSplit("Nakuri->UplaodLinkElement"));
		
		SetMethod.click(ReadProerties.propsObjectsSplit("Nakuri->attachCV"));
		System.out.println("check");
		UploadFile.FileUpload(ReadProerties.propsObjectsSplit("uploadFilePath"));
		System.out.println("check2");
//		wait_time.sleep("10");
		SetMethod.click(ReadProerties.propsObjectsSplit("Nakuri->UploadsaveBtn"));
		



	}

}
