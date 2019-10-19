function field_focus(field, field2)
  {
    if(field.value == field2)
    {
      field.value = '';
    }
  }

  function field_blur(field, field2)
  {
    if(field.value == '')
    {
      field.value = field2;
    }
  }

//Fade in dashboard box
$(document).ready(function(){
    $('.box').hide().fadeIn(1000);
    });

//Stop click event
$('a').click(function(event){
    event.preventDefault(); 
	});