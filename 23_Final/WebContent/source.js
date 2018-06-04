$(document).ready(function(){
	function loadUsers(){
		event.preventDefault();
		$.ajax({
			url : 'rest/users',
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
				'<td>' + UserDTO.roles + '</td>' + '</tr>';
	}
})