document.addEventListener('DOMContentLoaded',function(){
	var urr = window.location.href;
	
	console.log(typeof(URL));
	var URL2 = new URL(urr);
	var id = URL2.searchParams.get("id");
	console.log(id);
	getUser(id);
	
	$('#editUserForm').submit(function(){
		event.preventDefault();
		updateUser();
	})
})

function updateUser(){
		var data = $('#editRecipeForm').serializeJSON();
		$.ajax({
			url : '/23_Final/rest/recipes/edit',
			type : 'POST',
			data : data,
			datatype : 'json',
			contentType : ("application/json"),
			success : function(){
			}
		})
		location.href="user-tabel.html"
	}