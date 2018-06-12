$(document).ready(function(){

	$('#loginContainer').submit(function(){
		event.preventDefault();
		var userID = getUser(document.getElementById("userID").value)
		

	})
})


function getUser(userID){
		$.ajax({
			url : '/23_Final/rest/users/' + userID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				if(data)
				}
		})

		
}
	