


function loadTableNames(){
$.getJSON('DB-Portfolio/db/importTables')
.done(function(data){
var msg="<ul>";
$.each(data,function(key,val){
msg+="<li><a id="+val+" href='" + val +"'>" +val+"</a></li>";
});
msg+="</ul>";
$('#table-container').html(msg);
}).fail(function(){
$('#table-container').html("Sorry unable to retrieve table names");
});
}


$('#get_tables').on('click',function(e){
e.preventDefault();
loadTableNames();
});

