$(document).ready(function() {
    $('form').each(function(){
        $(this).ajaxForm(function(e, x, xhr) { 
            alert(xhr.responseText); 
        });          
    });
});