$(document).ready(function(){

	$('#loginContainer').submit(function(){
		event.preventDefault();
		location.href="menu.html?id" + $("#userID").val();
	})

	
})


function getUser(userID){
		$.ajax({
			url : '/23_Final/rest/users/' + userID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
			}
		})
		location.href="menu.html"
	}