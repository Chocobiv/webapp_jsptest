blist()
function blist(){
	let listtable = document.querySelector('.listtable')
	$.ajax({
		url : '/jsptest/board/list',
		success : function(re) {
			let b = JSON.parse(re)
			let html = '<tr> <th> 글번호 </th> <th> 제목 </th> <th> 작성자 </th> </tr>'
			
			for(let i=0; i<b.length; i++){
				html += '<tr> <td> '+b[i].bno+' </td> <td> <a onclick="goview('+b[i].bno+')">'+b[i].btitle+'</a> </td> <td> '+b[i].bwriter+' </td> </tr>'
			}
			
			listtable.innerHTML = html
		}
	})
}


function goview(bno){
	localStorage.setItem('bno', JSON.stringify(bno));
	location.href = "view.html"
}