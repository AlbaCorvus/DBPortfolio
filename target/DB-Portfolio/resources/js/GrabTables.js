


function loadTableNames(){
$.getJSON('DB-Portfolio/db/import')
.done(function(data){
var msg="<h2>Table Names</h2>";
$.each(data,function(key,val){
msg+="" + key +" : " +val;
});
$('#test_tables').html(msg);
}).fail(function(){
$('#test_tables').html("Sorry unable to retrieve table names");
}).always(function(){
$('#test_button').on('click',function(e){
e.preventDefault();
loadTableNames();
});
});


}

loadTableNames();