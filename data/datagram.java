//Dupuytren Derbey D'Haiti
//datagram class
package data;

public class datagram 
{
	String [] str;
	boolean sYes = true;
	boolean dYes = true; 
	int loc;
	String sourceIp;
	String destIp;
	int [] mask  = {255,186,170,85};
	int [][] routingTable = {{110,48,32,80,1,1500,110,49,32,80},
							{110,32,32,80,2,256,110,33,32,80},
							{110,48,32,68,3,512,110,49,32,68},
							{110,18,40,17,4,256,110,19,41,17},
							{110,18,40,21,5,1500,110,23,40,17},
							{110,18,40,20,6,1500,110,19,40,17},
							{110,48,32,69,7,256,110,49,33,70},
							{110,32,32,64,7,512,110,49,33,70},
							{110,48,32,64,8,512,110,49,33,80},
							{110,32,32,69,9,256,110,36,32,80},
							{110,24,40,64,9,256,110,36,32,80},
							{110,24,40,80,9,512,110,36,32,80},
							{110,32,32,68,10,512,110,37,32,82},
							{110,24,40,68,10,256,110,37,32,82},
							{110,18,40,16,10,512,110,37,32,82}};
	
	public datagram (String [] s, int length)
	{	
		//str = s;
		
		str = new String [length];
		for (int i = 0; i<length;i++)
		{
			str[i]= s[i]; 
		}
	}
	
	public String getVer()
	{
		return "Vers = " + Integer.parseInt(str[0].substring(0,4),2); 
	}
	
	public String getHlen()
	{
		return "HLEN = " + Integer.parseInt(str[0].substring(4,8),2); 
	}
	
	public String getSer()
	{
		return "Service = " + Integer.parseInt(str[0].substring(8,16),2); 
	}
	
	public String getTLength()
	{
		return "Tot.Length = " + Integer.parseInt(str[0].substring(16,32),2); 
	}
	
	public String getID()
	{
		return "Identif = " +Integer.parseInt(str[1].substring(0,16),2); 
	}
	
	public String getFlag()
	{
		return "Flag = " + Integer.parseInt(str[1].substring(16,24),2); 
	}
	public String getOff()
	{
		return "Fragment Offset = " + Integer.parseInt(str[1].substring(24,32),2);
	}
	public String getTTL()
	{
		return "TTL = " + Integer.parseInt(str[2].substring(0,8),2);
	}
	public String getPro()
	{
		return"Protocol = TCP";
	}
	
	public String getChkSum()
	{
		return "Checksum = " + Integer.parseInt(str[2].substring(16,32),2);
	}
	
	public String getSource()
	{
		sourceIp = "";
		int y = 8;
		int x = 0;
		for (int i = 0; i<4;i++)
		{
			
			
			sourceIp += Integer.parseInt(str[3].substring(x,y),2)+ ".";
			x += 8;
			y += 8;
		}
		sourceIp = sourceIp.substring(0,sourceIp.length()-1);
		
		return "Source Address: " + sourceIp;
	}
	
	public String chkSource()
	{
		String sourceChk = "";
		for (int i = 0; i<15;i++)
		{
			sourceChk = "";
			for (int j = 0; j<4; j++)
				{
					if (sourceChk==sourceIp + ".")
					{
						
						sYes = true;
						break;
					}
					else 
					{
						sourceChk += Integer.toString(routingTable[i][j]) + ".";
						//sYes = false;
						//break;
					}
				}
			if (sourceChk ==sourceIp + ".")
			{
				loc = i;
				sYes = true;
				break;
			}
			else
			{
				return "unkown source";
			}
			//source
		}
		sourceChk = sourceChk.substring(0,sourceChk.length()-1);
		//if (sourceChk.equals(sourceIp))
			//return sourceChk;
		//else
		
		//System.out.print(yes);
		//System.out.print(sourceChk);
		
			return sourceChk;
	}
	public String getDest()
	{
		destIp = "";
		
		int y = 8;
		int x = 0;
		for (int i = 0; i<4;i++)
		{
			
			
			destIp += Integer.parseInt(str[4].substring(x,y),2)+ ".";
			
			x += 8;
			y += 8;
		}
		destIp =  destIp.substring(0,destIp.length()-1);
		return "Destin. Address: "+destIp;
	}
	
	public String chkDest()
	{
		String destChk = "";
		for (int i = 0; i<1;i++)
		{
			destChk = "";
			for (int j = 6; j<10; j++)
				{
					if (destChk==destIp + ".")
					{
						
						dYes = true;
						break;
					}
					else 
					{
						destChk += Integer.toString(routingTable[i][j]) + ".";
						//dYes = false;
						//yes = true;
						//break;
					}
					//destChk = "";
				}
			if (destChk == destIp + ".")
			{
				
				dYes = true;
				break;
			}
			else
			{
				return "unknown destination";
			}
			//source
		}
		destChk = destChk.substring(0,destChk.length()-1);
		//if (sourceChk.equals(sourceIp))
			//return sourceChk;
		//else
		
		//System.out.print(yes);
		//System.out.print(sourceChk);
		
			return destChk;
	}
	public boolean getYes()
	{
		if (chkDest().equals(destIp))
			dYes = true;
		if (chkSource().equals(sourceIp))
			sYes = true;
		//System.out.println(dYes);
		//System.out.println(sYes);
		return dYes&&sYes;
	}
	
	public boolean equals(Object o)
	{
		if (this==o) 
			return true;
		else 
			return false;
	}
	public String getOption()
	{
		return "Option = "  + Integer.parseInt(str[5].substring(0,8),2);
	}
	
	public String getOptionLength()
	{
		return "Opt.Length = "+ Integer.parseInt(str[2].substring(8,16),2);
	}
		
	public String getOptionPointer()
	{
		return "Pointer = " +  Integer.parseInt(str[2].substring(16,24),2);
	}
	/*public String getOPtionIp()
	{
		return "Opt.IP"
	}*/
	public int getMtu()
	{
		int mtu = 0;
		if (getYes() && loc<10)
			{
				mtu = routingTable[loc][5];
			}
		return mtu;
	}
}
