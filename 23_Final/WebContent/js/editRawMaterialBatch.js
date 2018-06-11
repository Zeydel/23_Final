$(document).ready(function(){
	var urr = window.location.href;
	
	console.log(typeof(URL));
	var URL2 = new URL(urr);
	var id = URL2.searchParams.get("id");
	console.log(id);
	getRawMaterialBatch(id);
	
	$('#editRawMaterialBatchForm').submit(function(){
		event.preventDefault();
		createRawMaterialBatch();
		location.href='RawMaterialBatchViewTabel.html';
	})
	
	$('#createRawMaterialBatchForm').submit(function(){
		event.preventDefault();
		updateRawMaterialBatch();
		location.href='RawMaterialBatchViewTabel.html';
	})
	
})

function getRawMaterialBatch(rawMaterialBatchID){
		$.ajax({
			url : '/23_Final/rest/rawMaterialBatch/' + rawMaterialBatchID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$('#rawMaterialBatchID').val(data.rawMaterialBatchID);
				$('#rawMaterialID').val(data.rawMaterialID);
				$('#rawMaterialName').val(data.rawMaterialName);
				$('#amount').val(data.amount);
			}
		})
	}

function updateRawMaterialBatch(){
	var data = $('#editRawMaterialBatchForm').serializeJSON();
	$.ajax({
		url : '/23_Final/rest/rawMaterialBatch/edit',
		type : 'POST',
		data : data,
		datatype : 'json',
		contentType : ("application/json"),
		success : function(){
		}
	})
}

function createRawMaterialBatch(){
	event.preventDefault();
	var data = $('#createRawMaterialBatchForm').serializeJSON();
	
	$.ajax({
		url : '/23_Final/rest/rawMaterialBatch',
		type : 'POST',
		data: data,
		dataType : 'json',
		contentType : ("application/json"),
		success : function(data){

		}
	})
	location.href="rawMaterialBatchView.html"
}