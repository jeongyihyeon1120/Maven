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
  	<th>flag</th>
    <th>locationNo1</th>
    <th>locationNo2</th>
    <th>predictTime1</th>
    <th>predictTime2</th>
    <th>remainSeatCnt1</th>
    <th>remainSeatCnt2</th>
 </tr>
 
 <#list message as i>
 	<tr>
	   <td>${i.flag?default("정보가 없습니다.")}</td>
	   <td>${i.locationNo1?default("정보가 없습니다.")}</td>
	   <td>${i.locationNo2?default("정보가 없습니다.")}</td>
	   <td>${i.predictTime1?default("정보가 없습니다.")}</td>
	   <td>${i.predictTime2?default("정보가 없습니다.")}</td>
	   <td>${i.remainSeatCnt1?default("정보가 없습니다.")}</td>
	   <td>${i.remainSeatCnt2?default("정보가 없습니다.")}</td>
	 </tr>
 </#list>

</body>
</html>