$(document).ready(function(){	
	var urr = window.location.href;
	
	console.log(typeof(URL));
	var URL2 = new URL(urr);
	var id = URL2.searchParams.get("id");
	console.log(id);
	getRecipeID(id);
	
	$('#editRecipeComponentForm').submit(function(){
		event.preventDefault();
		updateRecipeComponent();
		location.href="recipeComponentTable.html"
	})

	
})

function getRecipeID(value){
		$.ajax({
			url : '/23_Final/rest/recipeComponent/' + value,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$('#recipeID').val(data.recipeID);
				$('#rawMaterialID').val(data.rawMaterialID);
				$('#nom-netto').val(data.nom_netto);
				$('#tolerance').val(data.tolerance);
			}
		})
	}

function updateRecipeComponent(){
	var data = $('#editRecipeComponentForm').serializeJSON();
	$.ajax({
		url : '/23_Final/rest/recipeComponent/edit',
		type : 'POST',
		data : data,
		datatype : 'json',
		contentType : ("application/json"),
		success : function(){
			
		}

	})
	
}