<html>
<body>

<table style="width:100%">
  <tr>
    <th>이름</th>
    <th>주소</th> 
    <th>재고상태</th>
 </tr>
 
 <#list message as i>
     <tr>
	   <td>${i.name}</td>
	   <td>${i.addr}</td>
	   <td>${i.remain_stat}</td>
	 </tr>
 </#list>

</body>
</html>