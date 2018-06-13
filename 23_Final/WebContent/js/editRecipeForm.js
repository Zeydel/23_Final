document.addEventListener('DOMContentLoaded',function(){
	var urr = window.location.href;
	
	console.log(typeof(URL));
	var URL2 = new URL(urr);
	var id = URL2.searchParams.get("id");
	console.log(id);
	getRecipe(id);
	
	$('#editRecipeForm').submit(function(){
		event.preventDefault();
		updateRecipe();
	})
})

	function getRecipe(recipeID){
		$.ajax({
			url : '/23_Final/rest/recipes/' + recipeID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				$('#recipeID').val(data.recipeID);
				$('#recipeName').val(data.recipeName);
			}
		})
	}

	function updateRecipe(){
		var data = $('#editRecipeForm').serializeJSON();
		$.ajax({
			url : '/23_Final/rest/recipes/edit',
			type : 'POST',
			data : data,
			datatype : 'json',
			contentType : ("application/json"),
			success : function(){
			}
		})
		location.href="recipeTable.html"
	}