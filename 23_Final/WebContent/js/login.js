$(document).ready(function(){

	$('#loginContainer').submit(function(){
		alert("test")
;
		 var url = "/23_Final/rest/users/validate"; // the script where you handle the form input.

		    $.ajax({
		           type: "POST",
		           url: url,
		           data: $("#loginContainer").serialize(), // serializes the form's elements.
		           success: function(data)
		           {
		               alert(data.userID); // show response from the php script.
		           }
		         });

		    e.preventDefault(); // avoid to execute the actual submit of the form.
		
		
	})

	
})


function getUser(userID){
	
}