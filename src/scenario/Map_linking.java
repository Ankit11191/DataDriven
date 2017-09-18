package scenario;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Map_linking {

	public static void main(String[] args) {
		
		Map<Object, String> hm=new HashMap<Object,String>();
	
		hm.put("1","ankit");
		hm.put("2", "ditya");
		hm.put("3","ankit");
		hm.put("4", "ditya");
		hm.put("5","@@@");
		hm.put("6", "/");
		hm.put("7","ankit");
		hm.put("8", "\\");
		hm.put("9","   ");
		hm.put("10", "");		
		
		Iterator<Map.Entry<Object, String>> itr=hm.entrySet().iterator();
		
		while(itr.hasNext())
		{
			Map.Entry<Object, String> me=itr.next();
			String k=(String) me.getKey();
			if(k!=null)
			{
				System.out.print(k.toString()+" - ");
			}			
			System.out.println(hm.get(k));
		}
	}

}
