$(document).ready(function(){
	loadProductBatchComponent();
	
})

	function loadProductBatchComponent(){
		$.ajax({
			url : '/23_Final/rest/ProductBatchComponent',
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$.each(data, function(i, el){
					$('#TableBody').append(generateProductBatchComponentHTML(el));
				})
			}
		})
	}
	
	function generateProductBatchComponentHTML(ProductBatchComponentDTO){
		return '<tr><td>' + ProductBatchComponentDTO.productbatchID + '</td>' +
				'<td>' + ProductBatchComponentDTO.rawMaterialID + '</td>'+
				'<td>' + ProductBatchComponentDTO.tara + '</td>'+
				'<td>' + ProductBatchComponentDTO.netto + '</td>'+
				'<td>' + ProductBatchComponentDTO.userID + '</td>' + '<td>' + '<button class="options" id="edituserbutton" onclick="location.href="> <i class="fas fa-edit"></i> </button>' +
				'<button class="options" onclick="deleteUser($(this).val())" value=""> <i class="fas fa-trash-alt"></i> </button>' + '</td>' + '</tr>';

	}