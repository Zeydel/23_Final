$(document).ready(function(){
	
	$('#createRecipeForm').submit(function(){
		event.preventDefault();
		createRecipe();
	})
})

function createRecipe(){
	event.preventDefault();
	$.ajax({
		url : '/23_Final/rest/recipes',
		type : 'POST',
		data: $('#createRecipeForm').serializeJSON(),
		dataType : 'json',
		contentType : ("application/json"),
		success : function(data){

		}
	})
	location.href="recipeTable.html"
}