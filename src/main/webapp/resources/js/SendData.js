console.log("Loaded script for send data");
var obj;
var i,j;
var $form = $('#sql-form');
var textEntered=document.getElementById('sql-query');

$form.on('submit',function(e){
e.preventDefault();
console.log("Submit was clicked");

$.ajax({
url:"DB-Portfolio/getResults",
type:'POST',
data:textEntered.value,
success:function(result){
obj = JSON.parse(result);


$('.display-db-output').html(displayTable());
},
fail:function(){
$('.display-db-output').html("error");
}
});

});

function displayTable(){
var table='<table class="output"><thead><tr><td><h2>'+obj[0]+'</h2></td></tr></thead><tbody>';

for(i=1;i<obj.length;i++){
table+="<tr>";
for(j=0;j<obj[i]['data'].length;j++){
table+="<td>"+obj[i]['data'][j]+"</td>";
}
table+="</tr>";
}

table+="</tbody></table>";
return table;
}

