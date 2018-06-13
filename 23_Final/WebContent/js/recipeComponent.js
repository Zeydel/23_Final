$(document).ready(function(){
	loadRecipeComponent();
	
	

	
})

	function loadRecipeComponent(){
		$.ajax({
			url : '/23_Final/rest/recipeComponent',
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$.each(data, function(i, el){
					$('#RCTableBody').append(generateRecipeComponentHTML(el));
				})
			}
		})
	}

	function generateRecipeComponentHTML(RecipeComponentDTO) {
		return '<tr><td>' + RecipeComponentDTO.recipeID + '</td>' +
				'<td>' + RecipeComponentDTO.rawMaterialID + '</td>' +
				'<td>' + RecipeComponentDTO.nom_netto + '</td>' + 
				'<td>' + RecipeComponentDTO.tolerance + '</td>' +
				'<td>' + '<button class="options" onclick="editRecipeComponent($(this).val())" value="' + RecipeComponentDTO.recipeID + '-' + RecipeComponentDTO.rawMaterial + '"> <i class="fas fa-edit"></i> </button>' +
				'<button class="options" onclick="deleteRecipeComponent($(this).val())" value="' + RecipeComponentDTO.recipeID  + '-' + RecipeComponentDTO.rawMaterialID + '"> <i class="fas fa-trash-alt"></i> </button>'+'</td></tr>';
	}
	
	
	function deleteRecipeComponent(value){
		event.preventDefault();
		$.ajax({
			url : '/23_Final/rest/recipeComponent/' + value,
			type : 'DELETE',
			dataype : 'json',
			contentType : ("application/json"),
			success : function(){
				$('#RCTableBody').empty();
				loadRecipeComponent();
			}
		})
	}
/*	
	
	function updateProductBatch(){
		var data = $('#editProductBatch').serializeJSON();
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
*/