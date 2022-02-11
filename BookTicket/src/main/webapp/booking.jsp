<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script type="text/javascript">
  $(function(){
	    var dtToday = new Date();
	    
	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	        day = '0' + day.toString();
	    
	    var maxDate = year + '-' + month + '-' + day;
	    $('#txtDate').attr('min', maxDate);
	});
</script>

</head>
<body>
Booking tickets
<h1>Available Seats are : </h1>${seats}
<form action="addbooking">

<label for="mname">Movie name</label>
<select name="mname" id="mname">
    <option value="A">A</option>
    <option value="B">B</option>
    <option value="C">C</option>
    <option value="D">D</option>
  </select><br>
  
<label for="type_m">Circle Type</label>
<select name="type_m" id="type_m">
    <option value="king">King</option>
    <option value="queen">Queen</option>
  </select><br> 

 Bookdate: <input type="date"  id="txtDate" name="dob" placeholder="Select suitable date" /><br>
  
  
<label for="show_m">Show Time</label>
<select name="show_m" id="show_m">
    <option value="morning">Morning</option>
    <option value="evening">Evening</option>
    <option value="1stshow">1st Show</option>
    <option value="2ndshow">2nd Show</option>
  </select><br>
  
  
Number Of Tickets:<input type=number name=ntickets><br>

<input type="submit">

</form>
</body>
</html>