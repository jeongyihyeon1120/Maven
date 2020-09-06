<html>
<body>

<table style="width:100%">
  <tr>
    <th>type</th>
    <th>name</th> 
    <th>addr</th>
 </tr>
 
 <#list message as i>
     <tr>
	   <td>${i.type}</td>
	   <td>${i.name}</td>
	   <td>${i.addr}</td>
	 </tr>
 </#list>

</body>
</html>
