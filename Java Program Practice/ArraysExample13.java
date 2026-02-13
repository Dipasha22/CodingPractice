
public class ArraysExample13 {
   



	public static void main(String[] args) {
		int []a={4,5,6,7,8,5,6,8,9,4,10};
		boolean []b= new boolean[a.length];

		for(int i=0;i<a.length;i++)
		{
			if(b[i]) continue;
			int cnt=1;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]==a[j])
				{
					cnt++;
					b[j] = true;
				}
			}
		// System.out.println(a[i]+": "+cnt);  // frequency

		 // System.out.print(a[i]+" ");   //distinct



			// if(cnt==1)  //unique
			// System.out.print(a[i]+" ");

				if(cnt>1)    // duplicate
			System.out.print(a[i]+" ");
			

		}
	}
	


}
