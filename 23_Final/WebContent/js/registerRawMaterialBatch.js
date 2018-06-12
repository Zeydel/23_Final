$(document).ready(function(){
	
	
	$('#createRawMaterialBatchForm').submit(function(){
		event.preventDefault();
		createRawMaterialBatch();
		location.href='RawMaterialBatchViewTabel.html';
	})
	
})


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
			//location.href="rawMaterialBatchView.html"
		}
	})

}