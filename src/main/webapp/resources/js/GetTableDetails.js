
var tableHolder = document.getElementById('table-container');

function getTableDetails(e){

var target=e.target || e.srcElement;
console.log(target);
console.log(target.id);
if(e.preventDefault){
e.preventDefault();
}
else{
event.returnValue =false;
}
loadTableDetails(target.id);
}

function loadTableDetails(elementId){
$.getJSON('DB-Portfolio/db/import/'+elementId)
.done(function(data){
var columns ="";
$.each(data,function(key,val){
columns+= '<li class="columns">'+ val+'</li>';
});
var el=document.getElementById(elementId);
$(el).parent().append(columns);
}).fail(function(){
$(tableHolder).append("<h2>Error</h2>");
});

}

if(tableHolder.addEventListener){
tableHolder.addEventListener('click',function(e){
getTableDetails(e)},false);
}else{
tableHolder.attachEvent('onclick',function(e){
getTableDetails(e)},false);
}


