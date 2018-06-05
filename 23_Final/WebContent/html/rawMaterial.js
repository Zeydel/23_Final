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
	'<td>' + RawMaterialDTO.supplier + '</td><td>'
}