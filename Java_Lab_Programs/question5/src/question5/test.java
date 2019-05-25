package question5;

import java.util.*;
import java.util.Vector;
import java.io.*;
public class test
{
public static void main(String[] args)
{
try
{
File src = new File("sr");
File dst = new File("dst");
test.copyFile(src, dst);
System.out.println("File Copied!");
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
public static void copyFile(File src, File dst) throws IOException
{
try
{
InputStream in = new FileInputStream(src);
OutputStream out = new FileOutputStream(dst);
// Transfer bytes from in to out
long expectedBytes = src.length(); // This is the number of bytes we expected to copy..
long totalBytesCopied = 0; // This will track the total number of bytes we've copied
byte[] buf = new byte[1024];
int len = 0;
while ((len = in.read(buf)) > 0) {
out.write(buf, 0, len);
totalBytesCopied += len;
int progress = (int)Math.round(((double)totalBytesCopied / (double)expectedBytes) * 100);
System.out.print(progress+"%  ");
System.out.print("[");
for(int i=0;i<=len;i++)
{
System.out.print(">");
}
System.out.print("]\r");
}
System.out.println("");
in.close();
out.close();
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
}