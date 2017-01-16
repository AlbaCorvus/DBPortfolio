$(function(){

var xhr = new XMLHttpRequest();
const button = document.getElementById("test_button");

button.addEventListener('click','grabTables',false);

var grabTables = function(){

xhr.onload= function(){
if(xhr.status===200){
responseObject=JSON.parse(xhr.responseText);
document.getElementById("test_tables").innerHTML=""+xhr.responseText;
console.log(responseObject);
}
};
xhr.open('GET','db/import',true);
xhr.send(null);

}




});