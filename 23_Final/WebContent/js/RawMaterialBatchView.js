$(document).ready(function(){
	loadRawMaterialBatchViews();
	
	
	
})

	function loadRawMaterialBatchViews(){
		$.ajax({
			url : '/23_Final/rest/rawMaterialBatch',
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$.each(data, function(i, el){
					$('#rawMaterialBatchView').append(generateRawMaterialBatchViewHTML(el));
				})
			}
		})
	}
	
	function generateRawMaterialBatchViewHTML(RawMaterialBatchViewDTO){
		return '<tr><td>' + RawMaterialBatchViewDTO.rawMaterialBatchID + '</td>' +
				'<td>' + RawMaterialBatchViewDTO.rawMaterialID + '</td>' +
				'<td>' + RawMaterialBatchViewDTO.rawMaterialName + '</td>' +
				'<td>' + RawMaterialBatchViewDTO.amount + '</td>' + 
				'<td>' + '<button class="options" id="editRecipeButton" onClick="location.href=\'editRawMaterialBatch.html?id=' + RawMaterialBatchViewDTO.rawMaterialBatchID +'\'' + '"> <i class="fas fa-edit"></i> </button>' +
				'<button class="options" onclick="deleteRawMaterialBatch($(this).val())" value="' + RawMaterialBatchViewDTO.rawMaterialBatchID + '"> <i class="fas fa-trash-alt"></i> </button>' + '</td>' + '</tr>';

	}
	
	function deleteRawMaterialBatch(value){
		event.preventDefault();
		$.ajax({
			url : '/23_Final/rest/rawMaterialBatch/' + value,
			type : 'DELETE',
			dataype : 'json',
			contentType : ("application/json"),
			success : function(){
				$('#rawMaterialBatchView').empty();
				loadRawMaterialBatchViews();
			}
		})
	}
	
	
	
