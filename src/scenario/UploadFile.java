package scenario;

public class UploadFile {

	public static void FileUpload(String[] filepath) throws Exception {
		Runtime.getRuntime().exec(
				".\\OursourceObject\\ankit.exe "+filepath[0]);
	}

}
