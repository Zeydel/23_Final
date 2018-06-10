$(document).ready(function(){
	loadRawMaterials()

	$('#createRawMaterialForm').submit(function(){
		event.preventDefault();
		createUser();
		loadUsers();
		return false;
	})
	
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

function deleteRawMaterial(value){
	event.preventDefault();
	$.ajax({
		url : '/23_Final/rest/rawmaterial/' + value,
		type : 'DELETE',
		dataype : 'json',
		contentType : ("application/json"),
		success : function(){
			$('#rawMaterialTableBody').empty();
			loadRawMaterials();
		}
	})
}

function generateRawMaterialHTML(RawMaterialDTO){
	return '<tr><td>' + RawMaterialDTO.rawMaterialID + '</td>' +
	'<td>' + RawMaterialDTO.rawMaterialName + '</td>' +
	'<td>' + RawMaterialDTO.supplier + '</td>'+ '<td>' + '<button class="options" id="edituserbutton" onclick="location.href=""> <i class="fas fa-edit"></i> </button>' +
	'<button class="options" onclick="deleteRawMaterial($(this).val())" value="' + RawMaterialDTO.rawMaterialID + '"> <i class="fas fa-trash-alt"></i> </button>' + '</td>' + '</tr>';
}