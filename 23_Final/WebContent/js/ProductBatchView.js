$(document).ready(function(){
	loadProductBatchView();
	
	$('#createProductBatch').submit(function(){
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
				'<td>' + ProductBatchViewDTO.recipeName + '</td>' + 
				'<td>' + '<button class="options" id="editProductBatchButton" onclick="location.href=\'editProductBatchForm.html?id=' + ProductBatchViewDTO.productBatchID +'\'' + '"><i class="fas fa-edit"></i> </button>' +
				'<button class="options" onclick="deleteProductBatch($(this).val())" value="' + ProductBatchViewDTO.productBatchID + '"> <i class="fas fa-trash-alt"></i> </button>' + '</td>' + '</tr>';
	}
	
	function createProductBatch(){
		event.preventDefault();
		var data = $('#createProductBatch').serializeJSON();
		$.ajax({
			url : '/23_Final/rest/productbatchviews',
			type : 'POST',
			data: data,
			dataType : 'json',
			contentType : ("application/json"),
			success : function(data){
				
			}
		})
		location.href="ProductBatchTabel.html"
	}
	
	
	function deleteProductBatch(productBatchID){
		event.preventDefault();
		$.ajax({
			url : '/23_Final/rest/productbatchviews/' + productBatchID,
			type : 'DELETE',
			dataype : 'json',
			contentType : ("application/json"),
			success : function(){
				$('#productBatchViewTableBody').empty();
				loadProductBatchView();
			}
		})
	}
	
	function updateProductBatch(){
		var data = $('#editProductBatch').serializeJSON();
		$.ajax({
			url : '/23_Final/rest/productbatchviews/edit',
			type : 'POST',
			data : data,
			datatype : 'json',
			contentType : ("application/json"),
			success : function(){
			}
		})
	}
	
