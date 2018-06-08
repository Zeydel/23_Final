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
				'<td>' + RecipeDTO.recipeName + '</td>' +
				'<td>' + '<button class="options" id="editRecipeButton" onClick="location.href=\'editRecipeForm.html?id=' + RecipeDTO.recipeID +'\'' + '"> <i class="fas fa-edit"></i> </button>' +
				'<button class="options" onclick="deleteRecipe($(this).val())" value="' + RecipeDTO.recipeID + '"> <i class="fas fa-trash-alt"></i> </button>' + '</td>' + '</tr>'

	}
	
	function deleteRecipe(value){
		event.preventDefault();
		$.ajax({
			url : '/23_Final/rest/recipes/' + value,
			type : 'DELETE',
			dataype : 'json',
			contentType : ("application/json"),
			success : function(){
				$('#recipeTableBody').empty();
				loadRecipes();
			}
		})
	}