package com.mycompany.myapp7;

import android.app.*;
import android.os.*;
import java.io.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		//在安卓外部存储卡读取一个文本，读取后将每一行的数乘以2写入另一个文本
		String path0=Environment.getExternalStorageDirectory().getAbsolutePath()+"/directory/";
		String name0="text1.txt";
		File path1=new File(path0);
		if(!path1.exists()){
			
			path1.mkdir();
			
		}
		
		
		File file0=new File(path0+name0);
		File file1=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Formoney/text1.txt");
		
		
		
		try
		{
			BufferedOutputStream os1=new BufferedOutputStream(new FileOutputStream(file0));
			BufferedWriter writer1=new BufferedWriter(new OutputStreamWriter(os1,"utf-8"),5*1024*1024);
			
			
		

		if(file1.exists()){
			
			try{
				BufferedInputStream bufferedinputstream1=new BufferedInputStream(new FileInputStream(file1));
				try{
					BufferedReader bufferdreader1=new BufferedReader(new InputStreamReader(bufferedinputstream1,"utf-8"),5*1024*1024);
					String line1="";
				
					
					try{
						while((line1=bufferdreader1.readLine())!=null){
							
							
							writer1.write(String.valueOf(2*Integer.valueOf(line1)));
							writer1.newLine();
							writer1.flush();
							
							
							
							
							
						}
						
						bufferdreader1.close();
						bufferedinputstream1.close();
						
						
					}catch(IOException e){
						
						
					}
					
					
					
				}catch(UnsupportedEncodingException e){
					
					
				}
				
				
			}catch(FileNotFoundException e){
				
				
			}
			
			
		}
		writer1.close();
		os1.close();
		}
		catch (IOException e)
		{}
    }
}
