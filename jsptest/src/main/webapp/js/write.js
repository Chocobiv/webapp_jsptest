
function bwrite(){
	let btitle = document.querySelector('.btitle').value
	let bcontent = document.querySelector('.bcontent').value
	let bwriter = document.querySelector('.bwriter').value
	let bpassword = document.querySelector('.bpassword').value
	
	$.ajax({
		url : '/jsptest/board/write',
		data : {"btitle":btitle, "bcontent":bcontent, "bwriter":bwriter, "bpassword":bpassword},
		success : function(re) {
			if(re === 'true'){
				alert('글 작성 성공')
			}else{ alert('글 작성 실패') }
		}
		
	})
	
	
}



