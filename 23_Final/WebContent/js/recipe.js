$(document).ready(function(){
	loadRecipes();
	
})

	function loadRecipes(){
		$.ajax({
			url : '/23_Final/rest/recipes',
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$.each(data, function(i, el){
					$('#recipeTableBody').append(generateRecipeHTML(el));
				})
			}
		})
	}
	
	function generateRecipeHTML(RecipeDTO){
		return '<tr><td>' + RecipeDTO.recipeID + '</td>' +
				'<td>' + RecipeDTO.recipeName + '</td>';

	}