function deleteUser(id){
	if(confirm("确定要删除")){
		location.href='deleteUser/'+id;
	}
}
function updateUser(id){
	location.href='updateUser/'+id;
}