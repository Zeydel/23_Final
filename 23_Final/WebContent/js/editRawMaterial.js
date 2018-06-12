$(document).ready(function(){
	var urr = window.location.href;
	
	console.log(typeof(URL));
	var URL2 = new URL(urr);
	var id = URL2.searchParams.get("id");
	console.log(id);
	getRawMaterial(id);
	
	$('#editRawMaterialForm').submit(function(){
		event.preventDefault();
		updateRawMaterial();
		location.href='rawMaterialTable.html';
	})
})

function getRawMaterial(rawMaterialID){
		$.ajax({
			url : '/23_Final/rest/rawmaterial/' + rawMaterialID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$('#rawMaterialID').val(data.rawMaterialID);
				$('#rawMaterialName').val(data.rawMaterialName);
				$('#supplier').val(data.supplier);
			}
		})
	}

function updateRawMaterial(){
	var data = $('#editRawMaterialForm').serializeJSON();
	$.ajax({
		url : '/23_Final/rest/rawmaterial/edit',
		type : 'POST',
		data : data,
		datatype : 'json',
		contentType : ("application/json"),
		success : function(){
		}
	})
}