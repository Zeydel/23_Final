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
				'<td>' + '<button class="options" id="edituserbutton" onclick="location.href=\'editUserForm.html?id=' + UserDTO.userID +'\'' + '"> <i class="fas fa-edit"></i> </button>' +
				'<button class="options" onclick="deleteUser($(this).val())" value="' + UserDTO.userID +'"> <i class="fas fa-trash-alt"></i> </button>' + '' + '</td>' +'</tr>';
	}
	
	function getUser(userID){
		$.ajax({
			url : '/23_Final/rest/users/' + userID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$('#userID').val(data.userID);
				$('#userID').value = data.userID;
				$('#userName').val(data.userName);
				$('#initials').val(data.initials);
				$('#password').val(data.password);
				$('#repeat_password').val(data.password);
				$('#cpr').val(data.cpr);
			}
		})
	}
	
	
	function createUser(){
		event.preventDefault();
		var roles = [];
		$("input:checkbox[name=roles]:checked").each(function(){
			roles.push($(this).val());
		})
		$('#roles').value=roles;
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
	
	function deleteUser(value){
		event.preventDefault();
		$.ajax({
			url : '/23_Final/rest/users/' + value,
			type : 'DELETE',
			dataype : 'json',
			contentType : ("application/json"),
			success : function(){
				$('#userTableBody').empty();
				loadUsers();
			}
		})
	}
	
	function updateUser(){
		var data = $('#editUserForm').serializeJSON();
		$.ajax({
			url : '/23_Final/rest/users/edit',
			type : 'POST',
			data : data,
			datatype : 'json',
			contentType : ("application/json"),
			success : function(){
			}
		})
	}
	
    
