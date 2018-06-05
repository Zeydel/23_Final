$(document).ready(function(){
	loadRawMaterialBatchViews();
	
})

	function loadRawMaterialBatchViews(){
		$.ajax({
			url : '/23_Final/rest/rawMaterialBatchView',
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$.each(data, function(i, el){
					$('#rawMaterialBatchView').append(generateRecipeHTML(el));
				})
			}
		})
	}
	
	function generateRawMaterialBatchViewHTML(RawMaterialBatchViewDTO){
		return '<tr><td>' + RawMaterialBatchViewDTO.rawMaterialBatchID + '</td>' +
				'<td>' + RawMaterialBatchViewDTO.rawMaterialID + '</td>';
				'<td>' + RawMaterialBatchViewDTO.rawMaterialName + '</td>';
				'<td' + RawMaterialBatchViewDTO.amount + '</td>';
				'<td>' + RawMaterialBatchViewDTO.supplier + '</td>';

	}
