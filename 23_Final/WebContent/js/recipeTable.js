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
				'<td>' + '<button class="options" id="edituserbutton" onclick="location.href="> <i class="fas fa-edit"></i> </button>' +
				'<button class="options" onclick="deleteUser($(this).val())" value=""> <i class="fas fa-trash-alt"></i> </button>' + '</td>' + '</tr>'

	}