$(document).ready(function(){

	$('#loginContainer').submit(function(){
		var userID = getUser(document.getElementById("userID").value)
		

	})
})


function getUser(userID){

		$.ajax({
			url : '/23_Final/rest/users/' + userID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				alert("hej");
				document.getElementById("message").innerHTML = data;
				event.preventDefault();
				}
		})
		alert("test");

		
}
	