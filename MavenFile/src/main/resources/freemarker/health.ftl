<html>
<body>


<table>
  <tr>
    <th>시군구</th>
    <th>환자 수</th> 
    <th>병명</th>
 </tr>
 
 <#list message as i>
     <tr>
	   <td>${i.county}</td>
	   <td>${i.patientNum}</td>
	   <td>${i.diseaseName}</td>
	 </tr>
 </#list>

</body>
</html>