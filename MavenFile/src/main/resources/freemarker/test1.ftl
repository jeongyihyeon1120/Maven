<html>
<body>

<table style="width:100%">
  <tr>
    <th>code</th>
    <th>created_at</th> 
    <th>remain_stat</th>
    <th>stock_at</th>
 </tr>
 
 <#list message as i>
     <tr>
	   <td>${i.code}</td>
	   <td>${i.created_at}</td>
	   <td>${i.remain_stat}</td>
	   <td>${i.stock_at}</td>
	 </tr>
 </#list>

</body>
</html>
