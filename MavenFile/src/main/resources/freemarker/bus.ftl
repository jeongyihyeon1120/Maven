<html>
<head>

<script>
setTimeout(function(){
location.reload();
},3000); // 3000밀리초 = 3초
</script>

</head>
<style>
table {
   	  width:100%;
	}
	table, th, td {
  	  border: 1px solid black;
  	  border-collapse: collapse;
	}
	th, td {
  	  padding: 15px;
  	  text-align: center;
	}
</style>


<body>

<table>
  <tr>
  	<th>정류소 정보</th>
    <th>plateNo</th>
    <th>remainSeatCnt</th>
 </tr>
 
 <#list message as i>
 	<tr style="cursor:pointer;color:#blue;" onClick="window.open('http://localhost:45678/${i.routeId}/${i.stationId}/${i.stationSeq}','','');">
	   <td>${i.stationName}</td>
	   <td>${i.plateNo?default("")}</td>
	   <td>${i.remainSeatCnt?default("")}</td>
	 </tr>
 </#list>

</body>
</html>