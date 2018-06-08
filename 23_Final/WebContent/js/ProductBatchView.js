$(document).ready(function(){
	loadProductBatchView();
	
	$('#confirmCreateProductBatch').submit(function(){
		event.preventDefault();
		createProductBatch();
		loadProductBatctView();
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
				'<td>' + ProductBatchViewDTO.recipeName + '</td>' + '<td>' + '<button class="options" id="edituserbutton" onclick="location.href="> <i class="fas fa-edit"></i> </button>' +
				'<button class="options" onclick="deleteUser($(this).val())" value=""> <i class="fas fa-trash-alt"></i> </button>' + '</td>' + '</tr>';
	}
	
	function createProductBatch(){
		event.preventDefault();
		var data = $('#createProductBatch').serializeJSON();
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
	
	
	function deleteProductBatch(value){
		event.preventDefault();
		$.ajax({
			url : '/23_Final/rest/users/' + value,
			type : 'DELETE',
			dataype : 'json',
			contentType : ("application/json"),
			success : function(){
				$('#productBatchViewTableBody').empty();
				loadUsers();
			}
		})
	}
	
	function updateProductBatch(){
		var data = $('#editProductBatch').serializeJSON();
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
	
