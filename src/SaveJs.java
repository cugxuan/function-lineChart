import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveJs {
	/**
	 * 保存index.js文件
	 * @throws IOException 
	 */
	public static boolean initIndex(String fileName) throws IOException{
		File file = new File(fileName);
		//判断目标文件所在的目录是否存在
		if(!file.getParentFile().exists()){
			System.out.println("不存在"+fileName+"的目录,进行创建");
			if(!file.getParentFile().mkdirs()){
				System.out.println("创建目标文件目录失败");
				return false;
			}
		}
		//如果不存在则创建目标文件
		try {
			if(!file.exists()){
				if(!file.createNewFile()){
					return false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//调用writefunc写入js的函数内容
        writefunc(fileName);
        return true;
	}
	/**
	 * 写入js的函数部分
	 * @throws IOException 
	 */
	private static void writefunc(String fileName) throws IOException{
		FileWriter fw = new FileWriter(fileName,false);
        fw.write("function draw(name,xRange,yRange,xText,yText,data,scaleN){\n");
        fw.write("	document.writeln(name);\n");
        fw.write("	var width = 500,	height = 250,margin = {left:50,top:30,right:20,bottom:20},g_width = width - margin.left -margin.right,g_height = height -margin.top - margin.bottom;\n");
        fw.write("	var container = d3.select('body').append('container');\n");
        fw.write("	var svg = container.append('svg').attr('width',width).attr('height',height);\n");
        fw.write("var g = svg.append('g').attr('transform','translate('+margin.left+','+margin.top+')');\n");
        fw.write("var scale_x = d3.scaleLinear().domain([0,xRange]).range([0,g_width])\n");
        fw.write("	var scale_y = d3.scaleLinear().domain([0,yRange]).range([g_height,0])\n");
        fw.write("var line_generator = d3.line()\n");
        fw.write(".x(function(d,i){return scale_x(i)/scaleN;})\n");
        fw.write(".y(function(d){return scale_y(d);})\n");
        fw.write("g.append('path').attr('d',line_generator(data))\n");
        fw.write("	var x_axis =d3.axisBottom(scale_x),y_axis =d3.axisLeft(scale_y);\n");
        fw.write("g.append('g').call(x_axis).attr('transform','translate(0,'+g_height+')').append('text').text(xText).attr('dx','40em').attr('dy','-1em')\n");
        fw.write("g.append('g').call(y_axis).append('text').text(yText).attr('text-anchor','start').attr('dx','1em').attr('dy','1em')\n");
        fw.write("}\n\n");
        fw.close();
	}
	/**
	 * 必须初始化文件
	 * @param fileName  传入文件名
	 * @param name     网页显示的名字
	 * @param xRange   x轴的最大值
	 * @param yRange   y轴的最大值
	 * @param xText    x轴说明
	 * @param yText    y轴说明
	 * @param data     ArrayList数据
	 * @param scaleN   一个x单位有多少个数据
	 * @throws IOException
	 */
	public static void drawLineChart(String fileName,String name, int xRange, int yRange,String xText,String yText,ArrayList data,int scaleN) throws IOException{
		//使用true选项打开追加模式
		FileWriter fw = new FileWriter(fileName,true);
		fw.write("var data = "+data+"\n\n");
		fw.write("var xRange="+xRange+",yRange="+yRange+",name='<p>"+name);
		fw.write("</p>',xText='"+xText+"',yText='"+yText+"',scaleN="+scaleN+";\n");
		fw.write("draw(name,xRange,yRange,xText,yText,data,scaleN);\n");
        fw.close();
	}
	
}
