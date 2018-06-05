$(document).ready(function(){
	loadProductBatchView();
	
	$('#createUserForm').submit(function(){
		event.preventDefault();
		createUser();
		loadUsers();
		return false;
	})
})

	function loadProductBatchView(){
		$.ajax({
			url : '/23_Final/rest/productbatchviews',
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$.each(data, function(i, el){
					$('#productBatchViewTableBody').append(generateProductBatchViewHTML(el));
				})
			}
		})
	}
	
	function generateProductBatchViewHTML(ProductBatchViewDTO) {
		return '<tr><td>' + ProductBatchViewDTO.productBatchID + '</td>' +
				'<td>' + ProductBatchViewDTO.status + '</td>' +
				'<td>' + ProductBatchViewDTO.recipeID + '</td>' + 
				'<td>' + ProductBatchViewDTO.recipeName + '</td>' + '</tr>';
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
