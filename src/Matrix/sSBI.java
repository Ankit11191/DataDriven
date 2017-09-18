package Matrix;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import scenario.BrowserSet;
import scenario.ReadProerties;
import scenario.SetMethod;
import scenario.UploadFile;
import scenario.wait_time;

public class sSBI {

	public static void main(String[] args) throws Exception {
		BrowserSet.SelectBrowser();
		wait_time.ImplisitWait("30");
		SetMethod.sendkey(ReadProerties.propsObjectsSplit("Matrix->Login"),"UserID");
		SetMethod.sendkey(ReadProerties.propsObjectsSplit("Matrix->password"),"Password");
		SetMethod.click(ReadProerties.propsObjectsSplit("Matrix->lfnBtn"));
		SetMethod.click(ReadProerties.propsObjectsSplit("Matrix->Menu"));
		Actions action = new Actions(BrowserSet.drivreturn());

		action.moveToElement(
				SetMethod.select(ReadProerties
						.propsObjectsSplit("Main.Menu->BillImport"))).build()
				.perform();

		BrowserSet.drivreturn().switchTo()
				.frame("iframe_E_BILL_SELF_SERVICE_FILE_IMPORT");
		SetMethod.sendkey(ReadProerties
				.propsObjectsSplit("Matrix->SelectMapper->InputField"),"mapper_name");

		BrowserSet.drivreturn().findElement(By.id("ui-id-2")).click();

		for(int i=1;i<=7;i++)
		{
			wait_time.sleep("5");
			String filepath="file_path"+i;
			SetMethod.click(ReadProerties.propsObjectsSplit("Matrix->addfileBtn"));
			UploadFile.FileUpload(ReadProerties.propsObjectsSplit(filepath));
		
		}
		wait_time.explicit("5");
		SetMethod.click(ReadProerties
				.propsObjectsSplit("Matrix->AddFileNxtBtn"));

		System.out.println("complete");
	}

}
