package unusedScenarios;

class DemoAction 
{
	static int a=1;
	int b=2;
	static class ankit
	{
		static int c=3;
		public static void a()
		{
			System.out.println(a);
		}			
		public void b()
		{
			System.out.println(c);
		}
	}
	class aaa
	{
		public void c() {
			System.out.println(b);
		}
		public void d()
		{
			System.out.println(a);
		}
	}
}