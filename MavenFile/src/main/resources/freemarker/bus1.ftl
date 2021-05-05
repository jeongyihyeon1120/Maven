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
    <th>districtCd</th>
    <th>regionName 수</th> 
    <th>routeId</th>
    <th>routeName</th>
    <th>routeTypeCd</th>
    <th>routeTypeName</th>
 </tr>
 
 <#list message as i>
     <tr style="cursor:pointer;color:#blue;" onClick="window.open('http://localhost:45678/routeId/${i.routeId}','','');">
	   <td>${i.districtCd}</td>
	   <td>${i.regionName}</td>
	   <td>${i.routeId}</td>
	   <td>${i.routeName}</td>
	   <td>${i.routeTypeCd}</td>
	   <td>${i.routeTypeName}</td>
	 </tr>
 </#list>

</body>
</html>