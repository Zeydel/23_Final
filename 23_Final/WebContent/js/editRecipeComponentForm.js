$(document).ready(function(){
	$('#editRecipeForm').submit(function(){
		event.preventDefault();
		updateRecipeComponent();
	})
})

function getRecipe(value){
		$.ajax({
			url : '/23_Final/rest/recipeComponent/' + value,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$('#recipeID').val(data.recipeID);
				$('#rawMaterialID').val(data.rawMaterialID);
				$('#nom-netto').val(data.nom-netto);
				$('#tolerance').val(data.tolerance);
			}
		})
	}

function updateRecipeComponent(){
	var data = $('#editRecipeComponentForm').serializeJSON();
	$.ajax({
		url : '/23_Final/rest/recipes/edit',
		type : 'POST',
		data : data,
		datatype : 'json',
		contentType : ("application/json"),
		success : function(){
		}
	})
	location.href="recipeComponentTable.html"
}