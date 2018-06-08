$(document).ready(function(){
var urr = window.location.href;
	
	console.log(typeof(URL));
	var URL2 = new URL(urr);
	var id = URL2.searchParams.get("id");
	console.log(id);
	getProductBatch(id);
	
	$('#editProductBatchForm').submit(function(){
		event.preventDefault();
		udpateProductBatch();
	})
	
})

function getProductBatch(productBatchID){
		$.ajax({
			url : '/23_Final/rest/productbatchviews/' + productBatchID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$('#productBatchID').val(data.productBatchID);
				var status = data.status
				if(status = 'Not Started'){
					$('#status').val(0);
				} else if(status = 'In Progres'){
					$('#status').val(1);
				} else if(status = 'Completed'){
					$('#status').val(2);
				}
				//$('#status').val(data.status);
				$('#recipeID').val(data.recipeID);
			}
		})
	}

function udpateProductBatch(){
	var data = $('#editProductBatchForm').serializeJSON();
	$.ajax({
		url : '/23_Final/rest/productbatchviews/edit',
		type : 'POST',
		data : data,
		datatype : 'json',
		contentType : ("application/json"),
		success : function(){
		}
	})
}