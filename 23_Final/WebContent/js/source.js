$(document).ready(function(){
	loadUsers();

	$('#createUserForm').submit(function(){
		event.preventDefault();
		createUser();
		loadUsers();
		return false;
	})
})

	function loadUsers(){
		$.ajax({
			url : '/23_Final/rest/users',
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$.each(data, function(i, el){
					$('#userTableBody').append(generateUserHTML(el));
				})
			}
		})
	}

	function generateUserHTML(UserDTO) {
		return '<tr><td>' + UserDTO.userID + '</td>' +
				'<td>' + UserDTO.userName + '</td>' +
				'<td>' + UserDTO.initials + '</td>' +
				'<td>' + UserDTO.password + '</td>' +
				'<td>' + UserDTO.cpr + '</td>' +
				'<td>' + UserDTO.roles + '</td>' +
				'<td>' + '<button class="options" onclick="" value="' + UserDTO.userID +'"> <i class="fas fa-trash-alt"></i> </button>' + '</td>' +'</tr>';
	}

	
	function createUser(){
		event.preventDefault();
		var data = $('#createUserForm').serializeJSON();
		$.ajax({
			url : '/23_Final/rest/users',
			type : 'POST',
			data: data,
			dataType : 'json',
			contentType : ("application/json"),
			success : function(data){

			}
		})
	}
	
    
