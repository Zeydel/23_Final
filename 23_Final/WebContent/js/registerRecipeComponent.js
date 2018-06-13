$(document).ready(function(){
	$('#createRecipeComponentForm').submit(function(){
		event.preventDefault();
		createRecipeComponent();
	})
	
})	

function createRecipeComponent(){
		event.preventDefault();
		var data = $('#createRecipeComponentForm').serializeJSON();
		$.ajax({
			url : '/23_Final/rest/recipeComponent',
			type : 'POST',
			data: data,
			dataType : 'json',
			contentType : ("application/json"),
			success : function(data){
				
			}
		})
		location.href="recipeComponentTable.html"
	}