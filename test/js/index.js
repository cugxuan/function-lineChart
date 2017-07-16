function draw(name,xRange,yRange,xText,yText,data,scaleN){
	document.writeln(name);
	var width = 500,	height = 250,margin = {left:50,top:30,right:20,bottom:20},g_width = width - margin.left -margin.right,g_height = height -margin.top - margin.bottom;
	var container = d3.select('body').append('container');
	var svg = container.append('svg').attr('width',width).attr('height',height);
var g = svg.append('g').attr('transform','translate('+margin.left+','+margin.top+')');
var scale_x = d3.scaleLinear().domain([0,xRange]).range([0,g_width])
	var scale_y = d3.scaleLinear().domain([0,yRange]).range([g_height,0])
var line_generator = d3.line()
.x(function(d,i){return scale_x(i)/scaleN;})
.y(function(d){return scale_y(d);})
g.append('path').attr('d',line_generator(data))
	var x_axis =d3.axisBottom(scale_x),y_axis =d3.axisLeft(scale_y);
g.append('g').call(x_axis).attr('transform','translate(0,'+g_height+')').append('text').text(xText).attr('dx','40em').attr('dy','-1em')
g.append('g').call(y_axis).append('text').text(yText).attr('text-anchor','start').attr('dx','1em').attr('dy','1em')
}

var data = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59]

var xRange=60,yRange=100,name='<p>进程AEMgr</p>',xText='时间(60分)',yText='CPU使用率(%)',scaleN=1;
draw(name,xRange,yRange,xText,yText,data,scaleN);
var data = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59]

var xRange=60,yRange=100,name='<p>进程AEMgr</p>',xText='时间(60分)',yText='CPU使用率(%)',scaleN=3;
draw(name,xRange,yRange,xText,yText,data,scaleN);
