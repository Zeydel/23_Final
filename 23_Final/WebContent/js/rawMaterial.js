$(document).ready(function(){
	loadRawMaterials()

})

function loadRawMaterials(){
	$.ajax({
		url : '/23_Final/rest/rawmaterial',
		type : 'GET',
		dataType : 'json',
		success : function(data){
			$.each(data, function(i, el){
				$('#rawMaterialTableBody').append(generateRawMaterialHTML(el));
			})
		}
	})
}

function generateRawMaterialHTML(RawMaterialDTO){
	return '<tr><td>' + RawMaterialDTO.rawMaterialID + '</td>' +
	'<td>' + RawMaterialDTO.rawMaterialName + '</td>' +
	'<td>' + RawMaterialDTO.supplier + '<td>' + '<button class="options" id="edituserbutton" onclick="location.href="> <i class="fas fa-edit"></i> </button>' +
	'<button class="options" onclick="deleteUser($(this).val())" value=""> <i class="fas fa-trash-alt"></i> </button>' + '</td>' + '</tr>' + '<tr>'
}