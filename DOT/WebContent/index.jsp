<html>
<head>
<title>Spring MVC Tutorial Series by Crunchify.com</title>
<style type="text/css">
body {
background-image: url('http://crunchify.com/bg.png');
}
</style>
<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="http://github.highcharts.com/v3.0Beta/highcharts.js"></script>
<script src="http://github.highcharts.com/v3.0Beta/highcharts-more.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>

<link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>
<script>

$(function () {
    $.getJSON('http://www.highcharts.com/samples/data/jsonp.php?filename=range.json&callback=?', function(data) {
    
    	$('#container').highcharts({
    	
		    chart: {
		        type: 'arearange'
		    },
		    
		    title: {
		        text: 'Temperature variation by day'
		    },
		
		    xAxis: {
		        type: 'datetime'
		    },
		    
		    yAxis: {
		        title: {
		            text: null
		        }
		    },
		
		    tooltip: {
		        crosshairs: true,
		        shared: true,
		        valueSuffix: '°C'
		    },
		    
		    legend: {
		        enabled: false
		    },
		
		    series: [{
		        name: 'Temperatures',
		        data: data,
		        color: '#FF0000',
		        negativeColor: '#0088FF'
		    }]
		
		});
    });
    
    $('#container1').highcharts({
        xAxis: {
            plotBands: [{ // mark the weekend
                color: '#FCFFC5',
                from: Date.UTC(2006, 8, 3, 0, 48, 0),
                to: Date.UTC(2006, 8, 3, 0, 49, 45)
            }],
            tickInterval: 5*1000, // one day
            type: 'datetime'
        },

        series: [
                 {
            data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4],
            pointStart: Date.UTC(2006, 8, 3, 0, 48, 45),
         
            pointInterval: 5*1000
        },{
            data: [39.9, 81.5, 116.4, 139.2, 154.0, 186.0, 145.6, 158.5, 226.4],
            pointStart: Date.UTC(2006, 8, 3, 0, 48, 45),
         
            pointInterval: 5*1000
        }]
    });
    
   var data=[];

    data.push("09/02/2014 15:36:25","33.82, 33.42, 40.83");
    data.push("08/11/2014 16:25:15","36.6, 33.42, 40.45");
    data.push("07/30/2014 08:43:57","0.0, 0.0, 0.0");
    data.push("08/12/2014 22:00:52","77.99, 74.1, 80.12");
    
    
 /*   var data = {
            "09/02/2014 15:36:25": [33.82, 33.42, 40.83],
                "08/11/2014 16:25:15": [36.6, 33.42, 40.45],
                "07/30/2014 08:43:57": [0.0, 0.0, 0.0],
                "08/12/2014 22:00:52": [77.99, 74.1, 80.12],
                "08/12/2014 21:19:48": [56.91, 63.23, 52.42],
                "07/23/2014 13:37:46": [0.0, 0.0, 0.0],
                "08/11/2014 17:35:21": [40.9, 43.83, 38.34]
        };
*/
        var series = [{
            name: 'some name 1',
            data: []
        }, {
            name: 'some name 2',
            data: []
        }, {
            name: 'some name 3',
            data: []
        }],
            categories = [];
        
        
        for(var category in data) {
            var points = data[category];
            alert(points);
            categories.push(category);
            for(var i in points) {
                 series[i].data.push(points[i]);  
            }
        }

        var i = 7.0;
        $('#container2').highcharts({
            title: {
                text: 'Search Relevancy Graph',
                x: -20 //center
            },
            subtitle: {
                text: 'Source: WorldClimate.com',
                x: -20
            },
            xAxis: {
                categories: categories
            },
            yAxis: {
                title: {
                    text: 'Temperature (°C)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '°C'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: series
        });
    
});

</script>


</head>
<body>
<br>
<div class="container-fluid">
<div style="text-align:center">
<h2>
Charts<br> <br>
</h2>
</div>
</div>
<div id="container" style="height: 400px; width: 600px; margin: 0 auto"></div>
	
	<div id="container1" style="min-width: 310px; height: 400px; margin: 0 auto"></div>	
		<div id="container2" style="min-width: 310px; height: 400px; margin: 0 auto"></div>	
</body>
</html>