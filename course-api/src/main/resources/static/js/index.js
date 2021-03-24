
		$("#saveEmp").click(function () 
	{
		
			empDetails();
	});

function empDetails()
{	
	

	
	
var	empId = $("#empId").val();
var	firstName = $("#firstName").val();
var	lastName = $("#lastName").val();
var	city = $("#city").val();
var	age = $("#age").val();
var	salary = $("#sal").val();
var	department =  $("#department").val();

	
    var staff = {};    
    
    staff["empId"] = empId;
    staff["firstName"] = firstName;
    staff["lastName"] = lastName;
    staff["city"] = city;
    staff["age"] = age;
    staff["salary"] = salary;
    staff["department"] = department;
    
 //  alert(salary+" "+department);

        
		$.ajax({
            url : "/saveemployee",
            contentType: "application/json",
            type: 'POST',
            //async: false,
            data: JSON.stringify(staff),
    		success : function(data)
    		{
            	alert("Employee Added Successfully");
            	location.reload();
    		},
    		error : function(e)
    		{
            	alert("something went to wrong,. try again... ",e);
    		}
        });

  /*  function(err)
    {
      return alert("something went to wrong,. try again...", err);
    });
*/
		
}

//
function getEmpList()
{
	var table = $('#EmpListTable').DataTable({
		"sAjaxSource": "/EmployeeListForReport",
		"sAjaxDataProp": "",
		"order": [[ 0, "asc" ]],
		"aoColumns": [
		  { "mData": "empId"},
	      { "mData": "firstName" },
	      { "mData": "lastName" },
	      { "mData": "city" },
	      { "mData": "age" },
	      { "mData": "salary" },
	      { "mData": "department" },
		]
 });
}

//

function getEmployeeDetails()
{
	var employeeIdFromSelect = $('#EmployeeFromSelectToUpdate').val();
	
	$.ajax({
		"type" : "POST",
        "url" : "getEmployeeDetails",
        "async" : true,
        "data" :
        {
            "employeeIdFromSelect" : employeeIdFromSelect,
        },
            success: function (data)
            {            	
            	$.each(data, function(index, value)
            	{            		
                    
                    document.getElementById("empId1").value = value.empId;
                    document.getElementById("firstName1").value = value.firstName;
                    document.getElementById("lastName1").value = value.lastName;
                    document.getElementById("city1").value = value.city;
                    document.getElementById("age1").value = value.age;
                    document.getElementById("salary1").value = value.salary;
                    document.getElementById("department1").value = value.department;
                    
                    

            	});
            },
            error : function() {
                alert("error");
            }
	});
}

//
function updateEmployee()
{
	var	empId = $("#empId1").val();
	var	firstName = $("#firstName1").val();
	var	lastName = $("#lastName1").val();
	var	city = $("#city1").val();
	var	age = $("#age1").val();
	var	salary = $("#salary1").val();
	var	department =  $("#department1").val();

		
	    var staff = {};    
	    
	    staff["empId"] = empId;
	    staff["firstName"] = firstName;
	    staff["lastName"] = lastName;
	    staff["city"] = city;
	    staff["age"] = age;
	    staff["salary"] = salary;
	    staff["department"] = department;

$.ajax({
    url : "/updateEmployeeDetails",
    contentType: "application/json",
    type: 'PUT',

    data: JSON.stringify(staff),
	success : function(data)
	{
    	alert("Employee Updated Successfully");
    	location.reload();
	},
	error : function(e)
	{
    	alert("something went to wrong,. try again... ",e);
	}
});

    

}