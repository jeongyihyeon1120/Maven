<html>
<body>

<table style="width:100%">
  <tr>
    <th>id</th>
    <th>category</th> 
    <th>date</th>
    <th>title</th>
    <th>script</th>
 </tr>
 
 <#list message as i>
     <tr>
	   <td>${i.id}</td>
	   <td>${i.category}</td>
	   <td>${i.date}</td>
	   <td>${i.title}</td>
	   <td>${i.script}</td>
	 </tr>
 </#list>

</body>
</html>
