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
					$('#PBCTableBody').append(generateProductBatchComponentHTML(el));
				})
			}
		})
	}
	
	function generateProductBatchComponentHTML(ProductBatchComponentDTO){
		return '<tr><td>' + ProductBatchComponentDTO.productbatchID + '</td>' +
				'<td>' + ProductBatchComponentDTO.rawMaterialBatchID + '</td>'+
				'<td>' + ProductBatchComponentDTO.tara + '</td>'+
				'<td>' + ProductBatchComponentDTO.netto + '</td>'+
				'<td>' + ProductBatchComponentDTO.userID + '</td>' + '</tr>';

	}