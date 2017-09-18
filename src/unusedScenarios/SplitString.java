package unusedScenarios;

import org.testng.annotations.Test;

import scenario.DataProivder;
import scenario.ReadProerties;

public class SplitString extends DataProivder {

	@Test(dataProvider="DataProvider")
	public static void read(String aaa,String bbb,String ccc)
	{		
//		DataProivder.dataProvider(ReadProerties.propsObjectsSplit("DataProviderSheet"));
		System.out.println(aaa);
		System.out.println(bbb);
		System.out.println(ccc);
	}

}