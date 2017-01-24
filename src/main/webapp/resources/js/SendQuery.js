var el;
var SQL="";
var textEntered=document.getElementById('sql-query');
var charDisplay = document.getElementById('charactersLeft');
function charCount(e){
var  counter;
counter=(180 - (textEntered.value.length));
if(counter<1){
charDisplay.textContent="MAX STRING LENGTH";
$('.send-sql').attr('disabled',true);
$('.send-sql').css({'background-color':'red'});
}else{
charDisplay.textContent=counter;
$('.send-sql').attr('disabled',false);
$('.send-sql').css({'background-color':'green'});
}
}



el=document.getElementById('sql-query');
el.addEventListener('keyup',charCount,false);