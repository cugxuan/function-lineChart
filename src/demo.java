import java.io.IOException;
import java.util.ArrayList;

public class demo {
	public static void main(String []args) throws IOException{
		ArrayList data = new ArrayList();
		for( int i = 0; i< 60; i++){
			data.add(i);
		}
		System.out.println(data);
		
		SaveJs.initIndex("test/js/index.js");
		SaveJs.drawLineChart("test/js/index.js", "进程AEMgr", 60, 100, "时间(60分)", "CPU使用率(%)", data, 1);
		SaveJs.drawLineChart("test/js/index.js", "进程AEMgr", 60, 100, "时间(60分)", "CPU使用率(%)", data, 3);
	}
}
