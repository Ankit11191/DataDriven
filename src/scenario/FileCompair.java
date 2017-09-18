package scenario;


public class FileCompair {

	public static void main(String[] args) {
		System.out.println(SetDBconnection.getStatement());
		SetDBconnection.Readgetdata(ReadProerties.propsObjectsSplit("Query"));
	}
}
