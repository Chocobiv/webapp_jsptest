
var bno = JSON.parse(localStorage.getItem('bno'))
bview(bno)


function bview(bno){
	//let viewtable = document.querySelector('.viewtable')
	$.ajax({
		url : '/jsptest/board/view',
		data : {"bno":bno},
		success : function(re) {
			let board = JSON.parse(re)
			//let html = '<tr> <th> 글번호 </th> <th> 제목 </th> <th> 작성자 </th> </tr>'
			document.querySelector('.bno').innerHTML = board.bno
			document.querySelector('.btitle').innerHTML = board.btitle
			document.querySelector('.bcontent').innerHTML = board.bcontent
			document.querySelector('.bwriter').innerHTML = board.bwriter
			document.querySelector('.bdate').innerHTML = board.bdate
			document.querySelector('.bview').innerHTML = board.bview
		}
	})
	
}