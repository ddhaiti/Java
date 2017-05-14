//Dupuytren Derbey D'Haiti
//Network project
//Client class
package data;
import java.io.*;


public class datagramClient 
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		

	BufferedReader br = null;
	String frag = "";

	try 
	{
		String [] info = new String[8];
		int count = 0;
		String f = "C:/Users/Derbey/workspace/networks/src/data/input.txt";
		//String sCurrentLine;
		//String wholeText = "";
		br = new BufferedReader(new FileReader(f));

		while ((info[count] = br.readLine()) != null&& count<7) 
		{
			//System.out.println(info[count]);
			//wholeText += sCurrentLine;
			
			
			//System.out.println("Output: "+Integer.parseInt(info[count].substring(0,4),2));// convert binary to decimal
			
				
			count++;
		}
		
	
		//System.out.println(info[7]);
		datagram dg = new datagram(info,count); 
		
		/*System.out.println(dg.getVer());
		System.out.println(dg.getSource());
		System.out.println(dg.getDest());
		System.out.println(dg.chkSource());
		System.out.println(dg.chkDest());
		
		System.out.println(dg.getMtu());
		//dg.chkDest();
		//dg.chkSource();
		*/
		//System.out.println(dg.getYes());
		//System.out.println(dg.getDest());
		
		if (dg.getYes())
		{
			frag = dg.getVer()+", "+dg.getHlen()+", "+ dg.getSer()+", "+dg.getTLength()+"\r\n"+dg.getID()+", "+dg.getFlag()+", "+dg.getOff()+ "\n"
			+dg.getTTL()+", "+ dg.getPro()+", " +dg.getChkSum()+"\r\n"+dg.getSource()+"\n"+ dg.getDest()+"\r\n"+ dg.getOption()+", "
			+dg.getOptionLength()+", "+dg.getOptionPointer()+"\r\n"+ "Data Field: "+info[7];//+"\n"+dg.getOptionId();
		}
		
		System.out.println(frag);
		
		PrintWriter outputfile = new PrintWriter("C:/Users/Derbey/workspace/networks/src/data/output.txt");
		//replace your System.out.print("your output");
		    outputfile.print(frag);
		    outputfile.close(); 
	} 
	
	catch (IOException e) 
	{
		e.printStackTrace();
	} 
	
	finally 
	{
		try 
		{
			if (br != null)br.close();
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}
	 

}
}


